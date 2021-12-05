package com.me.coding.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Given a String we have to Find the Maximum Number of Vowel Letters present in
 * any Substring of the String, with the length of each Substring equal to K.
 * Reference::https://java2blog.com/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaximumNumberOfVowelsInASubstring {

    /**
     * Solution-1: Using the substring method on all the possible substrings,
     * and count the number of vowels in the substring
     * 
     * @param input
     * @param k
     * @return
     */
    private int solutionWithSubstring(String input, int k) {
        int length = input.length();
        int maxVowels = 0;

        if (length == 0 || k > length)
            return -1;

        for (int i = 0; i <= length - k; i++) {
            String subStr = input.substring(i, i + k);
            int vowelsCount = countOfVowelsInSubString(subStr);
            maxVowels = Math.max(maxVowels, vowelsCount);
        }
        return maxVowels;
    }

    private int countOfVowelsInSubString(String str) {
        int countOfVowels = 0;

        for (char ch : str.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                countOfVowels++;
            }
        }
        return countOfVowels;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    /**
     * Solution-2: Using the sliding window method to get a better runtime solution
     * - O(n)
     * 
     * @param input
     * @param k
     * @return
     */
    private int solutionUsingSlidingWindowMethod(String input, int k) {
        int countOfVowels = 0;

        if (input.length() == 0 || k > input.length())
            return -1;

        for (int i = 0; i < k; i++) {
            if (isVowel(input.charAt(i))) {
                countOfVowels++;
            }
        }

        int maxVowels = 0;

        if (maxVowels < countOfVowels) {
            maxVowels = countOfVowels;
        }

        for (int i = k; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                countOfVowels++;
            }
            if (isVowel(input.charAt(i - k))) {
                countOfVowels--;
            }
            maxVowels = Math.max(maxVowels, countOfVowels);
        }
        return maxVowels;
    }

    @Test
    public void testSolution1() {
        Assert.assertEquals(solutionWithSubstring("java2blog", 3), 2); // jav,ava,va2,a2b,2bl,blo,log
        Assert.assertEquals(solutionWithSubstring("looijk", 3), 3);
        Assert.assertEquals(solutionWithSubstring("rakeuuuish", 5), 5);
        Assert.assertEquals(solutionWithSubstring("a", 2), -1);
        Assert.assertEquals(solutionWithSubstring(" ", 2), -1);
    }

    @Test
    public void testSolution2() {
        Assert.assertEquals(solutionUsingSlidingWindowMethod("java2blog", 3), 2); // jav,ava,va2,a2b,2bl,blo,log
        Assert.assertEquals(solutionUsingSlidingWindowMethod("looijk", 3), 3);
        Assert.assertEquals(solutionUsingSlidingWindowMethod("rakeuuuish", 5), 5);
        Assert.assertEquals(solutionUsingSlidingWindowMethod("a", 2), -1);
        Assert.assertEquals(solutionUsingSlidingWindowMethod(" ", 2), -1);
    }
}
