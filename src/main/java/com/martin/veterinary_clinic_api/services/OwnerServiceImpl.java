package com.martin.veterinary_clinic_api.services;

import com.martin.veterinary_clinic_api.entities.Owner;
import com.martin.veterinary_clinic_api.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Optional<Object> update(Owner owner) {
        Optional<Owner> optionalOwner = this.findById(owner.getId());
        if (optionalOwner.isEmpty()){
            return Optional.empty();
        }
        Owner ownerDb = optionalOwner.orElseThrow();
        ownerDb.setName(owner.getName());
        ownerDb.setPhoneNumber(owner.getPhoneNumber());
        ownerDb.setLastname(owner.getLastname());

        ownerRepository.save(ownerDb);
        return Optional.of(ownerDb);
    }
}
