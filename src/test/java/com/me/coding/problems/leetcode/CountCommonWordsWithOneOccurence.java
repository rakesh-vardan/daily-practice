package com.me.coding.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given two string arrays words1 and words2,
 * return the number of strings that appear exactly once in each of the two
 * arrays. For example:
 * 
 * words1 = ["selenium", "is", "amazing", "as", "is"]
 * words2 = ["amazing", "selenium", "is"]
 * 
 * output = 2 (selenium & amazing)
 */

public class CountCommonWordsWithOneOccurence {

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

    @Test(dataProvider = "inputData")
    public void testMe(String[] words1, String[] words2, int count) {
        Assert.assertEquals(findCount(words1, words2), count);
    }

    @DataProvider(name = "inputData")
    public Object[][] getData() {
        return new Object[][] {
                { new String[] { "selenium", "is", "amazing", "as", "is" }, new String[] { "amazing", "selenium", "is" }, 2 },

                { new String[] { "selenium" }, new String[] { "selenium" }, 1 },

                { new String[] { "cypress" }, new String[] { "selenium" }, 0 },

                { new String[] { "selenium" }, new String[] {}, 0 },

                { new String[] {}, new String[] {}, 0 },
        };
    }
}
