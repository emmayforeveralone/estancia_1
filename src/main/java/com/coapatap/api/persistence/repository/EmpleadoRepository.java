package com.coapatap.api.persistence.repository;


import com.coapatap.api.persistence.entity.EmpleadosEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface EmpleadoRepository extends ListCrudRepository<EmpleadosEntity, Integer> {
}
