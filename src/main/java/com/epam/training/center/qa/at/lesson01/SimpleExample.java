package com.epam.training.center.qa.at.lesson01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleExample {

    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();

        lst.add("uuuuuu");

        System.out.println(lst);


        List<Integer> collect = Arrays.asList(1, 2, 3, 4)
                .stream()
                .filter(i -> i > 2)
                .collect(Collectors.toList());
    }
}
