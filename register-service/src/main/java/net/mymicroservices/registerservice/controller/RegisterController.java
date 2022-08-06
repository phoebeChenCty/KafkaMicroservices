package net.mymicroservices.registerservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mymicroservices.registerservice.kafka.AccountProducer;
import net.mymicroservices.basedomains.dto.Account;
import net.mymicroservices.basedomains.dto.AccountEvent;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private AccountProducer accountProducer;

    public RegisterController(AccountProducer accountProducer) {
        this.accountProducer = accountProducer;
    }

    @PostMapping("/newuser")
    public String createAccount(@RequestBody Account account) {
        account.setId(UUID.randomUUID().toString());
        AccountEvent accountEvent = new AccountEvent();
        accountEvent.setStatus("Pending");
        accountEvent.setMessage("account status is in pending");
        accountEvent.setAccount(account);

        accountProducer.sendMessage(accountEvent);

        return "Account created";
    }

}
