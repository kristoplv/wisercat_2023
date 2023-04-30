package com.petman.petmanagement.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Accounts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String username;
    private String password;

    public Accounts() {
    }

    public Accounts(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "TYPE{" +
                ", name='" + this.username + '\'' +
                ", type='" + this.password + '\'' + '}';
    }
}
