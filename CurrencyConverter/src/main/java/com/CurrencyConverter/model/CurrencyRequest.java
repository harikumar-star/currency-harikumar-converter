package com.CurrencyConverter.model;

public class CurrencyRequest {

    private  String source;
    private String target;
    private double amount;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", amount=" + amount +
                '}';
    }
}
