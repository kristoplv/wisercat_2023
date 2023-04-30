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

import com.petman.petmanagement.model.Accounts;
import com.petman.petmanagement.service.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountResource {
    private final AccountService accService;

    private AccountResource(AccountService accService) {
        this.accService = accService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        List<Accounts> accounts = accService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account) {
        Accounts newAccount = accService.addAccounts(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Integer id) {
        accService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findAccByID(@PathVariable("id") Integer id) {
        Accounts accounts = accService.findAccByID(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/findone/{username}&{password}")
    public ResponseEntity<?> findAccByLOGIN(@PathVariable("username") String username,
            @PathVariable("password") String password) {
        Accounts accounts = accService.findAccByLOGIN(username, password);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
