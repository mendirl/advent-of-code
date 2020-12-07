package io.mendirl.aventofcode.java2020;

import com.google.common.collect.Sets;

import java.util.Set;

public class Day1 {

    static Integer calcul(Set<Integer> entries, int size) {
        return Sets.combinations(entries, size).stream()
                .filter(integers -> integers.stream().reduce(0, Integer::sum) == 2020)
                .findFirst()
                .map(integers -> integers.stream().reduce(1, (x, y) -> x * y))
                .orElse(0);
    }

}
