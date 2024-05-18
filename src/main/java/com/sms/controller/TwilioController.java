package com.sms.controller;

import com.sms.Service.TwilioService;
import com.sms.payload.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class TwilioController {

    private final TwilioService twilioService;

    @Autowired
    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }
  //http://localhost:8080/api/sms/send
    @PostMapping("/send")
    public void sendSMS(@RequestBody SmsRequest smsRequest) {
        twilioService.sendSMS(smsRequest.getTo(), smsRequest.getMessage());
    }
}


