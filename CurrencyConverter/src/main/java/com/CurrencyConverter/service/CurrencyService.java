package com.CurrencyConverter.service;

import com.CurrencyConverter.model.CurrecnyResponse;
import com.CurrencyConverter.model.Currency;
import com.CurrencyConverter.model.CurrencyRequest;
import com.CurrencyConverter.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public Currency insert(Currency currency) {
        return currencyRepository.save(currency);
    }

    public CurrecnyResponse convert(CurrencyRequest currencyRequest) {
        Map<String, Double> rates = new LinkedHashMap<>();
        //assume jdbc exception what you do
        // suppose if no record found
        List<Currency> getRecords = getAllRecords();

        //check the list is empty or null
        if (getRecords == null || getRecords.isEmpty()) {
            throw new DataIntegrityViolationException("No records Found in Table");
        }

        for (Currency curr : getRecords) {
            rates.put(curr.getCurrency(), curr.getAmount());
        }

        double amount = currencyRequest.getAmount();
        String source = currencyRequest.getSource();
        String target = currencyRequest.getTarget();

        //check particular thing is available
        if (rates.containsKey(source) || rates.containsKey(target)) {
            throw new DataIntegrityViolationException("Conversion failed: Request exchange rate record not found for \" + source + \" or \" + target");
        }

        // 2. Map-la irundhu data confirm-a irukunu therinja pinbu safe-a divide panrom
        Double sourceRate = rates.get(source);
        Double targetRate = rates.get(target);

        if (sourceRate == 0) {
            throw new DataIntegrityViolationException("Invalid data state: Source currency rate cannot be zero.");
        }
        double converted = amount * (targetRate / sourceRate);
        return new CurrecnyResponse("The Conversion is ", amount);
    }

    public List<Currency> getAllRecords() {
        List<Currency> list = currencyRepository.findAll();
        return list;
    }


}
