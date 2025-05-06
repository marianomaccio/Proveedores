package com.proveedores.proveedores_service.service;

import com.proveedores.proveedores_service.dto.ResponseProveedorDTO;
import com.proveedores.proveedores_service.entity.ProveedorEntity;
import com.proveedores.proveedores_service.repository.ProveedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProveedorServiceTest {
    @Mock
    private ProveedorRepository repository;

    @InjectMocks
    private ProveedorService service;

    @Test
    void ListaDeProveedoresExistentesPorIdCliente() {
        Long idCliente = 5L;
        List<ProveedorEntity> mockProveedores = List.of(
                new ProveedorEntity (1L, "Coca-cola", LocalDate.now(), idCliente),
                new ProveedorEntity (2L, "Pepsi", LocalDate.now(), idCliente)
        );

        when(repository.buscarPorIdCliente(idCliente)).thenReturn(mockProveedores);

        List<ResponseProveedorDTO> resultado = service.obtenerProveedoresPorCliente(idCliente);

        assertEquals(2, resultado.size());
        assertEquals("Coca-cola", resultado.get(0).getNombre());
    }

    @Test
    void ListaDeProveedoresVacia() {
        Long idCliente = 1L;
        List<ProveedorEntity> mockProveedores = null;

        when(repository.buscarPorIdCliente(idCliente)).thenReturn(mockProveedores);

        List<ResponseProveedorDTO> resultado = service.obtenerProveedoresPorCliente(idCliente);

        assertEquals(0, resultado.size());
    }
}
