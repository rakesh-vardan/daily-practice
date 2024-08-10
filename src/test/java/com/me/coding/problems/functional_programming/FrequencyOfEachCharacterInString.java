package com.me.coding.problems.functional_programming;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharacterInString {
    public static void main(String[] args) {
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> charCountMap = inputString.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charCountMap);
    }
}
