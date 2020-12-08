package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static io.mendirl.aventofcode.java2020.Day2.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day2.calcul_step1_inner;
import static io.mendirl.aventofcode.java2020.Day2.calcul_step2;
import static io.mendirl.aventofcode.java2020.Day2.calcul_step2_inner;
import static io.mendirl.aventofcode.java2020.Day2.convert;


class Day2Test {

    @Test
    void test_step1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day2.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(580);
    }


    @Test
    void test_step2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day2.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(611);
    }


    @ParameterizedTest
    @MethodSource
    void test_filter_step1_true(DataLine argument) {
        var result = calcul_step1_inner(argument);
        Assertions.assertThat(result).isTrue();
    }

    static Stream<DataLine> test_filter_step1_true() {
        return Stream.of(
                new DataLine(1, 7, 'j', "vrfjljjwbsv"),
                new DataLine(3, 3, 'j', "vrfjljjwbsv"),
                new DataLine(3, 7, 'j', "vrfjljjwbsv"),
                new DataLine(1, 3, 'j', "vrfjljjwbsv")
        );
    }

    @ParameterizedTest
    @MethodSource
    void test_filter_step1_false(DataLine argument) {
        var result = calcul_step1_inner(argument);
        Assertions.assertThat(result).isFalse();
    }

    static Stream<DataLine> test_filter_step1_false() {
        return Stream.of(
                new DataLine(5, 7, 'j', "vrfjljjwbsv"),
                new DataLine(0, 2, 'j', "vrfjljjwbsv")
        );
    }

    @ParameterizedTest
    @MethodSource
    void test_filter_step2_true(DataLine argument) {
        var result = calcul_step2_inner(argument);
        Assertions.assertThat(result).isTrue();
    }

    static Stream<DataLine> test_filter_step2_true() {
        return Stream.of(
                new DataLine(4, 8, 'j', "vrfjljjwbsv"),
                new DataLine(1, 4, 'j', "vrfjljjwbsv")
        );
    }

    @ParameterizedTest
    @MethodSource
    void test_filter_step2_false(DataLine argument) {
        var result = calcul_step2_inner(argument);
        Assertions.assertThat(result).isFalse();
    }

    static Stream<DataLine> test_filter_step2_false() {
        return Stream.of(
                new DataLine(1, 2, 'j', "vrfjljjwbsv"),
                new DataLine(4, 6, 'j', "vrfjljjwbsv")
        );
    }

    @Test
    void test_regex() {
        var line = "1-7 j: vrfjljjwbsv";
        var dataline = new DataLine(1, 7, 'j', "vrfjljjwbsv");

        var result = convert(line);
        Assertions.assertThat(result).isEqualTo(dataline);
    }

}
