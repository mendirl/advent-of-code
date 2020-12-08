package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.mendirl.aventofcode.java2020.Day1.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day1.calcul_step2;


class Day1Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day1.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(444019);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day1.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(29212176);
    }
}
