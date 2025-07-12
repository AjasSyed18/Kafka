package com.nsl.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsl.kafka.bean.FasUpgrade;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {

    //@KafkaListener to listen the kafka messages
    @KafkaListener(topics = "${app.kafka.topic.topic-A}", groupId = "group_id")
    public void consumeMessageTopicA(String message) throws JsonProcessingException {
        try {
            FasUpgrade fasUpgrade = new ObjectMapper().readValue(message, FasUpgrade.class);
            log.info("Received message ::: {}", fasUpgrade);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse Kafka message into FasUpgrade: {}", message, e);
            // Optionally send to dead-letter topic or alert
        }
    }

    @KafkaListener(topics = "${app.kafka.topic.topic-B}", groupId = "group_id")
    public void consumeMessageTopicB(String message) throws JsonProcessingException {
        log.info("Received message ::: {} ", message);
    }
}
