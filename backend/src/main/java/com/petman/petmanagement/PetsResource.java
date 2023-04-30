package com.petman.petmanagement;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petman.petmanagement.model.Pets;
import com.petman.petmanagement.service.PetsService;

@RestController
@RequestMapping("/pets")
public class PetsResource {
    private final PetsService petsService;

    private PetsResource(PetsService petsService) {
        this.petsService = petsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pets>> getAllPets() {
        List<Pets> pets = petsService.findAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Pets>> findPetsByOwnerID(@PathVariable("id") Long petownerID) {
        List<Pets> pets = petsService.findPetsByOwnerID(petownerID);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pets> addPets(@RequestBody Pets pets) {
        Pets newPet = petsService.addPets(pets);
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pets> updatePets(@RequestBody Pets pets) {
        Pets updatePet = petsService.updatePets(pets);
        return new ResponseEntity<>(updatePet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
        petsService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
