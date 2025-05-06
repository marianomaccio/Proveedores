package com.proveedores.proveedores_service.repository;

import com.proveedores.proveedores_service.entity.ProveedorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProveedorRepositoryImplTest {

    @Mock
    private ProveedorJpaInternal repoInterno;

    @InjectMocks
    private ProveedorRepositoryImpl repositoryImpl;

    @Test
    void buscarPorIdCliente() {
        // Arrange
        Long idCliente = 5L;
        List<ProveedorEntity> mockLista = List.of(
                new ProveedorEntity (1L, "Coca-cola", LocalDate.now(), idCliente),
                new ProveedorEntity (2L, "Pepsi", LocalDate.now(), idCliente)
        );
        when(repoInterno.findByIdCliente(idCliente)).thenReturn(mockLista);

        List<ProveedorEntity> resultado = repositoryImpl.buscarPorIdCliente(idCliente);

        assertEquals(2, resultado.size());
        verify(repoInterno, times(1)).findByIdCliente(idCliente);
    }
}
