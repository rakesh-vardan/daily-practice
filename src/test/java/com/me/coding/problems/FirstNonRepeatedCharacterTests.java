package com.me.coding.problems;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;

public class FirstNonRepeatedCharacterTests {

    private char usingLinkedHashMap(String name) {
        Map<Character, Integer> map = new LinkedHashMap<>(name.length());

        for (char ch : name.toLowerCase().toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        //LinkedHashmap maintains order
        for (Map.Entry<Character, Integer> r : map.entrySet()) {
            if (r.getValue() == 1) {
                System.out.println(r.getKey());
                return r.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    private char usingHashMap(String name) {
        Map<Character, Integer> map = new HashMap<>(name.length());
        char[] charArray = name.toLowerCase().toCharArray();

        for (char ch : charArray) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        //Hashmap doesn't maintain order
        for (char ch : charArray) {
            if (map.get(ch) == 1)
                return ch;
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    private char usingSetAndList(String name) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        char[] charArray = name.toLowerCase().toCharArray();

        for (char ch : charArray) {
            if (repeating.contains(ch)) {
                continue;
            }
            if (nonRepeating.contains(ch)) {
                nonRepeating.remove(ch);
                repeating.add(ch);
            } else {
                nonRepeating.add(ch);
            }
        }
        return nonRepeating.get(0);
    }

    private char usingStringCharLastIndexes(String name) {
        String lowerCaseName = name.toLowerCase();
        for (char ch : lowerCaseName.toCharArray()) {
            if (lowerCaseName.indexOf(ch) == lowerCaseName.lastIndexOf(ch)) {
                return ch;
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    private char usingStreams(String name) {
        Map<Character, Integer> charMap = new LinkedHashMap<>(name.length());
        Stream<Character> charStream = name.toLowerCase().chars().mapToObj(i -> (char) i);
        charStream.forEach(c -> charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1));

        Optional<Map.Entry<Character, Integer>> result = charMap.entrySet().stream()
                .filter(c -> c.getValue() == 1).findFirst();

        return result.isPresent() ? result.get().getKey() : ' ';
    }

    @Test
    public void testUsingSetAndList() {
        assertEquals(this.usingSetAndList("Rakesh Budugu"), 'r');
        assertEquals(this.usingSetAndList("Sushma Gulapalli"), 'h');
    }

    @Test
    public void testUsingStreams() {
        assertEquals(this.usingStreams("Rakesh Budugu"), 'r');
        assertEquals(this.usingStreams("Sushma Gulapalli"), 'h');
    }

    @Test
    public void testUsingStringCharLastIndexes() {
        assertEquals(this.usingStringCharLastIndexes("Rakesh Budugu"), 'r');
        assertEquals(this.usingStringCharLastIndexes("Sushma Gulapalli"), 'h');
    }


    @Test
    public void testUsingLinkedHashMap() {
        assertEquals(this.usingLinkedHashMap("Rakesh Budugu"), 'r');
        assertEquals(this.usingLinkedHashMap("Sushma Gulapalli"), 'h');
        assertEquals(this.usingLinkedHashMap("aaabbbccc"), 'c');
    }

    @Test
    public void testUsingHashMap() {
        assertEquals(this.usingHashMap("Rakesh Budugu"), 'r');
        assertEquals(this.usingHashMap("Sushma Gulapalli"), 'h');
    }

}
