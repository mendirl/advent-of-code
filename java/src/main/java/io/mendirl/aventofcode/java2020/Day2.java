package io.mendirl.aventofcode.java2020;

import java.util.regex.Pattern;

public class Day2 {


    public static boolean filter_step1(DataLine dataLine) {
        var count = dataLine.password().chars().filter(_char -> _char == dataLine.charToFind()).count();
        return count >= dataLine.lower() && count <= dataLine.upper();
    }


    static boolean filter_step2(DataLine dataLine) {
        return isFirst(dataLine) ^ isSecond(dataLine);
    }

    static private boolean isFirst(DataLine dataLine) {
        return dataLine.password().charAt(dataLine.lower() - 1) == dataLine.charToFind();
    }

    static private boolean isSecond(DataLine dataLine) {
        return dataLine.password().charAt(dataLine.upper() - 1) == dataLine.charToFind();
    }


    static DataLine convert(String line) {
        var regexp = "(\\d+)-(\\d+) (\\w): (\\w*)";

        var pattern = Pattern.compile(regexp);
        var matcher = pattern.matcher(line);

        if (!matcher.find()) return null;

        return new DataLine(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), matcher.group(3).charAt(0), matcher.group(4));
    }

}

record DataLine(
        int lower,
        int upper,
        char charToFind,
        String password) {
}

