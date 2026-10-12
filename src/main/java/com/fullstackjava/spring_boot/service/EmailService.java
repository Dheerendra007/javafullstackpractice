package com.fullstackjava.spring_boot.service;

import org.springframework.stereotype.Service;

//@Primary /* Now Spring prefers EmailService when injecting NotificationService without a qualifier, unless another resolution rule applies. */
@Service("EmailService")
public class EmailService implements NotificationService{

    @Override
    public void sendNotification(String message) {
             System.out.println("Email: " + message);
    }

}
