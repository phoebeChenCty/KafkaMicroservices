package net.mymicroservices.storeservice.kafka;

import net.mymicroservices.basedomains.dto.WebinfoEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WebinfoConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebinfoConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(WebinfoEvent event) {
        LOGGER.info(String.format("webinfo event recevied in store service=> %s", event.toString()));
        // save to database
    }

}
