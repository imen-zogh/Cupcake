package com.codename1.gui;

import com.codename1.googlemaps.MapContainer;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.Service.ServiceEvent;
import com.codename1.Entite.Event;
import com.codename1.Entite.adresse;
import java.io.IOException;
import java.util.ArrayList;

public class GoogleMap {

    private Form current;

    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int id) {
        try {
            if (current != null) {
                current.show();
                return;
            }
            
            
            

            ServiceEvent s1 = new ServiceEvent();
            ArrayList<Event> list = s1.getList2();
            Event e = new Event();
            for (Event ev : list) {
                if (ev.getId() == id) {
                    e = ev;
                }
            }
            int ide = e.getId();
            System.out.println(e);

            ArrayList<adresse> list2 = s1.getList1();
            adresse ad = new adresse();
            for (adresse ev : list2) {
                if (e.getAdress().equals(ev.getAdres())) {
                    ad = ev;
                }
            }
            System.out.println(ad);
            double lat = ad.getLatit();
            double longi = ad.getLongit();
            System.out.println(lat);
            System.out.println(lat);

            Form hi = new Form();
            hi.setLayout(new BorderLayout());
            
              hi.setToolbar(new Toolbar(true));
         Form last = Display.getInstance().getCurrent();
         hi.getToolbar().setBackCommand("", eee -> last.show());
            
            Location position = LocationManager.getLocationManager().getCurrentLocationSync();
            double latit=position.getLatitude();
            double longit=position.getLongitude();
            
//            LocalNotification ln= new LocalNotification();
//             ln.setId("LnMessage");
//            ln.setAlertTitle("Welcome");
//            ln.setAlertBody("Thanks for arriving!");
//            Display.getInstance().scheduleLocalNotification(ln, 10000, LocalNotification.REPEAT_NONE);

            
            final MapContainer cnt = new MapContainer();
            hi.addComponent(BorderLayout.CENTER, cnt);
            cnt.setCameraPosition(new Coord(lat, longi));
            String tit = e.getTitre();
            String tit1 = e.getAdress();
            cnt.addMarker(EncodedImage.create("/marker.png"), new Coord(lat, longi), "Hi marker", "Optional long description", new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Dialog.show(tit, tit1, "OK", null);
                }
            });
             hi.getToolbar().addCommandToLeftBar(new Command("Directions ?"));
            hi.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                          try {
                        cnt.setCameraPosition(new Coord(lat, longi));
                        cnt.addMarker(EncodedImage.create("/marker.png"), new Coord(latit, longit), "Hi marker", "Optional long description", new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                Dialog.show("", "Ma position", "OK", null);
                            }
                        });
                        
                        cnt.addPath(new Coord(lat, longi), // Sydney
                                new Coord(latit, longit) // Fiji

                        );
                    } catch (IOException ex) {
                    }
                }
            });

                
       
//            hi.addCommand(new Command("Back") {
//                public void actionPerformed(ActionEvent ev) {
//                    try {
//                        Resources theme = Resources.openLayered("/theme");
//                        new DetailsForm(theme).start(ide);
//                    } catch (IOException ex) {
//                    }
//
//                }
//            });

            hi.show();
        } catch (IOException ex) {
        }
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }

}
