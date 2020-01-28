package com.inc.currencyConverter.service;

import com.inc.currencyConverter.model.ExchangeRateResponse;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;

public interface ConversionService {

    ExchangeRateResponse convert(String from, String to, String quantity) throws IOException, InvalidAttributeValueException;
}
