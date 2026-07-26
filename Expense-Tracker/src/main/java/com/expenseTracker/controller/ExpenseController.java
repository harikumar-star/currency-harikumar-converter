package com.expenseTracker.controller;


import com.expenseTracker.model.Transaction;
import com.expenseTracker.service.ExpenseTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("expense")
@RestController
public class ExpenseController {

    @Autowired
    ExpenseTracker expenseTracker;

    @PostMapping
    public ResponseEntity<Transaction> users(@RequestBody Transaction transaction) {
        Transaction transaction1 = expenseTracker.addIncome(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction1);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> users() {
        return ResponseEntity.ok(expenseTracker.getAllTransacton());
    }


    @GetMapping("/getTotal/{id}")
    public ResponseEntity<?> users(@PathVariable double id){
        double sum = expenseTracker.getTotalById(id);
        return ResponseEntity.ok(Map.of("Total", sum));
    }

}
