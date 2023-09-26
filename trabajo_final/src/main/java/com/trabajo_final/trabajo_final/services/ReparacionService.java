package com.trabajo_final.trabajo_final.services;

import com.trabajo_final.trabajo_final.persistence.entities.Reparacion;
import com.trabajo_final.trabajo_final.persistence.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;
@Service
public class ReparacionService {
    private final ReparacionRepository reparacionRepository;

    @Autowired
    public  ReparacionService(ReparacionRepository reparacionRepository){
        this.reparacionRepository = reparacionRepository;
    }
    public List<Reparacion> getAllReparaciones(){
        return reparacionRepository.findAll();
    }
    public Optional<Reparacion> GetReparacionById(String id){
        return reparacionRepository.findById(id);
    }
    public Reparacion createReparacion(Reparacion reparacion){
        return reparacionRepository.save(reparacion);
    }
    public void deleteReparacion(String id) {
        reparacionRepository.deleteById(id);
    }
    public Reparacion updateReparacion(String id, Reparacion updatedReparacion){
        Reparacion existingReparacion = reparacionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reparacion no encontrada"));
        existingReparacion.setDescripcion(updatedReparacion.getDescripcion());

        return reparacionRepository.save(existingReparacion);
    }
}
