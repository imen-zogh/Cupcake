/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.Pub;
import com.codename1.Entite.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user16
 */
public class ServicePub {
    
    
public ArrayList<Pub> getListpub() {
        ArrayList<Pub> listUser = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/allPub");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> users = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("root");
                    for (Map<String, Object> obj : list) {
                        Pub us = new Pub();
                        float id = Float.parseFloat(obj.get("id").toString());
                        us.setId((int) id);
                        us.setDescription(obj.get("description").toString());
                        us.setImage_name(obj.get("imageName").toString());
                        us.setNompatisserie(obj.get("nompatisserie").toString());

                        listUser.add(us);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUser;
    }

}
