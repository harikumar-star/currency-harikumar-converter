package com.crud.LooseCouple;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Diesel implements  Engine{
    @Override
    public void startEngine() {
        System.out.println("Diesel");
    }
}
