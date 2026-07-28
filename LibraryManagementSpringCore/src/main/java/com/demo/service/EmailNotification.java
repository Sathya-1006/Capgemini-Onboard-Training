package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification() {

        System.out.println("Sending Email...");

    }

}