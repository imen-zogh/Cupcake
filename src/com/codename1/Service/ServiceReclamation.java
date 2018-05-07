/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.Reclamation;
import com.codename1.Entite.User;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author user16
 */
public class ServiceReclamation {
      public void ajoutRec (int idu,int idp, String content) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/cake1/web/app_dev.php/f/AjouRec/" + idu + "/" + idp+ "/" + content;
        con.setUrl(Url);
            System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}
