package com.crud.DSA;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview {

    public static void main(String[] args) {

        List<String> list = List.of("hari","ram","hari","ram");

        list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())) // count occurrences
                .entrySet().stream()
                .filter(e -> e.getValue() > 1) // keep only duplicates
                .map(Map.Entry::getKey)
                .forEach(s->System.out.println(s));





        // just remove the duplicates if op -> hari ,ram
        //list.stream().distinct().forEach(s->System.out.println(s));





    }
}
