package com.petman.petmanagement.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Pets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private UUID Code;
    @Column(nullable = false, updatable = true)
    private String petname;
    @Column(nullable = false, updatable = true)
    private Integer pettype;
    @Column(nullable = false, updatable = true)
    private String petcolor;
    @Column(nullable = false, updatable = true)
    private String petorigin;
    @Column(nullable = false, updatable = true)
    private Long petownerID;

    public Pets() {
    }

    public Pets(Long id, UUID Code, String petname, Integer pettype, String petcolor, String petorigin,
            Long petownerID) {
        this.id = id;
        this.Code = Code;
        this.petname = petname;
        this.pettype = pettype;
        this.petcolor = petcolor;
        this.petorigin = petorigin;
        this.petownerID = petownerID;
    }

    // OWNER
    public Long getOwner() {
        return petownerID;
    }

    public void setOwner(Long petownerID) {
        this.petownerID = petownerID;
    }

    // petname
    public String getName() {
        return petname;
    }

    public void setName(String petname) {
        this.petname = petname;
    }

    // TYPE
    public Integer getType() {
        return pettype;
    }

    public void setType(Integer pettype) {
        this.pettype = pettype;
    }

    // COLOR
    public String getColor() {
        return petcolor;
    }

    public void setColor(String petcolor) {
        this.petcolor = petcolor;
    }

    // ORIGIN
    public String getOrigin() {
        return petorigin;
    }

    public void setOrigin(String petorigin) {
        this.petorigin = petorigin;
    }

    // CODE
    public UUID getCode() {
        return Code;
    }

    public void setCode(UUID uuid) {
        this.Code = uuid;
    }

    // ID
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "Code=" + this.Code +
                ", name='" + this.petname + '\'' +
                ", type='" + this.pettype + '\'' +
                ", color='" + this.petcolor + '\'' +
                ", origin='" + this.petorigin + '\'' + '}';
    }

}
