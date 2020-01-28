package com.inc.currencyConverter.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EXCHANGE_TRANSACTION_RECORD")
public class ExchangeTranactionRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="CURRENCY_FROM")
    private String from;

    @Column(name="CURRENCY_TO")
    private String to;

    @Column(name="CONVERSION_MULTIPLE")
    private BigDecimal conversionMultiple;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    @Column(name="TOTAL_CALCULATED_AMOUNT")
    private BigDecimal totalCalculatedAmount;

    @Temporal(TemporalType.DATE)
    private Date date;

    public ExchangeTranactionRecord() {
    }

    public ExchangeTranactionRecord(String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
                                    BigDecimal totalCalculatedAmount) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}