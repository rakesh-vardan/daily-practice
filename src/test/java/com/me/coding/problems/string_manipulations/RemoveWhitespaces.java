package com.me.coding.problems.string_manipulations;

import java.util.stream.Collectors;

public class RemoveWhitespaces {

    public static void remove(String input) {
        String updatedString = input.replaceAll("\\s+", "");
        System.out.println("Updated string is: " + updatedString);
    }

    public static void remove1(String input) { 
        char[] charArray = input.toCharArray();
        StringBuilder updatedString = new StringBuilder();

        for(char c : charArray) {
            if( (c != ' ') && (c != '\t')) {
                updatedString.append(c);
            }
        }
        System.out.println("Updated string is: " + updatedString);
    }

    public static void removeWithStreams(String input) {
        String updatedString = input.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println("Updated string is: " + updatedString);
    }

    public static void main(String[] args) {
        remove("input string with whitespaces");
        remove1("input string with whitespaces");
        removeWithStreams("input string with whitespaces");
    }
}
