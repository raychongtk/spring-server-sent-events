package com.example.serversentevents.service;

import com.example.serversentevents.apipayload.ExchangeRates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author raychong
 */
@Service
public class ExchangeService {
    public ExchangeRates getExchangeRates() {
        var random = new Random();
        List<ExchangeRates.ExchangeRate> rates = new ArrayList<>();
        var hkdExchangeRate = new ExchangeRates.ExchangeRate("HKD", BigDecimal.ONE);
        var usdExchangeRate = new ExchangeRates.ExchangeRate("USD", BigDecimal.valueOf(random.nextDouble()));
        var cnyExchangeRate = new ExchangeRates.ExchangeRate("CNY", BigDecimal.valueOf(random.nextDouble()));
        rates.add(hkdExchangeRate);
        rates.add(usdExchangeRate);
        rates.add(cnyExchangeRate);

        var exchangeRates = new ExchangeRates();
        exchangeRates.rates = rates;
        return exchangeRates;
    }
}
