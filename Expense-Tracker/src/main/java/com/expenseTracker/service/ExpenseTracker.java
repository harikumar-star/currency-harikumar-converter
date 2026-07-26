package com.expenseTracker.service;


import com.expenseTracker.model.Transaction;
import com.expenseTracker.repository.ExpenseTrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTracker {


    @Autowired
    ExpenseTrackerRepo expenseTrackerRepo;

    public Transaction addIncome(Transaction transaction) {
        System.out.println(10/0);
        return expenseTrackerRepo.save(transaction);
    }

    public List<Transaction> getAllTransacton() {
        return expenseTrackerRepo.findAll();
    }

    public double getTotalById(double clientId) {
        double sumOfTotal =0;
        List<Transaction> getotal = expenseTrackerRepo.findByClientId(clientId);
        for (Transaction transaction : getotal) {
            System.out.println("The Tranastion "+transaction);
           sumOfTotal += transaction.getAmount();
        }
        return sumOfTotal;
    }


}
