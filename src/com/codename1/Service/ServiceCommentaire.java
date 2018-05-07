/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.commentaire;
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
 * @author jihed
 */
public class ServiceCommentaire {
    public void ajoutCommentaire (int idu,int ide, String content) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/cake1/web/app_dev.php/f/addcom/" + idu + "/" + ide+ "/" + content;
        con.setUrl(Url);
            System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public ArrayList<commentaire> getListcommentaire(int id ) {
        ArrayList<commentaire> listc = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/displaycom/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> adresses = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) adresses.get("root");
                    for (Map<String, Object> obj : list) {
                        commentaire c = new commentaire();
                        float id = Float.parseFloat(obj.get("id").toString());
                        c.setId_commentaire((int) id);
                        c.setContent(obj.get("cont").toString());
                        c.setId_client((int) (double)obj.get("idu"));
                        listc.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listc;
    }
}
