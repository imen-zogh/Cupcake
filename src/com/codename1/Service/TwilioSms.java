/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//TwilioSms sms = new TwilioSms();
//
//        
//        
//        sms.sendSms("l'etudiant "+Session.getUsernameThisUser()+" a choisi l'annonce dont l'addresse est " + colocation.getAdresse());

/**
 *
 * @author Karim
 */
public class TwilioSms {
public static final String ACCOUNT_SID = "ACbf621e8d7a9c7c278f7b11e0325c2285";
    public static final String AUTH_TOKEN = "4148506418dea7f788d08b0799d15b0d";

    public void sendSms(String body) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(new PhoneNumber("+21693207505"),
        new PhoneNumber("+33644601325"), 
        body).create();

    }
}
