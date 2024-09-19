package com.coapatap.api.controller;


import com.coapatap.api.persistence.entity.EmpleadosEntity;
import com.coapatap.api.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadosEntity>> getAllEmpleados() {
        return ResponseEntity.ok(this.empleadoService.getAllEmpleados());
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {
        try {
            List<EmpleadosEntity> empleadosEntities = this.empleadoService.getAllEmpleados();
            System.out.println("Número de empleados: " + empleadosEntities.size()); // Verifica el tamaño de la lista
            if (empleadosEntities == null || empleadosEntities.isEmpty()) {
                System.out.println("La lista de empleados está vacía o es null.");
            } else {
                System.out.println("Empleados encontrados: " + empleadosEntities);
            }
            model.addAttribute("empleados", empleadosEntities);

            return "inicio";
        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola para tener más información
            return "error";
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosEntity> getIdEmpleado(@PathVariable int id) {
        return ResponseEntity.ok(this.empleadoService.getEmpleadoById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<EmpleadosEntity> saveEmpleado(@RequestBody EmpleadosEntity empleado) {
        if (empleado.getIdEmpleado() == null || this.empleadoService.existsEmpleados(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoService.saveEmpleados(empleado));
        }
        return ResponseEntity.badRequest().build();
    }

    

    @PutMapping("/update")
    public ResponseEntity<EmpleadosEntity> updateEmpleado(@RequestBody EmpleadosEntity empleado) {
        if (empleado.getIdEmpleado() != null && this.empleadoService.existsEmpleados(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoService.saveEmpleados(empleado));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpleados(@PathVariable int id) {
        if (this.empleadoService.existsEmpleados(id)) {
            this.empleadoService.deleteEmpleados(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}