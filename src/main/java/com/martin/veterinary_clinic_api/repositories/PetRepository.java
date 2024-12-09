package com.martin.veterinary_clinic_api.repositories;

import com.martin.veterinary_clinic_api.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
