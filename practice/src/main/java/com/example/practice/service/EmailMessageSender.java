package com.example.practice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailMessageSender implements MessageSender {

    private String smtpServer;

    public EmailMessageSender(@Value("${smtp.server:smtp.example.com}") String smtpServer) {
        this.smtpServer = smtpServer;
        System.out.println("EmailMessageSender initialized with SMTP: " + smtpServer);
    }

    @Override
    public void send(String taker, String msg) {
        System.out.println("[EMAIL] send to " + taker + ":" + msg);
    }
}