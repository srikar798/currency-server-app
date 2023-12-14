package com.career.csp.controller;

import com.career.csp.records.Currency;
import com.career.csp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/{code}")
    public ResponseEntity<Currency> getCurrency(@PathVariable String code){
        return ResponseEntity.ok(currencyService.getCurrency(code));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Currency>> getAllCurrencies(){
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }
}
