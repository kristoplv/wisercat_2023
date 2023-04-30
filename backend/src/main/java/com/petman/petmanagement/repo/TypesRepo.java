package com.petman.petmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petman.petmanagement.model.Types;

public interface TypesRepo extends JpaRepository<Types, Long> {
    void deleteTypeById(Long id);
}
