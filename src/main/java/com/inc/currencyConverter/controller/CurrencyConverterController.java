package com.inc.currencyConverter.controller;

import com.inc.currencyConverter.model.ExchangeRateResponse;
import com.inc.currencyConverter.service.ConversionService;
import com.inc.currencyConverter.service.PersistenceService;
import com.inc.currencyConverter.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class CurrencyConverterController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PersistenceService persistenceService;

    @GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
    public BigDecimal convertToDifferentCurrency(@PathVariable String from, @PathVariable String to, @PathVariable String quantity) throws IOException, InvalidAttributeValueException {
        Validator.validateInputParams(from, to, quantity);
        ExchangeRateResponse rateResponse = conversionService.convert(from, to, quantity);
        persistenceService.save(from, to, quantity, rateResponse);
        return rateResponse.getTotalCalculatedAmount();
    }

}
