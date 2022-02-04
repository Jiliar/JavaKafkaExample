package com.jsolution.kafkaexample.controller;

import com.jsolution.kafkaexample.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("KafkaController")
public class KafkaController {

    @Autowired
    private KafkaService kafkaProducer;

    @GetMapping("send/{message}/{kafkaTopic}")
    public String sendMessage(@PathVariable("message") String message,
                              @PathVariable("kafkaTopic") String kafkaTopic) {
        String respuesta = "¡Message has been sent successfully!";
        try {
            kafkaProducer.send(message, kafkaTopic);
        } catch (Exception e) {
            respuesta = e.getLocalizedMessage();
        }
        return respuesta;

    }
}
