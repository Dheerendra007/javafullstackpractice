package com.fullstackjava.spring_boot.service;

@Service("EmailService")
public class SmsService implements NotificationService{

    @Override
    public void sendNotification(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendNotification'");
    }

}
