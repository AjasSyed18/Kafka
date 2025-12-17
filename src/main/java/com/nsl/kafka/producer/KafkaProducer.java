package com.nsl.kafka.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }*/

    public void sendMessageToTopicA(String topic, String message) {
        /*Message<String> msg = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();*/
        kafkaTemplate.send(topic, message);
        log.info("Message sent successfully to Topic-A!!!");
    }

    public void sendMessageToTopicB(String topic, String message) {
        /*Message<String> build = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();*/
        kafkaTemplate.send(topic, message);
        log.info("Message sent successfully to Topic-B!!!");
    }
}
