package com.inc.currencyConverter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inc.currencyConverter.model.ExchangeRateResponse;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class ConversionServiceImpl implements ConversionService{

    public ExchangeRateResponse convert(String from, String to, String quantity) throws IOException, InvalidAttributeValueException {
        Response response = initiateExchangeRateRequest(from, to);
        ExchangeRateResponse exchangeRateRes = parseResponse(response);
        return calculateConvertedQuantity(from, to,quantity, exchangeRateRes);
    }

    private ExchangeRateResponse parseResponse(Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body().string(), ExchangeRateResponse.class);
    }

    private Response initiateExchangeRateRequest(String from, String to) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.exchangeratesapi.io/latest").newBuilder();
        urlBuilder.addQueryParameter("symbols", from + "," + to);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    private ExchangeRateResponse calculateConvertedQuantity(String from, String to, String quantity, ExchangeRateResponse exchangeRateRes) throws InvalidAttributeValueException {
        if(exchangeRateRes.getRates().containsKey(from)){
            BigDecimal exchangeRate = new BigDecimal((double)exchangeRateRes.getRates().get(from));
            exchangeRateRes.setTotalCalculatedAmount((new BigDecimal(quantity)).multiply(exchangeRate));
            return exchangeRateRes;
        }
        throw new InvalidAttributeValueException();
    }
}
