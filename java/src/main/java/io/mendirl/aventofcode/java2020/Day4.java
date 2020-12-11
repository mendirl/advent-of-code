package io.mendirl.aventofcode.java2020;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Day4 {

    static int calcul_step1(List<String> inputs) {
        return calcul(inputs, valid_1());
    }


    static Integer calcul_step2(List<String> inputs) {
        return calcul(inputs, valid_2());
    }

    static int calcul(List<String> inputs, Predicate<String> predicate) {
        //add an empty final line, for algo sake
        inputs.add("");

        var nb_pass = 0;

        var passport = new StringBuilder();
        var result = 0;

        for (String line : inputs) {
            passport.append(line);
            passport.append(" ");
            if (line.trim().isEmpty()) {
                nb_pass += 1;
                if (predicate.test(passport.toString().trim())) {
                    System.out.println(passport);
                    result += 1;
                }

                passport = new StringBuilder();
            }
        }

        System.out.println("nb password : " + nb_pass);

        return result;
    }

    static Predicate<String> valid_1() {
        return passport -> {
            var fields = List.of("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:", "cid:");

            var remains = fields.stream()
                    .filter(field -> !passport.contains(field)).collect(Collectors.toList());

            if (remains.isEmpty()) return true;
            if (remains.size() == 1 && remains.get(0).equals("cid:")) return true;

            return false;
        };
    }

    static Predicate<String> valid_2() {
        return passport -> {
            var validations = Arrays.stream(passport.split(" "))
                    .map(Day4::validation).flatMap(Collection::stream).collect(Collectors.toList());

            return (validations.size() >= 7);
        };
    }

    static List<VALIDATION> validation(String input) {
        return Arrays.stream(VALIDATION.values())
                .filter(validation -> input.startsWith(validation.field()))
                .filter(validation -> validation.rule().test(input.split(":")[1]))
                .collect(Collectors.toList());
    }

}

enum VALIDATION {
    BYR("byr:", arg -> arg.length() == 4 && Integer.parseInt(arg) >= 1920 && Integer.parseInt(arg) <= 2002),
    IYR("iyr:", arg -> arg.length() == 4 && Integer.parseInt(arg) >= 2010 && Integer.parseInt(arg) <= 2020),
    EYR("eyr:", arg -> arg.length() == 4 && Integer.parseInt(arg) >= 2020 && Integer.parseInt(arg) <= 2030),
    HGT("hgt:", arg -> {
        if (arg.endsWith("cm")) {
            var tmp = arg.replace("cm", "");
            return Integer.parseInt(tmp) >= 150 && Integer.parseInt(tmp) <= 193;
        } else if (arg.endsWith("in")) {
            var tmp = arg.replace("in", "");
            return Integer.parseInt(tmp) >= 59 && Integer.parseInt(tmp) <= 76;
        } else {
            return false;
        }
    }),
    HCL("hcl:", arg -> arg.matches("#[a-f0-9]{6}")),
    ECL("ecl:", arg -> List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(arg)),
    PID("pid:", arg -> arg.matches("\\d{9}"));


    private final String field;
    private final Predicate<String> rule;

    VALIDATION(String field, Predicate<String> rule) {
        this.field = field;
        this.rule = rule;
    }

    public String field() {
        return field;
    }

    public Predicate<String> rule() {
        return rule;
    }
}
