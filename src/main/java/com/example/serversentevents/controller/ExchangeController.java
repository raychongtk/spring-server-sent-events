package com.example.serversentevents.controller;

import com.example.serversentevents.apipayload.ExchangeRates;
import com.example.serversentevents.event.UpdateExchangeRateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/api/exchange", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ExchangeRates> getExchangeRates() {
        return updateExchangeRateEventListener.createLatestExchangeRates();
    }
}
