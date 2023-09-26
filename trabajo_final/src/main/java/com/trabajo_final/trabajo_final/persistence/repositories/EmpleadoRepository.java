package com.trabajo_final.trabajo_final.persistence.repositories;

import com.trabajo_final.trabajo_final.persistence.entities.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
}
