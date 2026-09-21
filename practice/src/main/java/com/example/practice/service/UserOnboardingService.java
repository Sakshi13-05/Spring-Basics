package com.example.practice.service;

import org.springframework.stereotype.Component;

@Component
public class UserOnboardingService {
    private final Notification notify;

    UserOnboardingService(Notification notify) {
        this.notify = notify;
    }

    public void registerUser() {
        System.out.println("User registered!");
        notify.send("user on board");
    }

}