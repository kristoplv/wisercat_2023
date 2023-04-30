package com.petman.petmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petman.petmanagement.model.Origins;
import com.petman.petmanagement.repo.OriginRepo;

import jakarta.transaction.Transactional;

@Service
public class OriginService {
    private final OriginRepo originRepo;

    @Autowired
    public OriginService(OriginRepo originRepo) {
        this.originRepo = originRepo;
    }

    public Origins addOrigins(Origins origin) {
        return originRepo.save(origin);
    }

    public List<Origins> findAllOrigins() {
        return originRepo.findAll();
    }

    @Transactional
    public void deleteOrigin(Integer id) {
        originRepo.deleteOriginById(id);
    }
}
