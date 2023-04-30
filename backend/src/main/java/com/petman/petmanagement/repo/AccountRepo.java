package com.petman.petmanagement.repo;

import java.util.Optional;

import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petman.petmanagement.model.Accounts;

public interface AccountRepo extends JpaRepository<Accounts, Any> {
    void deleteAccById(Integer id);

    Optional<Accounts> findAccById(Integer id);

    Optional<Accounts> findAccByUsernameAndPassword(String username, String password);
}
