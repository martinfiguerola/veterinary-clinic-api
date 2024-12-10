package com.martin.veterinary_clinic_api.dtos;


public class PetOwnerDTO {

    private String pet_name;
    private String species;
    private String breed;
    private String owner_name;
    private String owner_lastname;

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_lastname() {
        return owner_lastname;
    }

    public void setOwner_lastname(String owner_lastname) {
        this.owner_lastname = owner_lastname;
    }
}


