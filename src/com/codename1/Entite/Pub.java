/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

/**
 *
 * @author user16
 */
public class Pub {
    
private int id;
private String description;
private String nompatisserie;
private String image_name;

    public Pub() {
    }

    public Pub(int id, String description, String nompatisserie, String image_name) {
        this.id = id;
        this.description = description;
        this.nompatisserie = nompatisserie;
        this.image_name = image_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNompatisserie() {
        return nompatisserie;
    }

    public void setNompatisserie(String nompatisserie) {
        this.nompatisserie = nompatisserie;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }


}
