package com.trabajo_final.trabajo_final.services;

import com.trabajo_final.trabajo_final.persistence.entities.Usuario;
import com.trabajo_final.trabajo_final.persistence.entities.RolUsuario;
import com.trabajo_final.trabajo_final.persistence.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        usuarioRepository.save(new Usuario("1", "Diego", hashedPassword, "diego@digital.com", true, true, true, true, RolUsuario.ADMIN));
        usuarioRepository.save(new Usuario("2","Paula", hashedPassword2, "paula@digital.com",true, true, true, true, RolUsuario.USER));
    }
}
