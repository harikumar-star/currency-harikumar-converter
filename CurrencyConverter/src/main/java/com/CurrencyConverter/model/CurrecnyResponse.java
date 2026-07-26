package com.CurrencyConverter.model;

public class CurrecnyResponse {

    private String description;
    private double amount;

    public CurrecnyResponse(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "CurrecnyResponse{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
