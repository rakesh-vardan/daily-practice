package com.me.coding.problems.string_manipulations;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CountOccurrencesOfCharacters {

    public static void countWithStreams(String input) {
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));

        charCount.forEach((character, count) -> {
            System.out.println("Character: " +character +", Count: " +count);
        });

        // solution for identifying duplicate characters - RELATED QUESTION
        charCount.forEach((character, count) -> {
            if(count > 1) {
                System.out.println("Duplicate Character is: " +character +", Count: " +count);
            }
        });
    }

    public static void count(String input) {
        char[] charArray = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        // to remove white space characters
        for (char c : charArray) {
            if ((c != ' ') && (c != '\t')) {
                sb.append(c);
            }
        }
        char[] charArrayOut = sb.toString().toCharArray();

        Map<Character, Long> charCountMap = new TreeMap<>();
        for(char c : charArrayOut) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1L);
            }
        }

        Set<Character> characters = charCountMap.keySet();
        for(char c : characters) {
            System.out.println("Character: " +c +", Count: " +charCountMap.get(c));
        }

    }

    public static void main(String[] args) {
//        count("Java J2EE Java JSP J2EE");
        countWithStreams("Java J2EE Java JSP J2EE");
    }
}
