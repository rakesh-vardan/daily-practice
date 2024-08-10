package com.me.coding.problems.string_manipulations;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWordsAndOccurrences {

    public static void find(String input) {
        String[] strArray = input.split(" ");

        Map<String, Integer> stringMap = new HashMap<>();

        for(String s : strArray) {
            if(stringMap.containsKey(s)) {
                stringMap.put(s, stringMap.get(s) + 1);
            } else {
                stringMap.put(s, 1);
            }
        }

        Set<String> stringSet = stringMap.keySet();
        for(String s : stringSet) {
            if(stringMap.get(s) > 1) {
                System.out.println("Word: " + s + ", Count: " + stringMap.get(s));
            }
        }
    }

    public static void findWithStreams(String input) {
        Map<String, Long> wordCount = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // can also be used like this
        /*Map<String, Long> wordCount = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        wordCount.forEach((word, count) -> {
            if(count > 1) {
                System.out.println("Word: " + word + " - Count: " +count);
            }
        });
    }

    public static void main(String[] args) {
//        find("bread butter and bread");
        findWithStreams("bread butter and bread");
    }
}
