package com.me.coding.problems.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMostRepeatedElementInArray {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> elementCountMap = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        // most repeated item
        Map.Entry<String, Long> entry = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());

        // least repeated item
        Map.Entry<String, Long> entry1 = elementCountMap.entrySet().stream().min(Map.Entry.comparingByValue()).get();
        System.out.println(entry1.getKey());
        System.out.println(entry1.getValue());
    }
}
