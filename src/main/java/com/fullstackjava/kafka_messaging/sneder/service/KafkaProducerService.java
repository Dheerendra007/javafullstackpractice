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

    public boolean updateLocation(String location){
           this.kafkaTemplate.send(AppConstants.Location_TOPIC_NAME,location);
           this.logger.info("Message Produce");
           return true;
    }
}
