package com.crud.Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestInterview1 {


    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 1, 4, 2);

       // Find Duplicates
        List<Integer> set = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry ->entry.getValue()>1)
                .map(Map.Entry :: getKey)
                .collect(Collectors.toList());

       // Find the count of each elements
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i : list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // if duplicates want
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey());
            }
        }

        //Convert List to uppercase
        List<String> listString = List.of("a","b");
        List<String> uppers = listString.stream().map(String:: toUpperCase).toList();

        //Normal Way
        List<String> toUpper = new ArrayList<>();
        for(String s : listString){
            toUpper.add(s.toUpperCase());
        }

        //FInd Max and Min value in List
        int max = list.stream().max(Integer::compare).get();
        int min = list.stream().min(Integer::compare).get();

        //SOrt ASCEND
        List<Integer> ascend = list.stream().sorted((x,y) ->x-y).collect(Collectors.toList());
        //System.out.println(ascend);
        // descend - y-x

        // scond largest num
        int  sLarge = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        // first non repeating character

        String str = "swiss";
        Character c = str.chars().mapToObj(ch ->(char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
                .stream()
                .filter(f -> f.getValue() == 1)
                .map(Map.Entry:: getKey)
                .findFirst()
                .orElse(null);

        //Combine tow List
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(1,2,3);
        List<Integer> combine = Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        System.out.println(combine);

        //combine two arrays
        int arr1[] = {1,2,3,};
        int arr2[] = {1,2,3};
        int arr3[] = new int [arr1.length+arr2.length];
        for(int i= 0 ; i <arr1.length; i++)
        {
            arr3[i] = arr1[i];
        }
        for(int i= 0 ; i<arr2.length; i++){
            arr3[arr1.length+i] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));









    }
}
