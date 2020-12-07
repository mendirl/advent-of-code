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

import static io.mendirl.aventofcode.java2020.Day2.convert;
import static io.mendirl.aventofcode.java2020.Day2.filter_step1;
import static io.mendirl.aventofcode.java2020.Day2.filter_step2;


class Day2Test {

    @Test
    void tes_step1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day2.txt").toURI();
        var result = Files.readAllLines(Path.of(uri)).stream()
                .map(Day2::convert)
                .filter(Day2::filter_step1).count();


        Assertions.assertThat(result).isEqualTo(580);
    }


    @Test
    void test_step2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day2.txt").toURI();
        var result = Files.readAllLines(Path.of(uri)).stream()
                .map(Day2::convert)
                .filter(Day2::filter_step2).count();


        Assertions.assertThat(result).isEqualTo(611);
    }


    @ParameterizedTest
    @MethodSource
    void test_filter_step1_true(DataLine argument) {
        var result = filter_step1(argument);
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
        var result = filter_step1(argument);
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
        var result = filter_step2(argument);
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
        var result = filter_step2(argument);
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
