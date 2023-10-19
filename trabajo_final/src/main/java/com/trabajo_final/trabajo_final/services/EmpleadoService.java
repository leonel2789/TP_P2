package com.trabajo_final.trabajo_final.services;

import com.trabajo_final.trabajo_final.persistence.entities.Empleado;
import com.trabajo_final.trabajo_final.persistence.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;
@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }
    public Optional<Empleado> getEmpleadoById(String id){
        return empleadoRepository.findById(id);
    }
    public Empleado createEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }
    public void deleteAuto(String id){
        empleadoRepository.deleteById(id);
    }
    public Empleado updateEmpleado(String id, Empleado updatedEmpleado){
        Empleado existingEmpleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado"));
        existingEmpleado.setNombre(updatedEmpleado.getNombre());
        existingEmpleado.setApellido(updatedEmpleado.getApellido());
        existingEmpleado.setDNI(updatedEmpleado.getDNI());

        return empleadoRepository.save(existingEmpleado);
    }
}
