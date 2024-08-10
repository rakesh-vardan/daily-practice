package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoUnsortedArraysIntoSingleSortedArray {
    public static void main(String[] args) {
        int[] a = new int[] {4, 2, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};

        int[] mergedSortedArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(mergedSortedArray));

        int[] c = new int[] {4, 2, 7, 1};
        int[] d = new int[] {8, 3, 1, 5};
        int[] mergedSortedArrayWithoutDuplicate = IntStream.concat(Arrays.stream(c), Arrays.stream(d)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(mergedSortedArrayWithoutDuplicate));
    }
}
