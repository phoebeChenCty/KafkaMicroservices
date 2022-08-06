package net.mymicroservices.scraperservice.kafka;

import net.mymicroservices.basedomains.dto.WebinfoEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WebinfoProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebinfoProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, WebinfoEvent> kafkaTemplate;

    public WebinfoProducer(NewTopic topic, KafkaTemplate<String, WebinfoEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(WebinfoEvent event) {
        LOGGER.info(String.format("Webinfo Event => %s", event.toString()));

        Message<WebinfoEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

}
