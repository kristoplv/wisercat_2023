package com.petman.petmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petman.petmanagement.exceptions.UserNotFoundException;

import com.petman.petmanagement.model.Accounts;
import com.petman.petmanagement.repo.AccountRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {
    private final AccountRepo accRepo;

    @Autowired
    public AccountService(AccountRepo accRepo) {
        this.accRepo = accRepo;
    }

    public Accounts addAccounts(Accounts account) {
        return accRepo.save(account);
    }

    public List<Accounts> findAllAccounts() {
        return accRepo.findAll();
    }

    public Accounts findAccByID(Integer id) {
        return accRepo.findAccById(id)
                .orElseThrow(() -> new UserNotFoundException("No user found"));
    }

    public Accounts findAccByLOGIN(String username, String password) {
        return accRepo.findAccByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("No user found with these credentials"));
    }

    public void deleteAccount(Integer id) {
        accRepo.deleteAccById(id);
    }
}
