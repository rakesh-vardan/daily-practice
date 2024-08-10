package com.me.coding.problems.functional_programming;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigitsInNumber {
    public static void main(String[] args) {
        int i = 15623;
        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        //another option:
        //Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println("sumOfDigits: " + sumOfDigits);
    }
}
