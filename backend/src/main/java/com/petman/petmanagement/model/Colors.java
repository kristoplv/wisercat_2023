package com.petman.petmanagement.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Colors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String color;

    public Colors() {
    }

    public Colors(Integer id, String color) {
        this.id = id;
        this.color = color;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "TYPE{" +
                "Code=" + this.id +
                ", name='" + this.color + '\'' + '}';
    }

}
