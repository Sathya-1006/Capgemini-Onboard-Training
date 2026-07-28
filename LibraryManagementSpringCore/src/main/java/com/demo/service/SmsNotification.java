package com.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification() {

        System.out.println("Sending SMS...");

    }

}