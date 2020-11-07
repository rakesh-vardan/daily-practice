package com.me.coding.problems;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.testng.AssertJUnit.assertEquals;

public class CommaSeparatedStringFromNumbers {

    @Test
    public void testAppendOddOrEvenChar() {
        List<Integer> numList = Arrays.asList(1, 2, 4, 5);
        assertEquals(this.appendOddOrEvenChar(numList), "o1,e2,e4,o5");
    }

    @Test
    public void testRemoveEmptyString() {
        List<String> stringList = Arrays.asList("hello", "world", "", "123", "bye");
        assertEquals(this.removeEmptyString(stringList), Arrays.asList("hello", "world", "123", "bye"));
    }

    public String appendOddOrEvenChar(List<Integer> list) {
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(joining(","));
    }

    public List<String> removeEmptyString(List<String> stringList) {
        return stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }
}
