package com.proveedores.proveedores_service.service;

import com.proveedores.proveedores_service.dto.ResponseProveedorDTO;
import com.proveedores.proveedores_service.entity.ProveedorEntity;
import com.proveedores.proveedores_service.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository repository;

    public List<ResponseProveedorDTO> obtenerProveedoresPorCliente(Long idCliente){
        List<ProveedorEntity> proveedores = repository.buscarPorIdCliente(idCliente);
        if (proveedores == null)
            return Collections.emptyList();
        return proveedores.stream().map(this::mapToDto).toList();
    }

    private ResponseProveedorDTO mapToDto(ProveedorEntity proveedor) {
        return ResponseProveedorDTO.builder()
                .idProveedor(proveedor.getIdProveedor())
                .nombre(proveedor.getNombre())
                .fechaDeAlta(proveedor.getFechaDeAlta())
                .build();
    }
}
