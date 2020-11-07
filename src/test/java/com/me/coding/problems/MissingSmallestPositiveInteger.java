package com.me.coding.problems;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Write a method that returns a comma-separated string based on a given list of integers.
 * Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
 * For example, if the input list is (3,44), the output should be 'o3,e44'.
 */
public class MissingSmallestPositiveInteger {

    @Test
    public void testMe() {
        int[] intArray = {-1, -3};
        System.out.println(solution(intArray));
    }

    private int solution(int[] arr) {
        int smallestInt = 1;
        if (arr.length == 0) return smallestInt;

        Arrays.sort(arr);

        if (arr[0] > 1) return smallestInt;
        if (arr[arr.length - 1] <= 0) return smallestInt;

        for (int j : arr) {
            if (j == smallestInt) {
                smallestInt++;
            }
        }
        return smallestInt;
    }
}
