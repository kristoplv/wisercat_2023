package com.petman.petmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petman.petmanagement.model.Origins;

public interface OriginRepo extends JpaRepository<Origins, Integer> {
    void deleteOriginById(Integer id);
}
