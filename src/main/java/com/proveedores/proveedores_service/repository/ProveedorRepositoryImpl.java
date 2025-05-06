package com.proveedores.proveedores_service.repository;

import com.proveedores.proveedores_service.entity.ProveedorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ProveedorRepositoryImpl implements ProveedorRepository{

    private final ProveedorJpaInternal repoInterno;

    @Override
    public List<ProveedorEntity> buscarPorIdCliente(Long idCliente) {
        return repoInterno.findByIdCliente(idCliente);
    }
}
