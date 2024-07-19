package com.mascotas.mapper;

import com.mascotas.dto.TipoMascotaRequest;
import com.mascotas.dto.TipoMascotaResponds;
import com.mascotas.models.TipoMascota;

public class TipoMascotaMapper {
    public static TipoMascotaResponds entityToDto(TipoMascota tipoMascota) {
        return new TipoMascotaResponds(tipoMascota.getNombre());
    }

    public static TipoMascota dtoToEntity(TipoMascotaResponds tipomascotaResponds) {
        return TipoMascota.builder()
                .nombre(tipomascotaResponds.nombre())
                .build();
    }
}
