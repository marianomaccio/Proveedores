package com.proveedores.proveedores_service.controller;

import com.proveedores.proveedores_service.dto.ResponseProveedorDTO;
import com.proveedores.proveedores_service.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedorService service;

    @GetMapping("/{idCliente}")
    public ResponseEntity<List<ResponseProveedorDTO>> buscarProveedores(@PathVariable(name = "idCliente") Long id){
        List<ResponseProveedorDTO> response = service.obtenerProveedoresPorCliente(id);

        return ResponseEntity.ok().body(response);
    }
}
