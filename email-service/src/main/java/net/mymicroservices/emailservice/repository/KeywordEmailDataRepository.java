package net.mymicroservices.emailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mymicroservices.emailservice.entity.KeywordEmailData;

public interface KeywordEmailDataRepository extends JpaRepository<KeywordEmailData, Long> {

}
