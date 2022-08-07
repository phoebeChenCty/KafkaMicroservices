package net.mymicroservices.emailservice.kafka;

import net.mymicroservices.basedomains.dto.AccountEvent;
import net.mymicroservices.emailservice.entity.KeywordEmailData;
import net.mymicroservices.emailservice.repository.KeywordEmailDataRepository;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountConsumer.class);
    private KeywordEmailDataRepository dataRepository;

    public AccountConsumer(KeywordEmailDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name1}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(AccountEvent event) {
        LOGGER.info(String.format("Account event recevied in email service => %s", event.toString()));
        // save to database
        KeywordEmailData keywordEmailData = new KeywordEmailData();
        keywordEmailData.setKeyword(event.getAccount().getKeyword());
        keywordEmailData.setEmail(event.getAccount().getEmail_address());

        dataRepository.save(keywordEmailData);
    }

}
