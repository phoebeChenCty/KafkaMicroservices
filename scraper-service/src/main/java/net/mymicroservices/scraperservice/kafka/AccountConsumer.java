package net.mymicroservices.scraperservice.kafka;

import net.mymicroservices.basedomains.dto.AccountEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.consumername}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(AccountEvent event) {
        LOGGER.info(String.format("Account event recevied in scraper service => %s", event.toString()));
        // send email to customer
    }

}
