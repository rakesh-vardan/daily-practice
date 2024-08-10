package com.me.coding.problems.functional_programming;

import java.util.stream.IntStream;

public class FindGivenStringIsAPalindrome {
    public static void main(String[] args) {
        String input = "ROTATOR";
        boolean isPalindrome = IntStream.range(1, input.length() / 2)
                .noneMatch(i -> input.charAt(i) != input.charAt(input.length() - i - 1));
        System.out.println(isPalindrome);
    }
}
