package io.mendirl.aventofcode.java2020;

import java.util.List;
import java.util.regex.Pattern;

public class Day2 {


    static long calcul_step1(List<String> inputs) {
        return inputs.stream()
                .map(Day2::convert)
                .filter(Day2::calcul_step1_inner).count();
    }

    static long calcul_step2(List<String> inputs) {
        return inputs.stream()
                .map(Day2::convert)
                .filter(Day2::calcul_step2_inner).count();
    }

    static DataLine convert(String line) {
        var regexp = "(\\d+)-(\\d+) (\\w): (\\w*)";

        var pattern = Pattern.compile(regexp);
        var matcher = pattern.matcher(line);

        return new DataLine(Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                matcher.group(3).charAt(0),
                matcher.group(4));
    }


    static boolean calcul_step1_inner(DataLine dataLine) {
        var count = dataLine.password().chars().filter(_char -> _char == dataLine.charToFind()).count();
        return count >= dataLine.lower() && count <= dataLine.upper();
    }

    static boolean calcul_step2_inner(DataLine dataLine) {
        return isFirst(dataLine) ^ isSecond(dataLine);
    }

    static private boolean isFirst(DataLine dataLine) {
        return dataLine.password().charAt(dataLine.lower() - 1) == dataLine.charToFind();
    }

    static private boolean isSecond(DataLine dataLine) {
        return dataLine.password().charAt(dataLine.upper() - 1) == dataLine.charToFind();
    }

}

record DataLine(
        int lower,
        int upper,
        char charToFind,
        String password) {
}

