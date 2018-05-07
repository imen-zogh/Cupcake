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
public class adresse {
    private int id;
    private String adres;
    private double latit;
    private double longit;

    public adresse() {
    }

    
    public adresse(int id, String adres, double latit, double longit) {
        this.id = id;
        this.adres = adres;
        this.latit = latit;
        this.longit = longit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public double getLatit() {
        return latit;
    }

    public void setLatit(double latit) {
        this.latit = latit;
    }

    public double getLongit() {
        return longit;
    }

    public void setLongit(double longit) {
        this.longit = longit;
    }
    
    
    
    
}
