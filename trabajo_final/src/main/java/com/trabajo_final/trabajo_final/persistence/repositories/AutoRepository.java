package com.trabajo_final.trabajo_final.persistence.repositories;

import com.trabajo_final.trabajo_final.persistence.entities.Auto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutoRepository extends MongoRepository<Auto, String>{
}