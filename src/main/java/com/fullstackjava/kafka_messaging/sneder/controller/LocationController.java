package com.fullstackjava.kafka_messaging.sneder.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fullstackjava.kafka_messaging.sneder.service.KafkaProducerService;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/location")
public class LocationController {
    
    @Autowired 
    private KafkaProducerService kafkaProducerService;
 
  @PostMapping("/update")
public ResponseEntity<?> updateLocation() {

  //  System.out.println("1. API called");
for(int i=0 ;i<200000;i++){
    kafkaProducerService.updateLocation(
        "(" + Math.round(Math.random() * 100) + ")"+i
    );
}

   // System.out.println("2. Kafka method completed");

    return ResponseEntity.ok(
        Map.of("message", "Location updated")
    );
}

/*@PostMapping("/update")
public ResponseEntity<?> updateLocation() {

    System.out.println("API called");

    return ResponseEntity.ok(
        Map.of("message", "Location updated successfully")
    );
}*/
    

}
