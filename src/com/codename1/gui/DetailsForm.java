/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.Service.ServiceEvent;
import com.codename1.Entite.Event;
import com.codename1.Entite.User;
import static com.codename1.Service.FacebookShare.token;
import static com.codename1.Entite.User.connectedUser;
import com.codename1.Entite.commentaire;
import com.codename1.Entite.partic;
import com.codename1.Service.FacebookShare;
import com.codename1.Service.Rate;
import com.codename1.Service.ServiceCommentaire;
import com.codename1.Service.ServiceRate;
import com.codename1.Service.ServiceUser;
import com.codename1.components.SpanLabel;
import com.codename1.ui.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple details form
 *
 * @author Shai Almog
 */
public class DetailsForm extends com.codename1.ui.Form {

    ImageViewer imageViewer;
    EncodedImage imgEncodedimage; //recuperer une image stocké dans un serveur 
    URLImage urlImage;

    public DetailsForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public DetailsForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        setToolbar(new Toolbar(true));
        initGuiBuilderComponents(resourceObjectInstance);
        Form last = Display.getInstance().getCurrent();
        getToolbar().setBackCommand("", e -> last.show());
    }

//-- DON'T EDIT BELOW THIS LINE!!!
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("DetailsForm");
        setName("DetailsForm"); 
    }

    public void start(int id) {

        Resources theme = UIManager.initFirstTheme("/theme");

        setLayout(new com.codename1.ui.layouts.FlowLayout());

        ServiceEvent s1 = new ServiceEvent();
        ArrayList<Event> list = s1.getList2();
        Event e = new Event();
        for (Event ev : list) {
            if (ev.getId() == id) {
                e = ev;
            }
        }

        ArrayList<partic> list2 = s1.rechPart(connectedUser, e.getId());
        int tst = list2.size();
        System.out.println(tst);
        int ide = e.getId();

        int nbp = e.getNbPlaces();
        int nbr = e.getNbReserv();

        setTitle(e.getTitre());
        setName("DetailsForm");

        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        imgEncodedimage = EncodedImage.createFromImage(theme.getImage("skate-park.jpg"), false);
        urlImage = URLImage.createToStorage(imgEncodedimage, "http://localhost/cake1/web/images/" + e.getImageName(), "http://localhost/cake1/web/images/" + e.getImageName());
        imageViewer = new ImageViewer(urlImage);
        imageViewer.setHeight(300);
        imageViewer.setWidth(400);

        c.add(imageViewer);
        
        
        /* ********************************************************/
 /* ********************************************************/

 /* ********************************************************/

 /* ********************************************************/
 /* rating*/
        Rate r = new Rate();
        ServiceRate sr = new ServiceRate();
        c.add(r.getF());
        SpanLabel rl = new SpanLabel(String.valueOf(r.getVal()));
        c.add(rl);
        int idevenement = e.getId();
        r.getF().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(r.getF().getProgress());
                sr.ajoutRate(idevenement, r.getF().getProgress());

            }
        });
        /* ********************************************************/
 /* ********************************************************/

 /* ********************************************************/

 /* ********************************************************/
        
        
        MultiButton m1 = new com.codename1.components.MultiButton();

        m1.setUIID("Label");
        m1.setName("Multi_Button_1");
        m1.setPropertyValue("line1", "De : " + e.getDd() + " à  " + e.getDf());
        m1.setPropertyValue("uiid1", "RedLabel");

        TextArea t1 = new TextArea(e.getDescr());
        t1.setRows(4);
        t1.setColumns(100);
        t1.setGrowByContent(false);
        t1.setEditable(false);
        
        Label l = new Label("Prix : " + e.getPrice());
        Label l1 = new Label("Adresse : " + e.getAdress());
//        Label l2 = new Label("De : " + e.getDd()+"   "+" à : " + e.getDf());

        Button redLabel = new Button("Map");
        FontImage.setMaterialIcon(redLabel, FontImage.MATERIAL_LOCATION_ON);

        Button b1 = new Button("Participer");
             Button b2 = new Button("Partager Sur facebook");

        c.add(m1);

        c.add(t1);
        c.add(l);
        c.add(l1);

        c.add(redLabel);
        c.add(b1);
        c.add(b2);

        add(c);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tst == 0) {
                    if (nbr < nbp) {
                        s1.ajoutPar(connectedUser, ide);
                        Dialog.show("Participation avec succés !", "Have fun !", "Ok", null);
                        new EventsForm(theme).show();

                    } else {
                        Dialog.show("Nombre de places !", "Nombre de place est bien limité por cet event ! au prochain evenement.", "Ok", null);

                    }
                } else {
                    Dialog.show("Alert!", "Vous avez deja participé a cet evenement", "Ok", null);

                }
            }
        });
   FacebookShare fb = new FacebookShare(token);
String titre=e.getTitre();
String titre1=e.getAdress();
b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {    
                try {
                    fb.share("Evenement :" + titre+ "\n"+ "Adresse  : "+ titre1);
            Dialog.show("Partage Facebook", "Vous avez partagé cet evenement sur votre journal Facebook !", "Ok", null);

                } catch (IOException ex) {
                }
            
            }
            
        });

        redLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GoogleMap gm= new GoogleMap();
                 gm.start(id);
            }
        });
        
        
        /* ********************************************************/
 /* ********************************************************/

 /* ********************************************************/

 /* ********************************************************/

 /* Commentaire sur evenement*/
        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        TextField T1 = new TextField();
        Button btnc = new Button("Commenter");
        ServiceCommentaire SC = new ServiceCommentaire();
        int ideve= e.getId();
        btnc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SC.ajoutCommentaire(connectedUser, ideve, T1.getText());
                new DetailsForm(theme).start(idevenement);
            }
        });
        List<commentaire> LC = SC.getListcommentaire(id);
        ServiceUser su = new ServiceUser();
        ArrayList<User> lu = new ArrayList<>();
        lu = su.getList1();
        User u1 = new User();
        SpanLabel Lcom = new SpanLabel("Commentaire");
        c2.add(Lcom);
        c2.add(T1);
        c2.add(btnc);
        for (commentaire com : LC) {
            for (User user : lu) {
                if (com.getId_client() == user.getId()) {
                    u1 = user;
                    System.out.println(u1.getUsername());
                    Container c3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(BoxLayout.X_AXIS));
                    Label L1 = new Label(u1.getUsername());
                    SpanLabel T2 = new SpanLabel(com.getContent());
                    c3.add(L1);
                    c3.add(T2);
                    c2.add(c3);
                }

            }
        }
        add(c2);
        /* ********************************************************/

 /* ********************************************************/

 /* ********************************************************/
    
        this.show();
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
