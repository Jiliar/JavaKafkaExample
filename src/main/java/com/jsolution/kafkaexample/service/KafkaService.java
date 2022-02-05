package com.jsolution.kafkaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void send(String message, String kafkaTopic) {
        var result = kafkaTemplate.send(kafkaTopic, message);
        result.completable()
               .whenComplete(
                       (stringStringSendResult, throwable) ->{
                           System.out.println(stringStringSendResult);
                       });
    }
}
