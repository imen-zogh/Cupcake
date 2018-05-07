
package com.codename1.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.Service.ServiceUser;
import com.codename1.Entite.User;
import static com.codename1.Entite.User.connectedUser;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {

    public void installSidemenu(Resources res) {
        try {
            Image selection = res.getImage("selection-in-sidemenu.png");
            
            Image inboxImage = null;
            if (isCurrentInbox()) {
                inboxImage = selection;
            }
            
            Image trendingImage = null;
            if (isCurrentTrending()) {
                trendingImage = selection;
            }
            
            Image calendarImage = null;
            if (isCurrentCalendar()) {
                calendarImage = selection;
            }
            
            Image statsImage = null;
            if (isCurrentStats()) {
                statsImage = selection;
            }
            
            System.out.println("*****" + connectedUser);
            Button inboxButton = new Button("Accueil", inboxImage);
            inboxButton.setUIID("SideCommand");
            inboxButton.getAllStyles().setPaddingBottom(0);
            Container inbox = FlowLayout.encloseMiddle(inboxButton);
            inbox.setLeadComponent(inboxButton);
            inbox.setUIID("SideCommand");
            inboxButton.addActionListener(e -> new InboxForm().show());
            getToolbar().addComponentToSideMenu(inbox);
            getToolbar().addCommandToSideMenu("Evenements", trendingImage, e -> new EventsForm(res).show());
            getToolbar().addCommandToSideMenu("Reclamations", calendarImage, e -> new ReclamationForm(res).show());

            ServiceUser s1 = new ServiceUser();
            ArrayList<User> list = s1.getList1();
            User us = new User();
            for (User u : list) {
                if (u.getId() == connectedUser) {
                    us = u;
                }
            }
            
            getToolbar().addComponentToSideMenu(new Label(Image.createImage("/user.png"), "Container"));
            getToolbar().addCommandToSideMenu("  " + us.getUsername(), null, ee -> new MonCompteForm(res).show());

            getToolbar().addCommandToSideMenu("  Se deconnecter", null, ee -> new SplashForm(res).show());
        } catch (IOException ex) {
        }
    }

    protected boolean isCurrentInbox() {
        return false;
    }

    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
