package com.martin.veterinary_clinic_api.services;

import com.martin.veterinary_clinic_api.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    List<Pet> findAll ();
    Optional<Pet> findById (Long id);
    void save (Pet pet);
    void deleteById (Long id);
    Optional<Object> update (Pet pet);
}
