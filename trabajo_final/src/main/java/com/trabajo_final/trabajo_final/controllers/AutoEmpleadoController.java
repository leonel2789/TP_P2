package com.trabajo_final.trabajo_final.controllers;

import com.trabajo_final.trabajo_final.persistence.entities.AutoEmpleado;
import com.trabajo_final.trabajo_final.services.AutoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/autoempleados")
public class AutoEmpleadoController {
    private final AutoEmpleadoService autoEmpleadoService;
    @Autowired
    public AutoEmpleadoController(AutoEmpleadoService autoEmpleadoService){
        this.autoEmpleadoService = autoEmpleadoService;
    }
    @GetMapping
    public ResponseEntity<List<AutoEmpleado>> getAllAutoEmpleados(){
        List<AutoEmpleado> autoEmpleados = autoEmpleadoService.getAllAutoEmpleados();
        return ResponseEntity.ok(autoEmpleados);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutoEmpleado> getAutoEmpleadoById(@PathVariable String id){
        Optional<AutoEmpleado> autoEmpleado = autoEmpleadoService.GetAutoEmpleadoById(id);
        return autoEmpleado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/crear")
    public ResponseEntity<AutoEmpleado> createAutoEmpleado(@RequestBody AutoEmpleado autoEmpleado){
        AutoEmpleado createdAutoEmpleado = autoEmpleadoService.createAutoEmpleado(autoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAutoEmpleado);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteAutoEmpleado(@PathVariable String id){
        autoEmpleadoService.deleteAutoEmpleado(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<AutoEmpleado> updateAutoEmpleado(@PathVariable String id, @RequestBody AutoEmpleado updatedAutoEmpleado){
        AutoEmpleado updated = autoEmpleadoService.updateAutoEmpleado(id, updatedAutoEmpleado);
        return ResponseEntity.ok(updated);
    }
}
