package com.fullstackjava.spring_boot.service;

import org.springframework.stereotype.Service;

@Service("SmsService")
public class SmsService implements NotificationService{

    @Override
    public void sendNotification(String message) {
                     System.out.println("SMS: " + message);

    }

}
