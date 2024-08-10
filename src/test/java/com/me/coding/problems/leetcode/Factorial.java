package com.me.coding.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number: ");
//        int number = sc.nextInt();
//
//        int result = 1;
//
//        for(int i = 1; i <= number; i++ ) {
//            result*=i;
//        }
//        System.out.println(result);

//        int[] array = new int[] {1, 4, 2, 18, 97, 100}; //1, 2, 4, 18, 97, 100
//        Arrays.sort(array);
//        int length = array.length;
//        System.out.println(array[length - 2]);

//        String name = "Hello World"; // l, o
//
//        char[] array = name.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(char c : array) {
//            if(map.containsKey(c)) {
//                map.put(c, map.get(c) + 1);
//            } else {
//                map.put(c, 1);
//            }
//        }
//        // h=1,e=1,l=2,o=2,W=1,....
//
//        for(char c : map.keySet()) {
//            if(map.get(c) > 1) {
//                System.out.println("Duplicate characters are: " +c);
//            }
//        }

//        int a = 10;
//        int b = 20;
//
//        a = a + b; //30
//        b = a - b; //10
//
//        a = a - b; //20
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
        int a[]={44,66,99,77,33,22,55};
        int i = secondLargest(a);
        System.out.println(i);
    }

    public static int secondLargest(int[] array) {
        int temp;

        for(int i=0; i < array.length; i++) {
            for(int j=i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array[array.length - 2];
    }
}
