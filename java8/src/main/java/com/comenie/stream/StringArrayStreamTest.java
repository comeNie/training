package com.comenie.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zkp2p-apple on 17/4/7.
 */
public class StringArrayStreamTest {
    public static void main(String[] args) {
        String[] words = {"hello", "world"};
        List<String> result =Arrays.stream(words).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        result.stream().forEach(System.out::print);

        System.out.println("---------");

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> results = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i,j}))
                .collect(toList());
        results.forEach(i -> Arrays.stream(i).forEach(System.out::print));

        List<int[]> results2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i+j) % 3 ==0)
                        .map(j -> new int[]{i,j}))
                .collect(toList());
    }
}
