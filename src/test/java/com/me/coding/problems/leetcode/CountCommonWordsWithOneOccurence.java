package com.me.coding.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Given two string arrays words1 and words2,
 * return the number of strings that appear exactly once in each of the two
 * arrays.
 * words1 = ["selenium", "is", "amazing", "as", "is"]
 * words2 = ["amazing", "selenium", "is"]
 */
public class CountCommonWordsWithOneOccurence {

    String[] words1 = new String[] { "leetcode", "is", "amazing", "as", "is" };
    String[] words2 = new String[] { "amazing", "leetcode", "is" };

    public int findCount(String[] words1, String[] words2) {

        Set<String> presentOnceInA = new HashSet<>();
        Set<String> presentMoreThanOnce = new HashSet<>();
        Set<String> presentOnceInAandB = new HashSet<>();

        for (String w : words1) {
            if (presentOnceInA.contains(w)) {
                presentOnceInA.remove(w);
                presentMoreThanOnce.add(w);
            }
            if (!presentMoreThanOnce.contains(w)) {
                presentOnceInA.add(w);
            }
        }

        for (String w : words2) {
            if (presentOnceInA.contains(w)) {
                if (presentOnceInAandB.contains(w)) {
                    presentOnceInAandB.remove(w);
                    presentMoreThanOnce.add(w);
                }

                if (!presentMoreThanOnce.contains(w)) {
                    presentOnceInAandB.add(w);
                }
            }
        }

        return presentOnceInAandB.size();
    }

    @Test
    public void testMe() {
        Assert.assertEquals(findCount(words1, words2), 20);

    }
}
