package com.crud.DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysDsa {

    public static boolean subSetOptimal() {
        int a[] = {1, 3, 7, 1};
        int b[] = {1, 3, 7, 6};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int j : b) {
            if (!map.containsKey(j) || map.get(j) == 0) {
                return false;
            }
            map.put(j, map.get(j) - 1);
        }

        return true;   // time - o (n * m)  s - o(n)
    }

    public static boolean twoSumBrute() {
        int a[] = {1, -2, 1, 0, 5};
        int target = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoSumBetter() {

        int a[] = {1, 2, 3, 4};
        int target = 3;

        //Sort
        Arrays.sort(a);
        //two pointer technique
        int left = 0, right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
        // t - o(nlogn) sorting  + o(n) two pointer --> 0(nlogn)
        // space - o(1)
    }
    public boolean twoSumOptimal(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return true; // pair found
            }
            map.put(arr[i], i);
        }
        return false;
    }


    public static void main(String[] args) {

        boolean status = subSetOptimal();
        // System.out.println(status);

        boolean statusTwoSumBrute = twoSumBrute();
        //System.out.println(statusTwoSumBrute);

        boolean statustwoSumBetter = twoSumBetter();
        System.out.println(statustwoSumBetter);

    }

}
