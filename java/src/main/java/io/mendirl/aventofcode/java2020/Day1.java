package io.mendirl.aventofcode.java2020;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1 {

    static Integer calcul_step1(List<String> inputs) {
        var collect = inputs.stream().map(Integer::parseInt).collect(Collectors.toSet());
        return calcul(collect, 2);
    }

    static Integer calcul_step2(List<String> inputs) {
        var collect = inputs.stream().map(Integer::parseInt).collect(Collectors.toSet());
        return calcul(collect, 3);
    }

    static Integer calcul(Set<Integer> entries, int size) {
        return Sets.combinations(entries, size).stream()
                .filter(integers -> integers.stream().reduce(0, Integer::sum) == 2020)
                .findFirst()
                .map(integers -> integers.stream().reduce(1, (x, y) -> x * y))
                .orElse(0);
    }

}
