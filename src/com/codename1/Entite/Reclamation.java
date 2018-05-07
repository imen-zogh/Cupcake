/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

import com.codename1.l10n.SimpleDateFormat;

/**
 *
 * @author user16
 */
public class Reclamation {
 private  int id_reclamation;
 private int id_client ;
 private String content;
 private SimpleDateFormat date_rec;
 private int id_patisserie;
 private int status;

    public Reclamation() {
    }

    public Reclamation(int id_client, String content, int id_patisserie) {
        this.id_client = id_client;
        this.content = content;
        this.id_patisserie = id_patisserie;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
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

    public SimpleDateFormat getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(SimpleDateFormat date_rec) {
        this.date_rec = date_rec;
    }

    public int getId_patisserie() {
        return id_patisserie;
    }

    public void setId_patisserie(int id_patisserie) {
        this.id_patisserie = id_patisserie;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
 
 
 
}
