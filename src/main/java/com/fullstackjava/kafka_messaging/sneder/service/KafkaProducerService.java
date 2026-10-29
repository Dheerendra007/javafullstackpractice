package com.fullstackjava.kafka_messaging.sneder.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fullstackjava.kafka_messaging.sneder.config.AppConstants;

@Service 
public class KafkaProducerService {

    private KafkaTemplate<String,String> kafkaTemplate;
    
    public boolean updateLocation(String location){
           this.kafkaTemplate.send(AppConstants.Location_TOPIC_NAME,location);
           return true;
    }
}
