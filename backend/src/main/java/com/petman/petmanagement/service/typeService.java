package com.petman.petmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petman.petmanagement.model.Types;
import com.petman.petmanagement.repo.TypesRepo;

@Service
public class typeService {
    private final TypesRepo typesRepo;

    @Autowired
    public typeService(TypesRepo typesRepo) {
        this.typesRepo = typesRepo;
    }

    public Types addTypes(Types types) {
        return typesRepo.save(types);
    }

    public List<Types> findAllTypes() {
        return typesRepo.findAll();
    }
}
