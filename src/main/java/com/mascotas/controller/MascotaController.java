package com.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mascotas.models.Mascota;
import com.mascotas.service.IMascotaService;

@RestController
@RequestMapping("api/v1/mascotas")
public class MascotaController {
    @Autowired
    private IMascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> findAll() {
        return ResponseEntity.ok(mascotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Mascota> create(@RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.create(mascota));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Mascota mascota) {
        mascotaService.update(mascota);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mascotaService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
