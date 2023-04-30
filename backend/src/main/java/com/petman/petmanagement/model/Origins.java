package com.petman.petmanagement.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Origins implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String originname;

    public Origins() {
    }

    public Origins(Integer id, String originname) {
        this.id = id;
        this.originname = originname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public void setOrigin(String originname) {
        this.originname = originname;
    }

    public String getOrigin() {
        return originname;
    }

    @Override
    public String toString() {
        return "TYPE{" +
                "Code=" + this.id +
                ", name='" + this.originname + '\'' + '}';
    }

}
