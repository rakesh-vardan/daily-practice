package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDecimalNumbersInReverseOrder {
    public static void main(String[] args) {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        // sorting in ascending order
        decimalList.stream().sorted().forEach(System.out::println);

        // sorting in descending order
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
