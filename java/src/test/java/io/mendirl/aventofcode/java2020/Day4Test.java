package io.mendirl.aventofcode.java2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.mendirl.aventofcode.java2020.Day4.calcul_step1;
import static io.mendirl.aventofcode.java2020.Day4.calcul_step2;
import static io.mendirl.aventofcode.java2020.Day4.valid_1;
import static io.mendirl.aventofcode.java2020.Day4.valid_2;
import static io.mendirl.aventofcode.java2020.Day4.validation;

class Day4Test {

    @Test
    void test_part_1() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day4.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step1(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(228);
    }

    @Test
    void test_part_2() throws URISyntaxException, IOException {
        var uri = getClass().getResource("/day4.txt").toURI();
        var entries = Files.readAllLines(Path.of(uri));

        var result = calcul_step2(entries);

        System.out.println("the result is : " + result);

        Assertions.assertThat(result).isEqualTo(175);
    }

    @Test
    void test_valid_1_1() {
        var input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";

        var result = valid_1().test(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void test_valid_1_2() {
        var input = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929";

        var result = valid_1().test(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void test_valid_1_3() {
        var input = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm";

        var result = valid_1().test(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void test_valid_1_4() {
        var input = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        var result = valid_1().test(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void test_validation_byr() {
        var result1 = VALIDATION.BYR.rule().test("2002");
        Assertions.assertThat(result1).isTrue();
        var result1_1 = validation("byr:2002");
        Assertions.assertThat(result1_1).contains(VALIDATION.BYR);

        var result2 = VALIDATION.BYR.rule().test("2003");
        Assertions.assertThat(result2).isFalse();
        var result2_1 = validation("byr:2003");
        Assertions.assertThat(result2_1).isEmpty();
    }

    @Test
    void test_validation_hgt() {
        var result1 = VALIDATION.HGT.rule().test("60in");
        Assertions.assertThat(result1).isTrue();
        var result1_1 = validation("hgt:60in");
        Assertions.assertThat(result1_1).contains(VALIDATION.HGT);

        var result2 = VALIDATION.HGT.rule().test("190cm");
        Assertions.assertThat(result2).isTrue();
        var result2_1 = validation("hgt:190cm");
        Assertions.assertThat(result2_1).contains(VALIDATION.HGT);

        var result3 = VALIDATION.HGT.rule().test("190in");
        Assertions.assertThat(result3).isFalse();
        var result3_1 = validation("hgt:190in");
        Assertions.assertThat(result3_1).isEmpty();

        var result4 = VALIDATION.HGT.rule().test("190");
        Assertions.assertThat(result4).isFalse();
        var result4_1 = validation("hgt:190");
        Assertions.assertThat(result4_1).isEmpty();
    }

    @Test
    void test_validation_hcl() {
            var result1 = VALIDATION.HCL.rule().test("#123abc");
        Assertions.assertThat(result1).isTrue();
        var result1_1 = validation("hcl:#123abc");
        Assertions.assertThat(result1_1).contains(VALIDATION.HCL);

        var result2 = VALIDATION.HCL.rule().test("#123abz");
        Assertions.assertThat(result2).isFalse();
        var result2_1 = validation("hcl:#123abz");
        Assertions.assertThat(result2_1).isEmpty();

        var result3 = VALIDATION.HCL.rule().test("123abc");
        Assertions.assertThat(result3).isFalse();
        var result3_1 = validation("hcl:123abc");
        Assertions.assertThat(result3_1).isEmpty();
    }


    @Test
    void test_validation_ecl() {
        var result1 = VALIDATION.ECL.rule().test("brn");
        Assertions.assertThat(result1).isTrue();
        var result1_1 = validation("ecl:brn");
        Assertions.assertThat(result1_1).contains(VALIDATION.ECL);

        var result2 = VALIDATION.ECL.rule().test("wat");
        Assertions.assertThat(result2).isFalse();
        var result2_1 = validation("ecl:wat");
        Assertions.assertThat(result2_1).isEmpty();
    }

    @Test
    void test_validation_pid() {
        var result1 = VALIDATION.PID.rule().test("000000001");
        Assertions.assertThat(result1).isTrue();
        var result1_1 = validation("pid:000000001");
        Assertions.assertThat(result1_1).contains(VALIDATION.PID);

        var result2 = VALIDATION.PID.rule().test("0123456789");
        Assertions.assertThat(result2).isFalse();
        var result2_1 = validation("pid:0123456789");
        Assertions.assertThat(result2_1).isEmpty();
    }


    @Test
    void test_valid_2_1() {
        var input = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f";

        var result = valid_2().test(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void test_valid_2_2() {
        var input = "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926";

        var result = valid_2().test(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void test_valid_2_3() {
        var input = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022";

        var result = valid_2().test(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void test_valid_2_4() {
        var input = "iyr:2019 hcl:#602927 eyr:1967 hgt:170cm ecl:grn pid:012533040 byr:1946";

        var result = valid_2().test(input);

        Assertions.assertThat(result).isFalse();
    }
}
