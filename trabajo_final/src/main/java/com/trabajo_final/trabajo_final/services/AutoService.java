package com.trabajo_final.trabajo_final.services;

import com.trabajo_final.trabajo_final.persistence.entities.Auto;
import com.trabajo_final.trabajo_final.persistence.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;

@Service
public class AutoService {
    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
    public List<Auto> getAllAutos() {
        return autoRepository.findAll();
    }
    public Optional<Auto> getAutoById(String id) {
        return autoRepository.findById(id);
    }

    public Auto createAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    public void deleteAuto(String id) {
        autoRepository.deleteById(id);
    }

    public Auto updateAuto(String id, Auto updatedAuto) {
        Auto existingAuto = autoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Auto no encontrado"));
        existingAuto.setPatente(updatedAuto.getPatente());
        existingAuto.setModelo(updatedAuto.getModelo());
        existingAuto.setColor(updatedAuto.getColor());
        //existingAuto.setEmpleadosId(updatedAuto.getEmpleadosId());

        return autoRepository.save(existingAuto);
    }
}