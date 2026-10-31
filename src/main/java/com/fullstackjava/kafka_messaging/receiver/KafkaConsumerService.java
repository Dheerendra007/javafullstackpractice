package com.fullstackjava.kafka_messaging.receiver;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service 
public class KafkaConsumerService {

    @KafkaListener(
        topics = "location-update-topic",
        groupId = "group-1"
    )
    public void updateLocation(String value) {
        System.out.println("KAFKA MESSAGE RECEIVED: " + value);
         System.out.println("KAFKA MESSAGE RECEIVED: " + value);
    }
}

