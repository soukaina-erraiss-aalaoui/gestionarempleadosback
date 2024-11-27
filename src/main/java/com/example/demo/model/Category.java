package com.example.demo.model;


import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    public Category() {
    }
    public Category(long id, String nom, String description) {
        this.id = id;
        this.name = nom;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nom='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
