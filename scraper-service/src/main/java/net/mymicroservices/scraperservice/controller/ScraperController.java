package net.mymicroservices.scraperservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mymicroservices.scraperservice.kafka.WebinfoProducer;
import net.mymicroservices.basedomains.dto.Webinfo;
import net.mymicroservices.basedomains.dto.WebinfoEvent;

@RestController
@RequestMapping("/scraper")
public class ScraperController {
    private WebinfoProducer webinfoProducer;

    public ScraperController(WebinfoProducer webinfoProducer) {
        this.webinfoProducer = webinfoProducer;
    }

    @PostMapping("/newinfo")
    public String createWebinfo(@RequestBody Webinfo webinfo) {
        webinfo.setId(UUID.randomUUID().toString());
        WebinfoEvent webinfoEvent = new WebinfoEvent();
        webinfoEvent.setStatus("Pending");
        webinfoEvent.setMessage("account status is in pending");
        webinfoEvent.setWebinfo(webinfo);

        webinfoProducer.sendMessage(webinfoEvent);

        return "webinfo created";
    }

}
