package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.mendirl.aventofcode.java2020.Day5.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day5.calcul_step2;
import static io.mendirl.aventofcode.java2020.Day5.place;


class Day5Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day5.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(980);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day5.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(607);
    }

    @Test
    public void test_1_1() {
        var input = "BFFFBBFRRR";
        var result = place(input);
        Assertions.assertThat(result).isEqualTo(new Place(70, 7, 567));
    }

    @Test
    public void test_1_2() {
        var input = "FFFBBBFRRR";
        var result = place(input);
        Assertions.assertThat(result).isEqualTo(new Place(14, 7, 119));
    }

    @Test
    public void test_1_3() {
        var input = "BBFFBBFRLL";
        var result = place(input);
        Assertions.assertThat(result).isEqualTo(new Place(102, 4, 820));
    }

    @Test
    public void test_place_computation_step_1_F() {
        var result = CALCUL.F.convertion().apply(new Row(0, 127, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(0, 63, 0, 7));
    }

    @Test
    public void test_place_computation_step_2_B() {
        var result = CALCUL.B.convertion().apply(new Row(0, 63, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(32, 63, 0, 7));
    }

    @Test
    public void test_place_computation_step_3_F() {
        var result = CALCUL.F.convertion().apply(new Row(32, 63, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(32, 47, 0, 7));
    }

    @Test
    public void test_place_computation_step_4_B() {
        var result = CALCUL.B.convertion().apply(new Row(32, 47, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(40, 47, 0, 7));
    }

    @Test
    public void test_place_computation_step_5_B() {
        var result = CALCUL.B.convertion().apply(new Row(40, 47, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(44, 47, 0, 7));
    }

    @Test
    public void test_place_computatio_step_6_F() {
        var result = CALCUL.F.convertion().apply(new Row(44, 47, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(44, 45, 0, 7));
    }

    @Test
    public void test_place_computatio_step_7_F() {
        var result = CALCUL.F.convertion().apply(new Row(44, 45, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(44, 44, 0, 7));
    }

    @Test
    public void test_place_computatio_step_8_R() {
        var result = CALCUL.R.convertion().apply(new Row(44, 44, 0, 7));
        Assertions.assertThat(result).isEqualTo(new Row(44, 44, 4, 7));
    }

    @Test
    public void test_place_computatio_step_9_L() {
        var result = CALCUL.L.convertion().apply(new Row(44, 44, 4, 7));
        Assertions.assertThat(result).isEqualTo(new Row(44, 44, 4, 5));
    }

    @Test
    public void test_place_computatio_step_10_R() {
        var result = CALCUL.R.convertion().apply(new Row(44, 44, 4, 5));
        Assertions.assertThat(result).isEqualTo(new Row(44, 44, 5, 5));
    }

}
