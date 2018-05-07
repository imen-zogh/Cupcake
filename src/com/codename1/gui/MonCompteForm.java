/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui;

import static com.codename1.Entite.User.connectedUser;
import com.codename1.Service.ServiceUser;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import java.io.IOException;

/**
 *
 * @author user16
 */
public class MonCompteForm extends BaseForm{

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

    
      public MonCompteForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public  MonCompteForm(com.codename1.ui.util.Resources resourceObjectInstance) {
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
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ACCOUNT_BOX, e -> {
        });
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
 private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        try {
            setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            setTitle("Mon Compte");
            
            Label l1= new Label();        
            l1.setIcon(Image.createImage("/user-man-circle-invert-512.png"));
            addComponent(l1);

            
            
            MultiButton m3 = new com.codename1.components.MultiButton();
            addComponent(m3);
            m3.setUIID("Label2");
            m3.setName("Multi_Button_3");
            m3.setPropertyValue("line1", "Evenements ");
            m3.setPropertyValue("uiid1", "RedLabel");
            
            
            
            MultiButton m2 = new com.codename1.components.MultiButton();
            addComponent( m2);
            m2.setUIID("Label1");
            m2.setName("Multi_Button_2");
            m2.setPropertyValue("line1", "Supprimer mon compte");
            m2.setPropertyValue("uiid1", "RedLabel");
            
            ServiceUser su =new ServiceUser();
               m2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  su.deleteUser(connectedUser);
                  new SignInForm().show();

                }
            });
               
              m3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                new Myevents(resourceObjectInstance).show();

                }
            });
        } catch (IOException ex) {
        }
          
        
 }    
}
