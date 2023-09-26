package com.trabajo_final.trabajo_final.persistence.repositories;

import com.trabajo_final.trabajo_final.persistence.entities.AutoEmpleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutoEmpleadoRepository extends MongoRepository<AutoEmpleado, String>{
}
