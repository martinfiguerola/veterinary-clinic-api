package com.martin.veterinary_clinic_api.services;

import com.martin.veterinary_clinic_api.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService{

    List<Owner> findAll ();
    Optional<Owner> findById (Long id);
    void save (Owner owner);
    void deleteById (Long id);
    Optional<Object> update (Owner owner);

}
