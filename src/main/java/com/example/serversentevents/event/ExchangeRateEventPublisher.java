package com.example.serversentevents.event;

import com.example.serversentevents.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author raychong
 */
@Component
public class ExchangeRateEventPublisher {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    ExchangeService exchangeService;

    @Scheduled(fixedRate = 1000)
    public void publishUpdatedExchangeRates() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> applicationEventPublisher.publishEvent(new UpdateExchangeRateEvent(this, exchangeService.getExchangeRates())));
    }
}
