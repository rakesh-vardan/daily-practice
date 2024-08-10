package com.me.coding.problems.string_manipulations.anagram;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for(int i=0; i<charArray1.length; i++) {
            return charArray1[i] == charArray2[i];
        }
        return true;
    }

    @Test
    public void testMe() {
        isAnagram("Listen", "Silent");
    }
}
