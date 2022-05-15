package com.example.myapplication.Models;

import java.io.Serializable;

public class Professeur implements Serializable {

    private String name;
    private String prenom;
    private String email;
    private String key;
    private String img;
    public Professeur(String name, String prenom) {
        this.name = name;
        this.prenom = prenom;
    }
    public Professeur(String name, String prenom, String email,String role) {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
    }
    public Professeur() {}

    public Professeur(String name, String prenom, String email) {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
    }

    public Professeur(String name, String prenom, String email, String role, String img) {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", key='" + key + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}