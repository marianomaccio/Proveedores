package com.proveedores.proveedores_service.controller;

import com.proveedores.proveedores_service.dto.ResponseProveedorDTO;
import com.proveedores.proveedores_service.service.ProveedorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProveedorControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void buscarProveedores_porId(){
        Long clienteId = 5L;
        String url = "/proveedores/" + clienteId;

        ResponseEntity<List<ResponseProveedorDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<ResponseProveedorDTO> lista = response.getBody();
        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertTrue(lista.stream().anyMatch(p -> p.getNombre().equals("Coca-cola")));
        assertTrue(lista.stream().anyMatch(p -> p.getNombre().equals("Pepsi")));
    }

    @Test
    void buscarProveedoresClienteInexistente() {

        Long clienteIdInexistente = 999L;
        String url = "/proveedores/" + clienteIdInexistente;

        // Act
        ResponseEntity<List<ResponseProveedorDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<ResponseProveedorDTO> lista = response.getBody();
        assertNotNull(lista);
        assertTrue(lista.isEmpty(), "La lista debería estar vacía si el cliente no tiene proveedores");
    }
}

