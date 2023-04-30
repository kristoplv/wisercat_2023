package com.petman.petmanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petman.petmanagement.model.Pets;
import com.petman.petmanagement.repo.PetsRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PetsService {
    private final PetsRepo petsRepo;

    @Autowired
    public PetsService(PetsRepo petsRepo) {
        this.petsRepo = petsRepo;
    }

    public Pets addPets(Pets pets) {
        pets.setCode(UUID.randomUUID());
        return petsRepo.save(pets);
    }

    public List<Pets> findAllPets() {
        return petsRepo.findAll();
    }

    public List<Pets> findPetsByOwnerID(Long petownerID) {
        return petsRepo.findBypetownerID(petownerID);
    }

    public Pets updatePets(Pets pets) {
        return petsRepo.save(pets);
    }

    public void deletePet(Long id) {
        petsRepo.deletePetById(id);
    }

}
