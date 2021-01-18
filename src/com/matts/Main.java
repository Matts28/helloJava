package com.matts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> names =
                Arrays.asList(5, 4, 6, 4, 9);

        List<String> namesStr = names.stream()
                .map(x -> String.valueOf(x))
                .collect(Collectors.toList());

        //namesStr.remove("4");

        boolean frequencyMatch =
                namesStr.parallelStream()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), Collectors.counting()
                                )
                        )
                        .values().parallelStream()
                        .anyMatch(v -> v == 2);

        if(frequencyMatch) {
            System.out.println("yep");
        }
        System.out.println(namesStr);
    }
}
