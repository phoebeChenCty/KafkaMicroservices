package net.mymicroservices.storeservice.kafka;

import net.mymicroservices.basedomains.dto.AccountEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(AccountEvent event) {
        LOGGER.info(String.format("Account event recevied in store service=> %s", event.toString()));
        // save to database
    }

}
