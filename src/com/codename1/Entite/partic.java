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
public class partic {
    private int id;

    private int idUser;

    private int idEvent;

    public partic(int idUser, int idEvent) {
        this.idUser = idUser;
        this.idEvent = idEvent;
    }

    public partic(int id, int idUser, int idEvent) {
        this.id = id;
        this.idUser = idUser;
        this.idEvent = idEvent;
    }

    public partic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public String toString() {
        return "partic{" + "id=" + id + ", idUser=" + idUser + ", idEvent=" + idEvent + '}';
    }
    
    
    

}
