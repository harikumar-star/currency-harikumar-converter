package com.crud.LooseCouple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mains {

    @Autowired
    private Engine engine;


    void m1() {
        engine.startEngine();
    }



}
