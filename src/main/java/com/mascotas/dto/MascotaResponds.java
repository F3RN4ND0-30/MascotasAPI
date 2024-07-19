package com.mascotas.dto;

public record MascotaResponds(
    String nombre,
    String raza,
    Integer edad,
    TipoMascotaResponds tipoMascota
) {

}
