package com.mascotas.dto;

import jakarta.validation.constraints.NotNull;

public record TipoMascotaRequest(
    @NotNull(message = "Falta nombre papu") String nombre
) {
    
}
