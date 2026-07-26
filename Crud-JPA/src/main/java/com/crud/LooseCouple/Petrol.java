package com.crud.LooseCouple;


import org.springframework.stereotype.Service;

@Service
public class Petrol implements  Engine{
    @Override
    public void startEngine() {
        System.out.println("Petrol");
    }
}
