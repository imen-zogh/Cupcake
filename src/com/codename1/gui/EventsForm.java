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
import com.codename1.components.Ads;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class EventsForm extends BaseForm {

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

    public EventsForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public EventsForm(com.codename1.ui.util.Resources resourceObjectInstance) {
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
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
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

//-- DON'T EDIT BELOW THIS LINE!!!
//    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Evenements");
        setName("TrendingForm");
        Ads ad = new Ads("ca-app-pub-3940256099942544/6300978111");
        add(ad);

        ServiceEvent s1 = new ServiceEvent();
        ArrayList<Event> list = s1.getList2();

        for (Event ev : list) {

            Container c1 = new Container(new com.codename1.ui.layouts.BorderLayout());
            addComponent(c1);
            MultiButton m1 = new com.codename1.components.MultiButton();
            c1.addComponent(BorderLayout.CENTER, m1);

            m1.setUIID("Label");
            m1.setName("Multi_Button_1");
            m1.setPropertyValue("line1", ev.getTitre());
            m1.setPropertyValue("line2", ev.getDd() + "    " + ev.getDf());
            m1.setPropertyValue("uiid1", "Label");
            m1.setPropertyValue("uiid2", "RedLabel");

            MultiButton m2 = new com.codename1.components.MultiButton();
            m2.setUIID("Label");
            m2.setName("LA");
            m2.setPropertyValue("line1", "Adresse");
            m2.setPropertyValue("line2", ev.getAdress());
            m2.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            m2.setPropertyValue("uiid2", "RedLabelRight");
            c1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, m2);

            Container cimg = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            addComponent(cimg);
            cimg.setName("imageContainer1");

            Container c2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            cimg.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, c2);
            c2.setName("Container_2");
            TextArea txt1 = new com.codename1.ui.TextArea();
            c2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, txt1);
            Button btn1 = new com.codename1.ui.Button();
            c2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, btn1);

            txt1.setText("");
            txt1.setUIID("SlightlySmallerFontLabelLeft");
            txt1.setName("Text_Area_1");

            btn1.setText("");
            btn1.setUIID("Label");
            btn1.setName("Button_1");
            com.codename1.ui.FontImage.setMaterialIcon(btn1, "".charAt(0));
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new DetailsForm(resourceObjectInstance).start(ev.getId());

                }
            });
            Label gui_separator1 = new com.codename1.ui.Label();
            addComponent(gui_separator1);

        }

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}
