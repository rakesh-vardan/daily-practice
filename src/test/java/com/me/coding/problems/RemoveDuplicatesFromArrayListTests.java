package com.me.coding.problems;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArrayListTests {

    private List<Integer> numbers;

    @BeforeTest
    public void setUp() {
        numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(2);
        numbers.add(11);

        System.out.println("Arraylist with duplicates is: " + numbers);
    }

    @Test
    public void test1() {
        Set<Integer> numbersWithoutDuplicates = new LinkedHashSet<>(numbers);
        numbers.clear();
        numbers.addAll(numbersWithoutDuplicates);
        System.out.println("Arraylist with out duplicates is: " + numbers);
    }

    @Test
    public void test2() {
        List<Integer> integers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Arraylist with out duplicates is: " + integers);
    }


}
