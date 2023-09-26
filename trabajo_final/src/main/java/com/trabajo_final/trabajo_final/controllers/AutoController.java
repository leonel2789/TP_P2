package com.trabajo_final.trabajo_final.controllers;

import com.trabajo_final.trabajo_final.persistence.entities.Auto;
import com.trabajo_final.trabajo_final.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;


@RestController
@RequestMapping("/autos")
public class AutoController {
    private final AutoService autoService;
    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
    @GetMapping
    public ResponseEntity<List<Auto>> getAllAutos() {
        List<Auto> autos = autoService.getAllAutos();
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable String id) {
        Optional<Auto> auto = autoService.getAutoById(id);
        return auto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
        Auto createdAuto = autoService.createAuto(auto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuto);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable String id) {
        autoService.deleteAuto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable String id, @RequestBody Auto updatedAuto){
        Auto updated = autoService.updateAuto(id, updatedAuto);
        return ResponseEntity.ok(updated);
    }
}
