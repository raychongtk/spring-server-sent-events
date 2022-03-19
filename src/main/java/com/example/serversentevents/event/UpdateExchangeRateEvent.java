package com.example.serversentevents.event;

import com.example.serversentevents.apipayload.ExchangeRates;
import org.springframework.context.ApplicationEvent;

/**
 * @author raychong
 */
public class UpdateExchangeRateEvent extends ApplicationEvent {
    private final ExchangeRates exchangeRates;

    public UpdateExchangeRateEvent(Object source, ExchangeRates exchangeRates) {
        super(source);
        this.exchangeRates = exchangeRates;
    }

    public ExchangeRates getExchangeRates() {
        return exchangeRates;
    }
}
