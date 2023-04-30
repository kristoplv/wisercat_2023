package com.petman.petmanagement.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Types implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String typename;

    public Types() {
    }

    public Types(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "TYPE{" +
                "Code=" + this.id +
                ", name='" + this.typename + '\'' + '}';
    }
}
