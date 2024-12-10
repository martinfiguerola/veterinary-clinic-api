package com.martin.veterinary_clinic_api.services;

import com.martin.veterinary_clinic_api.dtos.PetOwnerDTO;
import com.martin.veterinary_clinic_api.entities.Pet;
import com.martin.veterinary_clinic_api.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Optional<Object> update(Pet pet) {

        Optional<Pet> optionalPet = this.findById(pet.getId());
        if (optionalPet.isEmpty()) return Optional.empty();
        Pet petDb = optionalPet.get();
        petDb.setName(pet.getName());
        petDb.setSpecies(pet.getSpecies());
        petDb.setBreed(pet.getBreed());
        petDb.setColor(pet.getColor());

        petRepository.save(petDb);
        return Optional.of(petDb);
    }

    @Override
    public List<Pet> findBySpeciesAndBreed(String species, String breed) {
        return petRepository.findBySpeciesAndBreed(species, breed);
    }

    @Override
    public List<PetOwnerDTO> getAllPetsAndOwnerDTO() {
        List<Pet> pets = this.findAll();
        List<PetOwnerDTO> petOwnerDTOS = new ArrayList<>();

        for (Pet pet : pets){
            PetOwnerDTO petOwnerDTO = convertPetOwnerDTO(pet);
            petOwnerDTOS.add(petOwnerDTO);
        }

        return petOwnerDTOS;
    }

    private PetOwnerDTO convertPetOwnerDTO (Pet pet){
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO();

        petOwnerDTO.setPet_name(pet.getName());
        petOwnerDTO.setSpecies(pet.getSpecies());
        petOwnerDTO.setBreed(pet.getBreed());
        petOwnerDTO.setOwner_name(pet.getOwner().getName());
        petOwnerDTO.setOwner_lastname(pet.getOwner().getLastname());

        return petOwnerDTO;
    }

}
