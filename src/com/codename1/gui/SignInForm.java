package com.codename1.gui;

import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.Service.ServiceUser;
import com.codename1.Entite.User;
import static com.codename1.Entite.User.connectedUser;
import com.codename1.Service.TwilioSms;
import java.io.IOException;

import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignInForm extends Form {
 
    Resources theme = UIManager.initFirstTheme("/theme");

    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
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
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2;
    private com.codename1.ui.TextField gui_Text_Field_1;
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button btnfb = new com.codename1.ui.Button();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
        btnfb.addActionListener(callback);

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

            if (sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
            if (sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
              if (sourceComponent == btnfb) {
                onButtonfbActionEvent(ev);
            }
            
        }

        public void dataChanged(int type, int index) {
        }

        private void onButton_1ActionEvent(ActionEvent ev) {
            new inscrForm().show();
        }

        private void onButtonfbActionEvent(ActionEvent ev) {
                String clientId = "2008278769420484";
                String redirectURI = "https://google.com/";
                String clientSecret = "b71fdc267097febf862252ea183bafa7";
                Login fb = FacebookConnect.getInstance();
                
                fb.setClientId(clientId);
                fb.setRedirectURI(redirectURI);
                fb.setClientSecret(clientSecret);
                //Sets a LoginCallback listener
//                fb.setCallback();
                //trigger the login if not already logged in
                if(!fb.isUserLoggedIn()){
                    fb.doLogin();
                }else{
                    //get the token and now you can query the facebook API
                    String token = fb.getAccessToken().getToken();
                      System.out.println(token);
                }
                

        }
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        try {
            guiBuilderBindComponentListeners();
            setLayout(new com.codename1.ui.layouts.BorderLayout());
            setTitle("Se connecter");
            setName("SignInForm");
            addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
            gui_Container_1.setScrollableY(true);
            gui_Container_1.setName("Container_1");
            gui_Container_1.addComponent(gui_Label_1);
            gui_Container_1.addComponent(gui_Component_Group_1);
            gui_Component_Group_1.setName("Component_Group_1");
            gui_Text_Field_2 = new TextField("", "Nom d'utilisateur");
            gui_Text_Field_2.setName("username");
            gui_Text_Field_1 = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
            gui_Text_Field_1.setName("password");
            gui_Component_Group_1.addComponent(gui_Text_Field_2);
            gui_Component_Group_1.addComponent(gui_Text_Field_1);

            gui_Container_1.addComponent(gui_Button_2);
            gui_Container_1.addComponent(btnfb);
            gui_Container_1.addComponent(gui_Button_3);

            gui_Label_1.setUIID("CenterLabel");
            gui_Label_1.setName("Label_1");
            gui_Label_1.setIcon(Image.createImage("/user-man-circle-invert-512.png"));
            gui_Component_Group_1.setName("Component_Group_1");
            gui_Button_2.setText("Connecter");
            gui_Button_2.setName("Button_2");
            btnfb.setText("Facebook ?");
            FontImage.setMaterialIcon(btnfb, FontImage.MATERIAL_ACCOUNT_CIRCLE);

            gui_Button_3.setText("Mot de passe oublié ?");
            gui_Button_3.setUIID("CenterLabelSmall");
            gui_Button_3.setName("Button_3");
            addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
            gui_Container_1.setScrollableY(true);
            gui_Container_1.setName("Container_1");
            gui_Button_1.setText("Creer un nouveau compte");
            gui_Button_1.setUIID("CenterLabel");
            gui_Button_1.setName("Button_1");
        } // </editor-fold>
        catch (IOException ex) {
        }
    }

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (gui_Text_Field_2.getText().equals("")) {

            Dialog.show("Erreur", "Vous devez saisir le nom d'utilisateur ", "Ok", null);

        } else if (gui_Text_Field_1.getText().equals("")) {

            Dialog.show("Erreur", "Vous devez saisir le mot de passe", "Ok", null);

        } else {
            ServiceUser s1 = new ServiceUser();
            ArrayList<User> list = s1.getList(gui_Text_Field_2.getText(), gui_Text_Field_1.getText());
            System.out.println(list.size());
            System.out.println(list.get(0).getId());

            if (list.size() == 1) {
                connectedUser = list.get(0).getId();
                new InboxForm().show();
              
            }
            else {
                Dialog.show("Données invalides", "Le nom d'utilisateur et le mot de passe que vous avez entré ne correspondent pas à nos enregistrements. Vérifiez et réessayez.", "Ok", null);

            }
        }

    }

}
