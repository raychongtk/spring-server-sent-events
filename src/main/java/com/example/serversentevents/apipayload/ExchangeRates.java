package com.example.serversentevents.apipayload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class ExchangeRates {
    @NotNull
    public List<ExchangeRate> rates = new ArrayList<>();

    public static class ExchangeRate {
        @NotBlank
        public String currency;

        @NotNull
        public BigDecimal rate;

        public ExchangeRate(String currency, BigDecimal rate) {
            this.currency = currency;
            this.rate = rate;
        }
    }
}
