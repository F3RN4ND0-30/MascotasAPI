package com.mascotas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascotas.models.Mascota;
import com.mascotas.repository.MascotaRepository;
import com.mascotas.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Long id) {
        return mascotaRepository.findById(id).orElseThrow();
    }

    @Override
    public Mascota create(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void update(Mascota mascota) {
        Mascota mascotaFound = mascotaRepository.findById(mascota.getId()).orElseThrow();
        mascotaFound.setNombre(mascota.getNombre());
        mascotaFound.setRaza(mascota.getRaza());
        mascotaFound.setEdad(mascota.getEdad());
        mascotaRepository.save(mascotaFound);
    }

    @Override
    public void delete(Long id) {
        mascotaRepository.deleteById(id);
    }

}
