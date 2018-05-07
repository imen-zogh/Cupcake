package com.codename1.gui;

import com.codename1.Entite.Pub;
import com.codename1.mycompany.MyApplication;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;

public class pub extends Form {

    private Pub p;

    public pub(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_Button.addActionListener((evt) -> {
            MyApplication.navigate("prev");
        });
        gui_Button_1.addActionListener((evt) -> {
            MyApplication.navigate("next");
        });
        gui_Button_2.addActionListener((evt) -> {
            InboxForm b = new InboxForm();
            b.showBack();
        });
    }

    public void setPub(Pub p) {
        gui_Label.setText(p.getDescription());
        gui_Label_1.setText(p.getNompatisserie());
        Image i = URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false), "http://localhost/cake1/web/images/" + p.getImage_name(), "http://localhost/cake1/web/images/" + p.getImage_name());
        gui_Image_Viewer.setImage(i);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.components.ImageViewer gui_Image_Viewer = new com.codename1.components.ImageViewer();
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("pub");
        setName("pub");
        addComponent(gui_Button);
        addComponent(gui_Button_1);
        addComponent(gui_Button_2);
        addComponent(gui_Image_Viewer);
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        gui_Button.setPreferredSizeStr("73.03133mm 5.7154956mm");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue5c4".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "1.9051651mm 53.67647% auto 9.138656%").setReferenceComponents(gui_Button, "2 -1 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
        gui_Button_1.setPreferredSizeStr("80.22862mm 6.35055mm");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"\ue5c8".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "auto 2.328535mm 0.0mm 9.756098%").setReferenceComponents(gui_Button_1, "-1 3 0 0 ").setReferencePositions(gui_Button_1, "0.0 0.0 0.0 1.0");
        gui_Button_2.setPreferredSizeStr("88.90771mm 7.4089756mm");
        gui_Button_2.setText("Acceuil");
                gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2,"\ue88a".charAt(0));
        gui_Button_2.setDisabledIcon(com.codename1.ui.FontImage.createMaterial("\ue5c4".charAt(0), gui_Button_2.getDisabledStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_2.getParent().getLayout()).setInsets(gui_Button_2, "1.9051651mm 21.35785% auto 17.963224%").setReferenceComponents(gui_Button_2, "-1 3 3 3 ").setReferencePositions(gui_Button_2, "0.0 0.0 1.0 0.0");
        gui_Image_Viewer.setPreferredSizeStr("81.922104mm 53.767994mm");
                gui_Image_Viewer.setInlineStylesTheme(resourceObjectInstance);
        gui_Image_Viewer.setName("Image_Viewer");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Image_Viewer.getParent().getLayout()).setInsets(gui_Image_Viewer, "32.27586% 10.621243% 8.238825% 11.022043%").setReferenceComponents(gui_Image_Viewer, "-1 -1 -1 -1").setReferencePositions(gui_Image_Viewer, "0.0 0.0 0.0 0.0");
        gui_Label.setPreferredSizeStr("32.387806mm 17.146486mm");
        gui_Label.setUIID("nom");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label.setTextPosition(com.codename1.ui.Component.TOP);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "32.317883% auto auto -4.8687506mm").setReferenceComponents(gui_Label, "2 -1 -1 2 ").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        gui_Label_1.setPreferredSizeStr("69.432686mm 26.883997mm");
        gui_Label_1.setUIID("description");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Label_1.setTextPosition(com.codename1.ui.Component.TOP);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm auto 20.487804%").setReferenceComponents(gui_Label_1, "4 1 -1 -1").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
