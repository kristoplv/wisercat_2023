package com.petman.petmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petman.petmanagement.model.Colors;
import com.petman.petmanagement.repo.ColorRepo;

import jakarta.transaction.Transactional;

@Service
public class ColorService {
    private final ColorRepo colorRepo;

    @Autowired
    public ColorService(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }

    public Colors addColor(Colors color) {
        return colorRepo.save(color);
    }

    public List<Colors> findAllColors() {
        return colorRepo.findAll();
    }

    @Transactional
    public void deleteColor(Integer id) {
        colorRepo.deleteColorById(id);
    }
}
