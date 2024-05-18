package com.sms.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account_sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;

    @Value("${twilio.phone_number}")
    private String TWILIO_PHONE_NUMBER;

    public TwilioService(@Value("${twilio.account_sid}") String ACCOUNT_SID,
                         @Value("${twilio.auth_token}") String AUTH_TOKEN,
                         @Value("${twilio.phone_number}") String TWILIO_PHONE_NUMBER) {
        this.ACCOUNT_SID = ACCOUNT_SID;
        this.AUTH_TOKEN = AUTH_TOKEN;
        this.TWILIO_PHONE_NUMBER = TWILIO_PHONE_NUMBER;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSMS(String to, String body) {
        Message message = Message.creator(
                        new PhoneNumber(to),
                        new PhoneNumber(TWILIO_PHONE_NUMBER),
                        body)
                .create();
        System.out.println("SMS sent successfully with SID: " + message.getSid());
    }
}

