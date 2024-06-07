package com.coapatap.api.service;

import com.coapatap.api.persistence.entity.TipoDeEquipoEntity;
import com.coapatap.api.persistence.repository.TipoDeEquipoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeEquipoService {

    private final TipoDeEquipoRepository tipoDeEquipoRepository;

    public TipoDeEquipoService(TipoDeEquipoRepository tipoDeEquipoRepository) {
        this.tipoDeEquipoRepository = tipoDeEquipoRepository;
    }

    public List<TipoDeEquipoEntity> getAllTipoDeEquipos() {
        return this.tipoDeEquipoRepository.findAll();
    }

    public TipoDeEquipoEntity getByIdTipoDeEquipo(int id) {
        return this.tipoDeEquipoRepository.findById(id).orElse(null);
    }

    public TipoDeEquipoEntity saveTipoDeEquipo(TipoDeEquipoEntity tipoDeEquipo) {
        return this.tipoDeEquipoRepository.save(tipoDeEquipo);
    }

    public boolean existsTipoDeEquipo(int id) {
        return this.tipoDeEquipoRepository.existsById(id);
    }

    public void deleteTipoDeEquipo(int id) {
        this.tipoDeEquipoRepository.deleteById(id);
    }
}
