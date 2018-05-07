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

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.Service.ServiceEvent;
import com.codename1.Entite.Event;
import com.codename1.Entite.User;
import com.codename1.Service.ServiceReclamation;
import com.codename1.Service.ServiceUser;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import static com.codename1.Entite.User.connectedUser;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class ReclamationForm extends BaseForm {

    private com.codename1.components.MultiButton gui_Multi_Button_1;
    private com.codename1.components.MultiButton gui_LA;
    private com.codename1.ui.Container cimg;
    private com.codename1.ui.Container gui_Container_2;
    private com.codename1.ui.TextArea gui_Text_Area_1;
    private com.codename1.ui.Button gui_Button_1;
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
    private Container gui_Container_1;
    private Button btn1;
    private TextArea txt1;
    private ComboBox<String> cb;

    public ReclamationForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ReclamationForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);

        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        cimg = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());

        cimg.add(BorderLayout.CENTER, sl);
        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer2.add(BorderLayout.CENTER, sl);

        installSidemenu(resourceObjectInstance);
       
        gui_LA = new com.codename1.components.MultiButton();

        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);

        gui_Text_Area_1 = new com.codename1.ui.TextArea();

        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
    }

  
//-- DON'T EDIT BELOW THIS LINE!!!
//    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Reclamations");
        setTitle("Reclamations");
        cb = new ComboBox<>();

        ServiceReclamation sr = new ServiceReclamation();
        ServiceUser su = new ServiceUser();
        List<User> lu = su.getListP();
        for (User user : lu) {
         cb.addItem(user.getUsername());
        }
        addComponent(cb);

        txt1 = new com.codename1.ui.TextArea();
        addComponent(txt1);
        btn1 = new com.codename1.ui.Button("Envoyer");
        addComponent(btn1);
        
        String nom =cb.getSelectedItem();
        List<User> l1=su.getP(nom);
        int idp;
        User u=new User();
            for (User user : l1) {
                if(user.getUsername().equals(nom))
                { u=user;
                }
            }
            idp=u.getId();
        LocalNotification n = new LocalNotification();
        n.setId("reclmation");
        n.setAlertBody("Reclamation Envoyer avec success");
        n.setAlertTitle("Reclamation!");
        
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    sr.ajoutRec( connectedUser,idp, txt1.getText());
           Dialog.show("Succés", "Reclamation envoyé ! " , "Ok", null);
            Display.getInstance().scheduleLocalNotification(
                        n,
                        System.currentTimeMillis() + 10 * 1000,
                        LocalNotification.REPEAT_NONE
                );
                Message m = new Message(txt1.getText());
                Display.getInstance().sendMessage(new String[]{"cupcake3a11@gmail.com"}, "Reclamation", m);
        
                
            }
        });
         this.show();
        

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    @Override
    protected boolean isCurrentCalendar() {
        return true;
    }
}
