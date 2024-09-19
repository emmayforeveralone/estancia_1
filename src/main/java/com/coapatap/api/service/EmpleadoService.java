package com.coapatap.api.service;

import com.coapatap.api.persistence.entity.EmpleadosEntity;
import com.coapatap.api.persistence.entity.TipoDeEquipoEntity;
import com.coapatap.api.persistence.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<EmpleadosEntity> getAllEmpleados() {
        return this.empleadoRepository.findAll();
    }

    public EmpleadosEntity getEmpleadoById(int id) {
        return this.empleadoRepository.findById(id).get();
    }

    public boolean existsEmpleados(int id) {
        return this.empleadoRepository.existsById(id);
    }

    @Transactional
    public EmpleadosEntity saveEmpleados(EmpleadosEntity empleadosEntity) {
        return this.empleadoRepository.save(empleadosEntity);
    }

    @Transactional(readOnly = true)
    public void saveImageEmplo(Integer idEmpleado, String fileName) {
        Optional<EmpleadosEntity> empleadoOpt = empleadoRepository.findById(idEmpleado);
        if (empleadoOpt.isPresent()) {
            EmpleadosEntity empleado = empleadoOpt.get();
            empleado.setImagen(fileName);
            empleadoRepository.save(empleado);
        } else {
            throw new RuntimeException("Empleado no encontrado con ID: " + idEmpleado);
        }
    }

    public void deleteEmpleados(int id) {
        this.empleadoRepository.deleteById(id);
    }
}
