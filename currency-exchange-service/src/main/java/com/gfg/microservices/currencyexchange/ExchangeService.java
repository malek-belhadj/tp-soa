package com.gfg.microservices.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    @Autowired
    ExchangeRepository exchangeRepository;

    // CREATE
    public ExchangeValue createExchangeValue(ExchangeValue ex) {
        return exchangeRepository.save(ex);
    }
}