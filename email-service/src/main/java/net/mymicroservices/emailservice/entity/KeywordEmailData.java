package net.mymicroservices.emailservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "keyword_email_mapping")
@Getter
@Setter
public class KeywordEmailData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long database_id;
    @Lob
    private String Keyword;
    @Lob
    private String email;
}
