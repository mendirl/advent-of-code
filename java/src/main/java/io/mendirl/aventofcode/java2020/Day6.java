package io.mendirl.aventofcode.java2020;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 {

    static Integer calcul_step1(List<String> inputs) {
        return calcul_1(inputs);
    }

    static Integer calcul_step2(List<String> inputs) {
        return calcul_2(inputs);
    }

    static Integer calcul_1(List<String> inputs) {
        //add an empty final line, for algo sake
        inputs.add("");

        var answers = new StringBuilder();
        var result = 0;

        for (String line : inputs) {
            answers.append(line.trim());
            if (line.trim().isEmpty()) {
                result += Arrays.stream(answers.toString().split("")).distinct().count();

                System.out.println("result " + result);

                answers = new StringBuilder();
            }
        }

        return result;
    }


    static Integer calcul_2(List<String> inputs) {
        //add an empty final line, for algo sake
        inputs.add("");

        var answers = new StringBuilder();
        var result = 0L;
        var nb = 0;

        for (String line : inputs) {

            if (line.trim().isEmpty()) {
                var tmp = nb;
                result += Arrays.stream(answers.toString().split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() == tmp).map(Map.Entry::getKey).count();

                System.out.println("result " + result);

                answers = new StringBuilder();
                nb= 0;
            } else {
                nb++;
                answers.append(line.trim());
            }
        }

        return Long.valueOf(result).intValue();
    }

}


