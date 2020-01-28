package com.inc.currencyConverter.repository;

import com.inc.currencyConverter.model.ExchangeTranactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeTranactionRecord, Long> {

}
