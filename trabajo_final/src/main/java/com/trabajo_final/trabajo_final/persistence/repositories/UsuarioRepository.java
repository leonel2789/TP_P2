package com.trabajo_final.trabajo_final.persistence.repositories;


import com.trabajo_final.trabajo_final.persistence.entities.Usuario;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
@Transactional(readOnly = true)
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
