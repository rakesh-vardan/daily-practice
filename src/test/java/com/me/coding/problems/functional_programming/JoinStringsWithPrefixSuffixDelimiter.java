package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithPrefixSuffixDelimiter {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String finalString = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(finalString);
    }
}
