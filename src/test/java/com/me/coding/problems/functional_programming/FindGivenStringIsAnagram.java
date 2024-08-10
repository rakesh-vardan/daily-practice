package com.me.coding.problems.functional_programming;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindGivenStringIsAnagram {
    public static void main(String[] args) {
        String s1 = "RaceCar"; // aaccerr
        String s2 = "CarRace"; // aaccerr

        String sortedS1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String sortedS2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        System.out.println(sortedS1);
        System.out.println(sortedS2);

        if (sortedS1.equals(sortedS2))
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }

    }
}
