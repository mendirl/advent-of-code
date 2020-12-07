package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static io.mendirl.aventofcode.java2020.Day3.place;


class Day3Test {

    @Test
    void test() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day3.txt").toURI();
        var result = Files.readAllLines(Path.of(uri));


    }


    @ParameterizedTest
    @MethodSource
    void test_place_O(Coord coord) {
        var result = place(coord, List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#."));

        Assertions.assertThat(result).isEqualTo("O");
    }

    static Stream<Coord> test_place_O() {
        return Stream.of(new Coord(3, 1));
    }

    @ParameterizedTest
    @MethodSource
    void test_place_1(Coord coord) {
        var result = place(coord, List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#."));

        Assertions.assertThat(result).isEqualTo("X");
    }

    static Stream<Coord> test_place_1() {
        return Stream.of(new Coord(6, 2));
    }


}
