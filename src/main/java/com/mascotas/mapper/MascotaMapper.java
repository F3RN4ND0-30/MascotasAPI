package com.mascotas.mapper;

import com.mascotas.dto.MascotaRequest;
import com.mascotas.dto.MascotaResponds;
import com.mascotas.models.Mascota;

public class MascotaMapper {
    public static MascotaResponds entityToDto(Mascota mascota) {
        return new MascotaResponds(mascota.getNombre(), mascota.getRaza(), mascota.getEdad(),
                TipoMascotaMapper.entityToDto(mascota.getTipoMascota()));
    }

    public static Mascota dtoToEntity(MascotaResponds mascotaResponds) {
        return Mascota.builder()
                .nombre(mascotaResponds.nombre())
                .edad(mascotaResponds.edad())
                .raza(mascotaResponds.raza())
                .tipoMascota(TipoMascotaMapper.dtoToEntity(mascotaResponds
                        .tipoMascota()))
                .build();
    }
}
