package com.crud.Interview;

import java.util.HashMap;
import java.util.Map;

public class TestCheck {

    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<>();
        map.put(null, "hari");
        map.put(null, "ram");
        map.put("1", "pen");

        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + "" + s.getValue());
        }
        System.out.println(map);


    }
}
