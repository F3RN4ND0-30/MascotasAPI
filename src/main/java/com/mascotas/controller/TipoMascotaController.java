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

import com.mascotas.dto.TipoMascotaRequest;
import com.mascotas.dto.TipoMascotaResponds;
import com.mascotas.models.TipoMascota;
import com.mascotas.service.ITipoMascotaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/tipo-mascotas")
public class TipoMascotaController {
    @Autowired
    private ITipoMascotaService tipoMascotaService;

    @GetMapping
    public ResponseEntity<List<TipoMascotaResponds>> findAll() {
        return ResponseEntity.ok(tipoMascotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMascotaResponds> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoMascotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoMascotaResponds> create(@RequestBody @Valid TipoMascotaRequest tipoMascotaRequest) {
        return ResponseEntity.ok(tipoMascotaService.create(tipoMascotaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid TipoMascotaRequest tipoMascotaRequest, @PathVariable Long id) {
        tipoMascotaService.update(tipoMascotaRequest, id);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoMascotaService.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
