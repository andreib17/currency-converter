package com.inc.currencyConverter.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class ExchangeRateResponse {

    private String base;
    private Date date;
    private Map<String, Object> rates;
    transient private BigDecimal totalCalculatedAmount;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getRates() {
        return rates;
    }

    public void setRates(Map<String, Object> rates) {
        this.rates = rates;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
