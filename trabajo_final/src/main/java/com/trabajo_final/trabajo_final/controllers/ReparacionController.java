package com.trabajo_final.trabajo_final.controllers;

import com.trabajo_final.trabajo_final.persistence.entities.Reparacion;
import com.trabajo_final.trabajo_final.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/reparacion")
public class ReparacionController {
    private final ReparacionService reparacionService;
    @Autowired
    public ReparacionController(ReparacionService reparacionService){
        this.reparacionService = reparacionService;
    }
    @GetMapping
    public ResponseEntity<List<Reparacion>> getAllReparaciones(){
        List<Reparacion> reparacion = reparacionService.getAllReparaciones();
        return ResponseEntity.ok(reparacion);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reparacion> getAutoReparacionById(@PathVariable String id){
        Optional<Reparacion> reparacion = reparacionService.GetReparacionById(id);
        return reparacion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/crear")
    public ResponseEntity<Reparacion> createReparacion(@RequestBody Reparacion reparacion){
        Reparacion createdReparacion = reparacionService.createReparacion(reparacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReparacion);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteReparacion(@PathVariable String id){
        reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Reparacion> updateReparacion(@PathVariable String id, @RequestBody Reparacion updatedReparacion){
        Reparacion updated = reparacionService.updateReparacion(id, updatedReparacion);
        return ResponseEntity.ok(updated);
    }
}
