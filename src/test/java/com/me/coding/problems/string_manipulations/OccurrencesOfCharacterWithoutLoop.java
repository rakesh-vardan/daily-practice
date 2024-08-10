package com.me.coding.problems.string_manipulations;

public class OccurrencesOfCharacterWithoutLoop {

    public static void count(String input, char c) {
        int count = input.length() - input.replace(String.valueOf(c), "").length();
        System.out.println("Character count is: " +count);
    }

    public static void countWithStreams(String input, char c) {
        long count = input.chars().filter(ch -> ch == c).count();
        System.out.println("Character count is: " +count);
    }

    // just for reference
    public static void countWithLoop(String input, char c) {
        char[] chars = input.toCharArray();
        int count = 0;

        for(char character : chars) {
           if(character == c)
               count++;
        }
        System.out.println("Character count is: " +count);
    }

    public static void main(String[] args) {
//        count("Java is java again java again", 'a');
//        countWithStreams("Java is java again java again", 'a');
        countWithLoop("Java is java again java again", 'a');
    }
}
