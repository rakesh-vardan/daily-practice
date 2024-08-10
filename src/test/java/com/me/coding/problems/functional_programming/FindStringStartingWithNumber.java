package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.List;

public class FindStringStartingWithNumber {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStrings.stream().filter(s -> Character.isDigit(s.charAt(0))).forEach(System.out::println);
    }
}
