package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static io.mendirl.aventofcode.java2020.Day3.calcul;
import static io.mendirl.aventofcode.java2020.Day3.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day3.calcul_step2;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class Day3Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day3.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(148);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day3.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(727923200);
    }

    @ParameterizedTest
    @MethodSource
    void test_place_O(Coord coord, int expected) {
        var result = calcul(coord, List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#."));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> test_place_O() {
        return Stream.of(
                arguments(new Coord(3, 1), 1),
                arguments(new Coord(5, 2), 0));
    }

    @ParameterizedTest
    @MethodSource
    void test_place_O_1(Coord coord, int expected) {
        var result = calcul(coord, List.of(
                "..##.........##.......",
                "#...#...#..#...#...#..",
                ".#....#..#..#....#..#."));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> test_place_O_1() {
        return Stream.of(
                arguments(new Coord(3, 1), 1),
                arguments(new Coord(5, 2), 0));
    }

    @ParameterizedTest
    @MethodSource
    void test_place_X(Coord coord, int expected) {
        var result = calcul(coord, List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#."));

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> test_place_X() {
        return Stream.of(
                arguments(new Coord(6, 2), 1),
                arguments(new Coord(20, 2), 1));
    }

    @ParameterizedTest
    @MethodSource
    void test_place_X_1(Coord coord, int expected) {
        var result = calcul(coord, List.of(
                "..##.........##.......",
                "#...#...#..#...#...#..",
                ".#....#..#..#....#..#."));

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> test_place_X_1() {
        return Stream.of(
                arguments(new Coord(6, 2), 1),
                arguments(new Coord(20, 2), 1));
    }

}
