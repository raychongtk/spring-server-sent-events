package com.example.serversentevents.event;

import com.example.serversentevents.apipayload.ExchangeRates;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

/**
 * @author raychong
 */
@Component
public class UpdateExchangeRateEventListener implements ApplicationListener<UpdateExchangeRateEvent> {
    private final Sinks.Many<UpdateExchangeRateEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Flux<ExchangeRates> createLatestExchangeRates() {
        return sink.asFlux().map(UpdateExchangeRateEvent::getExchangeRates);
    }

    @Override
    public void onApplicationEvent(UpdateExchangeRateEvent event) {
        sink.tryEmitNext(event);
    }
}
