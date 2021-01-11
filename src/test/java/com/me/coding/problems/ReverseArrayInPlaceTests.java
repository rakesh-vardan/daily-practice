package com.me.coding.problems;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class ReverseArrayInPlaceTests {

    private int[] reverseArray(int[] input) {
        if (input == null || input.length <= 1) return input;

        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }

        return input;
    }

    @Test
    public void testReversedArray() {
        assertEquals(reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7}), new int[]{7, 6, 5, 4, 3, 2, 1});
        assertEquals(reverseArray(new int[]{}), new int[]{});
        assertNull(reverseArray(null));
    }
}
