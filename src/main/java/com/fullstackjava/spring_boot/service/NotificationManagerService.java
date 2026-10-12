package com.fullstackjava.spring_boot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Class: NotificationManager
 *
 * Purpose:
 * Manages user notifications by delegating notification delivery
 * to the appropriate NotificationService implementation.
 *
 * Dependency Injection:
 * Uses constructor injection to inject NotificationService.
 *
 * @Qualifier Usage:
 * @Qualifier("emailService") tells Spring to inject the bean named
 * "emailService" when multiple implementations of NotificationService
 * are available in the application context.
 *
 * Benefits:
 * 1. Resolves ambiguity when multiple NotificationService beans exist.
 * 2. Supports constructor-based dependency injection.
 * 3. Promotes loose coupling and easier unit testing.
 *
 * Example:
 * When notifyUser() is called, the injected emailService sends
 * the "Welcome!" notification.
 */

@Service 
public class NotificationManagerService {

    private NotificationService notificationService;

    public NotificationManagerService(@Qualifier("EmailService") NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void notifyUser(){
        notificationService.sendNotification("Welcome");
    }

}
