package com.trabajo_final.trabajo_final.services;

import com.trabajo_final.trabajo_final.persistence.entities.AutoEmpleado;
import com.trabajo_final.trabajo_final.persistence.entities.Auto;
import com.trabajo_final.trabajo_final.persistence.entities.Empleado;
import com.trabajo_final.trabajo_final.persistence.entities.Reparacion;

import com.trabajo_final.trabajo_final.persistence.repositories.AutoEmpleadoRepository;
import com.trabajo_final.trabajo_final.persistence.repositories.AutoRepository;
import com.trabajo_final.trabajo_final.persistence.repositories.EmpleadoRepository;
import com.trabajo_final.trabajo_final.persistence.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;

@Service
public class AutoEmpleadoService {
    private final AutoEmpleadoRepository autoEmpleadoRepository;
    private final AutoRepository autoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ReparacionRepository reparacionRepository;
    @Autowired
    public AutoEmpleadoService(AutoEmpleadoRepository autoEmpleadoRepository, AutoRepository autoRepository, EmpleadoRepository empleadoRepository, ReparacionRepository reparacionRepository){
        this.autoEmpleadoRepository = autoEmpleadoRepository;
        this.autoRepository = autoRepository;
        this.empleadoRepository = empleadoRepository;
        this.reparacionRepository = reparacionRepository;
    }

    public List<AutoEmpleado> getAllAutoEmpleados(){
        return autoEmpleadoRepository.findAll();
    }
    public Optional<AutoEmpleado> GetAutoEmpleadoById(String id){
        return autoEmpleadoRepository.findById(id);
    }
    public AutoEmpleado createAutoEmpleado(AutoEmpleado autoEmpleado){
        Auto auto = autoRepository.findById(autoEmpleado.getAutoId().getId())
                .orElseThrow(() -> new NoSuchElementException("Auto no encontrado con el id: " + autoEmpleado.getAutoId().getId()));
        Empleado empleado = empleadoRepository.findById(autoEmpleado.getEmpleadoId().getId())
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado con el id: " + autoEmpleado.getEmpleadoId().getId()));
        Reparacion reparacion = reparacionRepository.findById(autoEmpleado.getReparacionId().getId())
                .orElseThrow(() -> new NoSuchElementException("Reparacion no encontrado con el id: " + autoEmpleado.getReparacionId().getId()));

        autoEmpleado.setAutoId(auto);
        autoEmpleado.setEmpleadoId(empleado);
        autoEmpleado.setReparacionId(reparacion);

        return autoEmpleadoRepository.save(autoEmpleado);
    }
    public void deleteAutoEmpleado(String id) {
        autoEmpleadoRepository.deleteById(id);
    }
    public AutoEmpleado updateAutoEmpleado(String id, AutoEmpleado updatedAutoEmpleado){
        AutoEmpleado existingAutoEmpleado = autoEmpleadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("AutoEmpleado no encontrado"));
        existingAutoEmpleado.setAutoId(updatedAutoEmpleado.getAutoId());
        existingAutoEmpleado.setEmpleadoId(updatedAutoEmpleado.getEmpleadoId());
        existingAutoEmpleado.setReparacionId(updatedAutoEmpleado.getReparacionId());

        return autoEmpleadoRepository.save(existingAutoEmpleado);
    }
}
