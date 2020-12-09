package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


import static io.mendirl.aventofcode.java2020.Day6.calcul_1;
import static io.mendirl.aventofcode.java2020.Day6.calcul_2;
import static io.mendirl.aventofcode.java2020.Day6.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day6.calcul_step2;


class Day6Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day6.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(6596);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day6.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(3219);
    }

    @Test
    void test_1_1() {
        var input = new ArrayList<String>();
        input.add("abc");
        var result = calcul_1(input);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void test_1_2() {
        var input = new ArrayList<String>();
        input.add("a");
        input.add("b");
        input.add("c");
        var result = calcul_1(input);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void test_1_3() {
        var input = new ArrayList<String>();
        input.add("ab");
        input.add("ac");
        var result = calcul_1(input);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void test_1_4() {
        var input = new ArrayList<String>();
        input.add("a");
        input.add("a");
        input.add("a");
        input.add("a");
        var result = calcul_1(input);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void test_1_5() {
        var input = new ArrayList<String>();
        input.add("b");
        var result = calcul_1(input);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void test_2_1() {
        var input = new ArrayList<String>();
        input.add("abc");
        var result = calcul_2(input);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void test_2_2() {
        var input = new ArrayList<String>();
        input.add("a");
        input.add("b");
        input.add("c");
        var result = calcul_2(input);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void test_2_3() {
        var input = new ArrayList<String>();
        input.add("ab");
        input.add("ac");
        var result = calcul_2(input);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void test_2_4() {
        var input = new ArrayList<String>();
        input.add("a");
        input.add("a");
        input.add("a");
        input.add("a");
        var result = calcul_2(input);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void test_2_5() {
        var input = new ArrayList<String>();
        input.add("b");
        var result = calcul_2(input);
        Assertions.assertThat(result).isEqualTo(1);
    }


}
