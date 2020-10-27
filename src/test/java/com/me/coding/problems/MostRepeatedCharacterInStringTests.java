package com.me.coding.problems;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class MostRepeatedCharacterInStringTests {

    public char mostRepeatedCharacterInString(String name) {
        char[] charArray = name.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : charArray) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();

        int maxCount = 0;
        char maxChar = 0;

        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("character is: " + maxChar + ", count is: " + maxCount);
        return maxChar;
    }

    @Test
    public void testMe() {
        assertEquals(this.mostRepeatedCharacterInString("Rakesh Budugu"), 'u');
        assertEquals(this.mostRepeatedCharacterInString("Sushma Gulapalli"), 'a');
    }
}
