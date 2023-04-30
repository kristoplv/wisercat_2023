package com.petman.petmanagement.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petman.petmanagement.model.Pets;

public interface PetsRepo extends JpaRepository<Pets, Long> {
    void deletePetById(Long id);

    List<Pets> findBypetownerID(Long petownerID);
}
