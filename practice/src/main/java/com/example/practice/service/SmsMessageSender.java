package com.example.practice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender {
    private String apiKey;

    public SmsMessageSender(@Value("${sms.api.key:default-key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void send(String rec, String m) {
        System.out.println("[SMS] send to " + rec + ":" + m);
    }
}

