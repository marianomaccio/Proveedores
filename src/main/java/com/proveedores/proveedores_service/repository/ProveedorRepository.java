package com.proveedores.proveedores_service.repository;

import com.proveedores.proveedores_service.entity.ProveedorEntity;

import java.util.List;

public interface ProveedorRepository {
    List<ProveedorEntity> buscarPorIdCliente(Long idCliente);
}
