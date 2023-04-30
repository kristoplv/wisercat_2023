package com.petman.petmanagement;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petman.petmanagement.model.Types;
import com.petman.petmanagement.service.typeService;

@RestController
@RequestMapping("/types")
public class TypesResource {
    private final typeService typesService;

    private TypesResource(typeService typesService) {
        this.typesService = typesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Types>> getAllTypes() {
        List<Types> types = typesService.findAllTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Types> addTypes(@RequestBody Types types) {
        Types newType = typesService.addTypes(types);
        return new ResponseEntity<>(newType, HttpStatus.CREATED);
    }
}
