package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


class Day1Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day1.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri)).stream().map(Integer::parseInt).collect(Collectors.toSet());

        var result = Day1.calcul(entries, 2);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(444019);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day1.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri)).stream().map(Integer::parseInt).collect(Collectors.toSet());

        var result = Day1.calcul(entries, 3);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(29212176);
    }
}
