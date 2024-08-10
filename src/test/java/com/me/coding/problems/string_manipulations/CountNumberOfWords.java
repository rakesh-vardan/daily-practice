package com.me.coding.problems.string_manipulations;

import java.util.Arrays;

public class CountNumberOfWords {

    public static void countWords(String input) {
        String[] words = input.trim().split(" ");
        System.out.println("Number of words are: " + words.length);
    }

    public static void countWords2(String input) {
        int count = 1;

        for(int i=0; i < input.length(); i++) {
            if((input.charAt(i) == ' ') && (input.charAt(i+1) != ' ')) {
                count++;
            }
        }
        System.out.println("Number of words are: " + count);
    }

    public static void countWordsStreams(String input) {
        System.out.println(Arrays.stream(input.split(" ")).count());
    }



    public static void main(String[] args) {
        countWords("Enter the string");
        countWords2("Enter the string");
        countWordsStreams("Enter the string");
    }
}
