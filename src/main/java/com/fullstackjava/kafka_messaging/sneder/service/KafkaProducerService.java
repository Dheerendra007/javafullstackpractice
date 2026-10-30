package com.fullstackjava.kafka_messaging.sneder.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fullstackjava.kafka_messaging.sneder.config.AppConstants;

@Service 
public class KafkaProducerService {

    @Autowired 
    private KafkaTemplate<String,String> kafkaTemplate;
    
    private Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

public void updateLocation(String value) {

    System.out.println("3. Sending message: " + value);

    kafkaTemplate.send("location-update-topic", value)
        .whenComplete((result, exception) -> {

            if (exception != null) {
                System.out.println("Kafka ERROR: " + exception.getMessage());
            } else {
                System.out.println("Kafka SUCCESS!");
                System.out.println("Topic: " +
                    result.getRecordMetadata().topic());
                System.out.println("Offset: " +
                    result.getRecordMetadata().offset());
            }
        });

    System.out.println("4. Kafka send invoked");
}
    
}
