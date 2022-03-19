package com.example.serversentevents.controller;

import com.example.serversentevents.apipayload.ExchangeRates;
import com.example.serversentevents.event.UpdateExchangeRateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author raychong
 */
@RestController
public class ExchangeController {
    @Autowired
    UpdateExchangeRateEventListener updateExchangeRateEventListener;

    @GetMapping(value = "/api/exchange")
    public Flux<ExchangeRates> getExchangeRates() {
        return updateExchangeRateEventListener.createLatestExchangeRates();
    }
}
