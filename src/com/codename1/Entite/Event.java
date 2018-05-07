/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

import com.codename1.l10n.SimpleDateFormat;

/**
 *
 * @author sana
 */
public class Event {

    private int id;
    private String titre;
    private String descr;
    private String price;
    private String datedeb;
    private String datefin;
    private String adress;
    private String etat;
    private int nbPlaces;
    private int nbReserv;
    private int archive;
    private String imageFile;
    private String imageName;
    private String dd;
    private String df;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getNbReserv() {
        return nbReserv;
    }

    public void setNbReserv(int nbReserv) {
        this.nbReserv = nbReserv;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }
    
    

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", titre=" + titre + ", descr=" + descr + ", price=" + price + ", datedeb=" + datedeb + ", datefin=" + datefin + ", adress=" + adress + ", etat=" + etat + ", nbPlaces=" + nbPlaces + ", nbReserv=" + nbReserv + ", archive=" + archive + ", imageFile=" + imageFile + ", imageName=" + imageName + '}';
    }
    
    

}
