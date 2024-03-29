package com.me.coding.problems.leetcode.string;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseWordsInString {

    /*
        https://leetcode.com/problems/reverse-words-in-a-string/
        151. Reverse Words in a String
     */

    String input1 = "Hello World!";             // "World! Hello"
    String input2 = " Hello World! ";           // "World! Hello"
    String input3 = "Hello  World its  me ";    // "me its World Hello"
    String input4 = "Hello";                    // "Hello"

    public String reverseWordsS1(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedString = new StringBuilder();

        // to remove the empty strings in the array - corner case
        String[] modifiedWordsArray = Arrays.stream(words)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        for (int i = modifiedWordsArray.length - 1; i >= 0; i--) {
            reversedString.append(modifiedWordsArray[i]).append(' ');
        }

        return reversedString.toString().trim();
    }

    @Test
    public void testS1() {
        assertThat(this.reverseWordsS1(input1)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS1(input2)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS1(input3)).isEqualTo("me its World Hello");
        assertThat(this.reverseWordsS1(input4)).isEqualTo("Hello");
    }

    public String reverseWordsS2(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();

        String[] modifiedWordsArray = Arrays.stream(words)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        for (String word : modifiedWordsArray) {
            stack.push(word);
        }

        StringBuilder reversedString = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedString.append(stack.pop()).append(' ');
        }
        return reversedString.toString().trim();
    }

    @Test
    public void testS2() {
        assertThat(this.reverseWordsS2(input1)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS2(input2)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS2(input3)).isEqualTo("me its World Hello");
        assertThat(this.reverseWordsS2(input4)).isEqualTo("Hello");
    }

    public String reverseWordsS3(String sentence) {
        String[] words = sentence.split(" ");
        String[] modifiedWordsArray = Arrays.stream(words)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        return Arrays.stream(modifiedWordsArray)
                .reduce((firstWord, secondWord) -> secondWord + " " + firstWord)
                .orElse(sentence);
    }


    @Test
    public void testS3() {
        assertThat(this.reverseWordsS3(input1)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS3(input2)).isEqualTo("World! Hello");
        assertThat(this.reverseWordsS3(input3)).isEqualTo("me its World Hello");
        assertThat(this.reverseWordsS3(input4)).isEqualTo("Hello");
    }

    public String reverseStringS4(String sentence) {
        String[] words = sentence.split(" ");

        // to remove the empty strings in the array - corner case
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.removeIf(String::isEmpty);

        String[] modifiedArray = list.toArray(new String[0]);
        Deque<String> stack = new ArrayDeque<>();

        for (String word : modifiedArray) {
            stack.push(word);
        }

        StringBuilder reversedSentence = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
            if (!stack.isEmpty()) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }


    @Test
    public void testS4() {
        assertThat(this.reverseStringS4(input1)).isEqualTo("World! Hello");
        assertThat(this.reverseStringS4(input2)).isEqualTo("World! Hello");
        assertThat(this.reverseStringS4(input3)).isEqualTo("me its World Hello");
        assertThat(this.reverseStringS4(input4)).isEqualTo("Hello");
    }}
