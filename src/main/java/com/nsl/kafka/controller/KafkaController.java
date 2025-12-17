package com.nsl.kafka.controller;

import com.nsl.kafka.producer.KafkaProducer;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class KafkaController {

    @Value("${app.kafka.topic.topic-A}")
    private String topicA;

    @Value("${app.kafka.topic.topic-B}")
    private String topicB;

    @Autowired
    private KafkaProducer kafkaProducer;

    //controller to send fasUpgrade request
    @PostMapping("/publishKafkaTopicA")
    public String publishMessage1(@RequestBody String message) {
        log.info("Inside publishMessage1 controller, received message ::: {}", message);
        kafkaProducer.sendMessageToTopicA(topicA, message);
        log.info("Message {} have been sent to topicA ::: {}", message, topicA);
        return "Message sent to Kafka topic-A";
    }

    //controller to send string request
    @PostMapping("/publishKafkaTopicB")
    public String publishMessage2(@RequestParam String message) {
        log.info("Inside publishMessage2 controller, received message ::: {}", message);
        kafkaProducer.sendMessageToTopicB(topicB, message);
        log.info("Message {} have been sent to topicB ::: {}", message, topicB);
        return "Message sent to Kafka topic-B";
    }

    @GetMapping(path = "/welcome")
    public ResponseEntity<String> welcome(@RequestBody String reqJson) {
        return ResponseEntity.ok().body(new JSONObject().put("code", "200").put("message", "Kafka Server is up!").toString());
    }

}
