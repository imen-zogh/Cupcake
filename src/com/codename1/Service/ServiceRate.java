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
public class ServiceRate {
    public void ajoutRate (int ide, float rate) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/cake1/web/app_dev.php/f/addrate/" + ide+ "/" + rate;
        con.setUrl(Url);
            System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public ArrayList<Rate> getRate(int id ) {
        ArrayList<Rate> listr = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/discplayrate/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> adresses = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) adresses.get("root");
                    for (Map<String, Object> obj : list) {
                        Rate r = new Rate();
                        float id = Float.parseFloat(obj.get("id").toString());
                        r.setVal((int) (double)obj.get("rate"));
                        r.setNbr((int) (double)obj.get("nbre_rate"));
                        listr.add(r);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listr;
    }
}
