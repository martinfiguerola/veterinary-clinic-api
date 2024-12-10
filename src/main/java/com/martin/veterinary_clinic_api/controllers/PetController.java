package com.martin.veterinary_clinic_api.controllers;

import com.martin.veterinary_clinic_api.dtos.PetOwnerDTO;
import com.martin.veterinary_clinic_api.entities.Pet;
import com.martin.veterinary_clinic_api.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> findAll () {
        return petService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create (@RequestBody Pet pet) {
        petService.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findOne ( @PathVariable Long id) {
        Optional<Pet> optionalPet = petService.findById(id);
        if (optionalPet.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optionalPet.orElseThrow());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        petService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update (@RequestBody Pet pet) {
        Optional<Object> optionalObject = petService.update(pet);

        if (optionalObject.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optionalObject.orElseThrow());
    }

    @GetMapping("/get")
    public List<Pet> getAllPetsBySpecieAndBreed (@RequestParam String species, @RequestParam String breed) {
        return petService.findBySpeciesAndBreed(species, breed);
    }

    @GetMapping("/owners")
    public List<PetOwnerDTO> findAllOwnersAndPets () {
        return petService.getAllPetsAndOwnerDTO();
    }

}
