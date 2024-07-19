package com.mascotas.service;

import java.util.List;

import com.mascotas.dto.TipoMascotaRequest;
import com.mascotas.dto.TipoMascotaResponds;
import com.mascotas.models.TipoMascota;

public interface ITipoMascotaService {
    List<TipoMascotaResponds> findAll();

    TipoMascotaResponds findById(Long id);

    TipoMascotaResponds create(TipoMascotaRequest tipoMascotaRequest);

    void update(TipoMascotaRequest tipoMascotaRequest, Long id);

    void delete(Long id);
}
