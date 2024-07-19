package com.mascotas.service;

import java.util.List;

import com.mascotas.dto.MascotaRequest;
import com.mascotas.dto.MascotaResponds;
import com.mascotas.models.Mascota;

public interface IMascotaService {
    List<MascotaResponds> findAll();

    MascotaResponds findById(Long id);

    MascotaResponds create(MascotaRequest mascotaRequest);

    void update(MascotaRequest mascotaRequest, Long id);
    
    void delete(Long id);
}
