package net.mymicroservices.registerservice.kafka;

import net.mymicroservices.basedomains.dto.AccountEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, AccountEvent> kafkaTemplate;

    public AccountProducer(NewTopic topic, KafkaTemplate<String, AccountEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(AccountEvent event) {
        LOGGER.info(String.format("Account Event => %s", event.toString()));

        Message<AccountEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

}
