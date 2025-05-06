package com.proveedores.proveedores_service.repository;


import com.proveedores.proveedores_service.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorJpaInternal extends JpaRepository<ProveedorEntity, Long> {
    List<ProveedorEntity> findByIdCliente(Long idCliente);
}
