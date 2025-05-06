package com.proveedores.proveedores_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProveedorDTO {

    private Long idProveedor;

    private String nombre;

    private LocalDate fechaDeAlta;
}
