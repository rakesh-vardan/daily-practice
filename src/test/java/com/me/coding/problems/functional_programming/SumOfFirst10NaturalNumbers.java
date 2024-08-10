package com.me.coding.problems.functional_programming;

import java.util.stream.IntStream;

public class SumOfFirst10NaturalNumbers {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 11).sum());
    }
}
