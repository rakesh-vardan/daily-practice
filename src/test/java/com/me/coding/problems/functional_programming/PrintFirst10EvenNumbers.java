package com.me.coding.problems.functional_programming;

import java.util.stream.IntStream;

public class PrintFirst10EvenNumbers {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
    }
}
