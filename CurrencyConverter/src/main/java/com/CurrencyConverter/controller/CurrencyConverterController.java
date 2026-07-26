package com.CurrencyConverter.controller;

import com.CurrencyConverter.model.CurrecnyResponse;
import com.CurrencyConverter.model.Currency;
import com.CurrencyConverter.model.CurrencyRequest;
import com.CurrencyConverter.repo.CurrencyRepository;
import com.CurrencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("currenyConverter")
@RestController
public class CurrencyConverterController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    CurrencyRepository currencyRepository;

    @PostMapping
    public ResponseEntity<Currency> currency(@RequestBody Currency currency) {
        Currency currency1 = currencyService.insert(currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(currency1);
    }

    @GetMapping
    public ResponseEntity<CurrecnyResponse> currency(@RequestBody CurrencyRequest currencyRequest) {
        CurrecnyResponse currecnyResponse = currencyService.convert(currencyRequest);
        return ResponseEntity.ok(currecnyResponse);

    }

    @PostMapping("/currencies")
    public List<Currency> saveAll(
            @RequestBody List<Currency> currencies) {

        return currencyRepository.saveAll(currencies);
    }
}
