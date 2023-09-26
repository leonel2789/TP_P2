package com.trabajo_final.trabajo_final.persistence.repositories;

import com.trabajo_final.trabajo_final.persistence.entities.Reparacion;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ReparacionRepository extends MongoRepository<Reparacion,String> {
}
