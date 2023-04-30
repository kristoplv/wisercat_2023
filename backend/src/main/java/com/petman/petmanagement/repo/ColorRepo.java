package com.petman.petmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petman.petmanagement.model.Colors;

public interface ColorRepo extends JpaRepository<Colors, Integer> {
    void deleteColorById(Integer id);
}
