/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.codename1.Entite.Event;
import com.codename1.Entite.User;
import com.codename1.Entite.adresse;
import com.codename1.Entite.partic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceEvent {

    public ArrayList<Event> getList2() {
        ArrayList<Event> listEvts = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/allev");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event ev = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setTitre(obj.get("titre").toString());
                        ev.setAdress(obj.get("adress").toString());
                        ev.setImageName(obj.get("imageName").toString());
                        ev.setDescr(obj.get("descr").toString());
                        ev.setAdress(obj.get("adress").toString());
                        ev.setNbReserv((int) (double) obj.get("nbReserv"));
                        ev.setNbPlaces((int) (double) obj.get("nbPlaces"));
                        ev.setDd(obj.get("dd").toString());
                        ev.setDf(obj.get("df").toString());

                        if ((obj.get("price").toString().equals("0.0"))) {
                            ev.setPrice("GRATUIT");
                        } else {
                            ev.setPrice(obj.get("price").toString() + "TND");
                        }

                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;
    }

    public ArrayList<partic> rechPart(int idu, int ide) {
        ArrayList<partic> listEvts = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/cake1/web/app_dev.php/f/findpar/" + idu + "/" + ide;
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> partic = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) partic.get("root");
                    for (Map<String, Object> obj : list) {
                        partic ev = new partic();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setIdUser((int) (double) obj.get("idu"));
                        ev.setIdEvent((int) (double) obj.get("ide"));
                        System.out.println(ev);
                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;

    }

    public void ajoutPar(int idu, int ide) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/cake1/web/app_dev.php/f/partic/" + idu + "/" + ide;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
        public ArrayList<adresse> getList1() {
        ArrayList<adresse> lista = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/alladr");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> adresses = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) adresses.get("root");
                    for (Map<String, Object> obj : list) {
                       adresse ev = new adresse();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setAdres(obj.get("adresse").toString());
                        ev.setLatit((double)obj.get("lati"));
                        ev.setLongit((double)obj.get("longi"));
                       

                        lista.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return lista;
    }

    public ArrayList<partic> getList22(int us) {
ArrayList<partic> listEvts = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/cake1/web/app_dev.php/f/findEU/"+ us);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        partic ev = new partic();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setIdEvent((int) (double) obj.get("ide"));
                        ev.setIdUser((int) (double) obj.get("idu"));
                      
                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;    }

}
