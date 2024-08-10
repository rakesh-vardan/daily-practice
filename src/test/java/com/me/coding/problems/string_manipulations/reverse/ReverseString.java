package com.me.coding.problems.string_manipulations.reverse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString {

    public String reverse(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    public String reverseInPlace(String input) {
        String[] words = input.split(" ");
        StringBuilder reversedStr = new StringBuilder();
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reversedStr.append(reverseWord).append(" ");
        }
        return reversedStr.toString().trim();
    }

    public String reverseWithRecursion(String input) {
        if(input.isEmpty())
            return input;
        return reverseWithRecursion(input.substring(1)) + input.charAt(0);
    }

    @Test
    public void testReverseWithRecursion() {
        Assert.assertEquals(reverseWithRecursion("Hello World"), "dlroW olleH");
    }

    @Test
    public void testReverseInPlace() {
        Assert.assertEquals(reverseInPlace("Hello World"), "olleH dlroW");
    }

    @Test
    public void testReverse() {
        Assert.assertEquals(reverse("Hello World"), "dlroW olleH");
    }
}
