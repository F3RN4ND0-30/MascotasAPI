package com.mascotas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record MascotaRequest(
        @NotNull(message = "Falta nombre papu") String nombre,
        @NotNull(message = "Falta raza papu") String raza,
        @NotNull(message = "Falta edad papu") @PositiveOrZero(message = "No puedes deber años") Integer edad,
        @NotNull @PositiveOrZero(message = "Falta tipo mascota papu") Long tipoMascotaId){

}
