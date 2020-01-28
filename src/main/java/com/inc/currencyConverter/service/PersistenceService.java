package com.inc.currencyConverter.service;

import com.inc.currencyConverter.model.ExchangeRateResponse;

public interface PersistenceService {

    void save(String from, String to, String quantity, ExchangeRateResponse rateResponse);
}
