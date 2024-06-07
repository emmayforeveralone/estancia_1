package com.coapatap.api.service;

import com.coapatap.api.persistence.entity.InventarioEntity;
import com.coapatap.api.persistence.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<InventarioEntity> getAll(){
        return this.inventarioRepository.findAll();
    }

    public InventarioEntity getInventID(int id){
        return this.inventarioRepository.findById(id).orElse(null);
    }

    public InventarioEntity saveInventario(InventarioEntity inventario){
        return this.inventarioRepository.save(inventario);
    }
}
