package com.inc.currencyConverter.service;

import com.inc.currencyConverter.model.ExchangeRateResponse;
import com.inc.currencyConverter.model.ExchangeTranactionRecord;
import com.inc.currencyConverter.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PersistenceServiceImpl implements PersistenceService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public void save(String from, String to, String quantity, ExchangeRateResponse rateResponse){
        ExchangeTranactionRecord tranactionRecord = new ExchangeTranactionRecord(from, to, new BigDecimal((double)rateResponse.getRates().get(from)), new BigDecimal(quantity), rateResponse.getTotalCalculatedAmount());
        exchangeValueRepository.save(tranactionRecord);
    }

    public List<ExchangeTranactionRecord> listTransactions() {
        return exchangeValueRepository.findAll();
    }
}
