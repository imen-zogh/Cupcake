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

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.Service.ServiceUser;
import com.codename1.Entite.User;
import com.codename1.Service.TwilioSms;
import com.codename1.ui.util.UITimer;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class inscrForm extends Form {

    public inscrForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public inscrForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 ;
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private ComboBox<String> cb1;

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_1.addActionListener(callback);

    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {

        private com.codename1.ui.Component cmp;

        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if (sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }

        private void onButton_1ActionEvent(ActionEvent ev) {
             if (gui_Text_Field_2.getText().equals("") )  {
               
                    Dialog.show("Erreur", "Nom d'utilisateur ne doit pas etre null ", "Ok", null);
                
                }          
                else if (gui_Text_Field_1.getText().equals(""))  {
                
                 Dialog.show("Erreur", "Le mot de passe ne doit pas etre null ", "Ok", null);
                    
                }    
                
                else if (gui_Text_Field_3.getText().equals(""))  {
                
                 Dialog.show("Erreur", "L'email ne doit pas etre null ", "Ok", null);
                    
                }    
            
                else{
            String type = cb1.getSelectedItem();
            if (type.equals("Client")) {
                  TwilioSms sms = new TwilioSms();
              sms.sendSms("Bienvenue a Cupcake"+ gui_Text_Field_3.getText()+"\n"+"Password :" +gui_Text_Field_1.getText() );

           
                ServiceUser s1 = new ServiceUser();
                User u = new User(gui_Text_Field_2.getText(), gui_Text_Field_3.getText(), gui_Text_Field_1.getText());
                s1.ajoutCUser(u);
                Dialog.show("Inscription avec succés", "Bienvenu a cupcake " + gui_Text_Field_2.getText(), "Ok", null);
                new SignInForm().show();
            } else if (type.equals("Patisserie")) {
                 TwilioSms sms = new TwilioSms();
              sms.sendSms("Bienvenue a Cupcake"+ gui_Text_Field_3.getText()+"\n"+"Password :" +gui_Text_Field_1.getText() );
                ServiceUser s1 = new ServiceUser();
                User u = new User(gui_Text_Field_2.getText(), gui_Text_Field_3.getText(), gui_Text_Field_1.getText());
                s1.ajoutPUser(u);
                Dialog.show("Inscription avec succés", "Bienvenu a cupcake " + gui_Text_Field_2.getText(), "Ok", null);
              
              new SignInForm().show();
             }
            
                }
            
            
        }
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());

        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        cb1 = new ComboBox<>("Client", "Patisserie");
        gui_Component_Group_1.addComponent(cb1);
        gui_Text_Field_2 = new TextField("", "Nom d'utilisateur");
        gui_Text_Field_2.setName("username");
        gui_Text_Field_1 = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
        gui_Text_Field_1.setName("password");
        gui_Text_Field_3 = new TextField("", "Adresse mail");
        gui_Text_Field_3.setName("email");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Component_Group_1.addComponent(gui_Text_Field_3);


        gui_Container_1.addComponent(gui_Button_1);
        gui_Button_1.setText("S'inscrire");
        gui_Button_1.setName("Button_1");
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");

    }// </editor-fold>

}
