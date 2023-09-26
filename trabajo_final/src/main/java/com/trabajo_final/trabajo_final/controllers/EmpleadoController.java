package com.trabajo_final.trabajo_final.controllers;

import com.trabajo_final.trabajo_final.persistence.entities.Empleado;
import com.trabajo_final.trabajo_final.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados(){
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.ok(empleados);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable String id){
        Optional<Empleado> empleado = empleadoService.getEmpleadoById(id);
        return empleado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/crear")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado){
        Empleado createdEmpleado = empleadoService.createEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmpleado);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable String id){
        empleadoService.deleteAuto(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable String id, @RequestBody Empleado updatedEmpleado){
        Empleado updated = empleadoService.updateEmpleado(id, updatedEmpleado);
        return ResponseEntity.ok(updated);
    }
}
