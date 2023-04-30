package com.petman.petmanagement;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petman.petmanagement.model.Colors;
import com.petman.petmanagement.service.ColorService;

@RestController
@RequestMapping("/Color")
public class ColorResource {
    private final ColorService colorService;

    private ColorResource(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Colors>> getAllColors() {
        List<Colors> colors = colorService.findAllColors();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Colors> addColor(@RequestBody Colors color) {
        Colors newColor = colorService.addColor(color);
        return new ResponseEntity<>(newColor, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteColor(@PathVariable("id") Integer id) {
        colorService.deleteColor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}