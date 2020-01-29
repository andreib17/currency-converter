package com.inc.currencyConverter.service;

import com.inc.currencyConverter.model.ExchangeRateResponse;
import com.inc.currencyConverter.model.ExchangeTranactionRecord;

import java.util.List;

public interface PersistenceService {

    void save(String from, String to, String quantity, ExchangeRateResponse rateResponse);

    List<ExchangeTranactionRecord> listTransactions();
}
