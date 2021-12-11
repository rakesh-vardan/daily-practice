package com.me.coding.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchForARangeInSortedArray {

    private List<Integer> getIndexes(int[] arr, int target) {
        int first = -1;
        int last = -1;
        List<Integer> numList = new ArrayList<>();

        if (arr.length == 0 || IntStream.of(arr).anyMatch(x -> x == target)){
            numList.add(-1);
            return numList;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                first = i;
                numList.add(first);
                break;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                last = i;
                numList.add(last);
                break;
            }
        }
        return numList;
    }

    @Test
    public void testSolution() {
        Assert.assertEquals(getIndexes(new int[] { 2, 3, 4, 5, 5, 7, 7, 7, 9, 11 }, 7), Arrays.asList(5, 7));
        Assert.assertEquals(getIndexes(new int[] { 5, 6, 6, 6, 7, 8, 8, 10 }, 8), Arrays.asList(5, 6));
        Assert.assertEquals(getIndexes(new int[] {}, 1), Arrays.asList(-1));
        Assert.assertEquals(getIndexes(new int[] {2, 3, 4, 5, 5}, 1), Arrays.asList(-1));
    }

}
