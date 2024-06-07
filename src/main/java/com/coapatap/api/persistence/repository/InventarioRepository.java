package com.coapatap.api.persistence.repository;

import com.coapatap.api.persistence.entity.InventarioEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface InventarioRepository extends ListCrudRepository<InventarioEntity, Integer> {

}
