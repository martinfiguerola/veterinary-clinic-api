package com.martin.veterinary_clinic_api.controllers;

import com.martin.veterinary_clinic_api.entities.Owner;
import com.martin.veterinary_clinic_api.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> findAll () {
        return ownerService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create (@RequestBody Owner owner) {
        ownerService.save(owner);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> findOne ( @PathVariable Long id) {
         Optional<Owner> optionalOwner = ownerService.findById(id);
         if (optionalOwner.isEmpty()) return ResponseEntity.notFound().build();
         return ResponseEntity.ok(optionalOwner.orElseThrow());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        ownerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update (@RequestBody Owner owner) {
       Optional<Object> optionalObject = ownerService.update(owner);

       if (optionalObject.isEmpty()) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(optionalObject.orElseThrow());
    }



}
