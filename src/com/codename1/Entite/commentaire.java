/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

/**
 *
 * @author jihed
 */
public class commentaire {

    private int id_commentaire;
    private int id_client;
    private String content;
    private int id_event;

    public commentaire() {
    }

    public commentaire(int id_commentaire, int id_client, String content, int id_event) {
        this.id_commentaire = id_commentaire;
        this.id_client = id_client;
        this.content = content;
        this.id_event = id_event;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }
    
    
}
