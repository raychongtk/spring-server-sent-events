package com.example.serversentevents.event;

import com.example.serversentevents.apipayload.ExchangeRates;
import org.springframework.context.ApplicationListener;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * @author raychong
 */
@Component
public class UpdateExchangeRateEventListener implements ApplicationListener<UpdateExchangeRateEvent> {
    private final SubscribableChannel subscribableChannel = MessageChannels.publishSubscribe().get();

    public Flux<ExchangeRates> createLatestExchangeRates() {
        return Flux.create(sink -> {
            MessageHandler handler = message -> sink.next(((UpdateExchangeRateEvent) message.getPayload()).getExchangeRates());
            sink.onCancel(() -> subscribableChannel.unsubscribe(handler));
            subscribableChannel.subscribe(handler);
        }, FluxSink.OverflowStrategy.LATEST);
    }

    @Override
    public void onApplicationEvent(UpdateExchangeRateEvent event) {
        subscribableChannel.send(new GenericMessage<>(event));
    }
}
