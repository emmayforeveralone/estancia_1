package com.coapatap.api.controller;

import com.coapatap.api.persistence.entity.InventarioEntity;
import com.coapatap.api.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public ResponseEntity<List<InventarioEntity>> getAll(){
        return ResponseEntity.ok(this.inventarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioEntity> getIdInventario(@PathVariable int id){
        return ResponseEntity.ok(this.inventarioService.getInventID(id));
    }

    @PostMapping("/save")
    public ResponseEntity<InventarioEntity> addInventario(@RequestBody InventarioEntity inventario){
        return ResponseEntity.ok(this.inventarioService.saveInventario(inventario));
    }
}
