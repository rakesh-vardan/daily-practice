package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordOfString {
    public static void main(String[] args) {
        String input = "Java Concept Of The Day";
        String reversedString = Arrays.stream(input.split(" ")).map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reversedString);
    }
}
