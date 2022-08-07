package net.mymicroservices.storeservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scraping_result")
@Getter
@Setter
public class WebinfoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long database_id;
    @Lob
    private String time;
    @Lob
    private String info;
}
