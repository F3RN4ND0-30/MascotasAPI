package com.mascotas.service;

import java.util.List;

import com.mascotas.models.Mascota;

public interface IMascotaService {
    List<Mascota> findAll();

    Mascota findById(Long id);

    Mascota create(Mascota mascota);

    void update(Mascota mascota);
    
    void delete(Long id);
}
