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

import com.petman.petmanagement.model.Origins;
import com.petman.petmanagement.service.OriginService;

@RestController
@RequestMapping("/Origin")
public class OriginResource {
    private final OriginService originService;

    private OriginResource(OriginService originService) {
        this.originService = originService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Origins>> getAllOrigins() {
        List<Origins> origins = originService.findAllOrigins();
        return new ResponseEntity<>(origins, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Origins> addOrigin(@RequestBody Origins origin) {
        Origins newOrigin = originService.addOrigins(origin);
        return new ResponseEntity<>(newOrigin, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrigin(@PathVariable("id") Integer id) {
        originService.deleteOrigin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
