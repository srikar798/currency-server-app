package com.career.csp.service;

import com.career.csp.records.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final ObjectMapper objectMapper;

    private Map<String, Currency> currencyMap;

    @PostConstruct
    public void init() {
        currencyMap = new HashMap<>();
        try {
            objectMapper.readTree(getClass().getResourceAsStream("/currencies.json"))
                    .forEach(jsonNode -> {
                        Currency currency = objectMapper.convertValue(jsonNode, Currency.class);
                        currencyMap.put(currency.code(), currency);
                    });
        } catch (Exception e) {
            log.error("Error while loading currencies : {}",e.getMessage());
        }
    }

    public Currency getCurrency(String code) {
        Currency currency = currencyMap.get(code);
        if (currency == null) {
            log.error("Currency not found with code : {}",code);
            throw new CurrencyNotFoundException("Currency not found with code : " + code);
        }
        log.info("Currency found with code : {} is : {}",code,currency.name());
        return currency;
    }

    public List<Currency> getAllCurrencies(){
        return List.copyOf(currencyMap.values());
    }
}
