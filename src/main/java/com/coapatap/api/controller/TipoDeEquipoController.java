package com.coapatap.api.controller;

import com.coapatap.api.persistence.entity.TipoDeEquipoEntity;
import com.coapatap.api.service.TipoDeEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class TipoDeEquipoController {

    private final TipoDeEquipoService tipoDeEquipoService;

    @Autowired
    public TipoDeEquipoController(TipoDeEquipoService tipoDeEquipoService) {
        this.tipoDeEquipoService = tipoDeEquipoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDeEquipoEntity>> getAllTipoDeEquipo() {
        return ResponseEntity.ok(this.tipoDeEquipoService.getAllTipoDeEquipos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeEquipoEntity> getByIdTipoDeEquipo(@PathVariable int id) {
        return ResponseEntity.ok(this.tipoDeEquipoService.getByIdTipoDeEquipo(id));
    }

    @PostMapping("/save")
    public ResponseEntity<TipoDeEquipoEntity> addTipoDeEquipo(@RequestBody TipoDeEquipoEntity tipoDeEquipo) {
        if (tipoDeEquipo.getIdTipoDeEquipo() == null || this.tipoDeEquipoService.existsTipoDeEquipo(tipoDeEquipo.getIdTipoDeEquipo())){
            return ResponseEntity.ok(this.tipoDeEquipoService.saveTipoDeEquipo(tipoDeEquipo));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<TipoDeEquipoEntity> updateTipoDeEquipo(@RequestBody TipoDeEquipoEntity tipoDeEquipo) {
        if (tipoDeEquipo.getIdTipoDeEquipo() != null && this.tipoDeEquipoService.existsTipoDeEquipo(tipoDeEquipo.getIdTipoDeEquipo())){
            return ResponseEntity.ok(this.tipoDeEquipoService.saveTipoDeEquipo(tipoDeEquipo));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTipoDeEquipo(@PathVariable int id) {
        if (this.tipoDeEquipoService.existsTipoDeEquipo(id)) {
            this.tipoDeEquipoService.deleteTipoDeEquipo(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
