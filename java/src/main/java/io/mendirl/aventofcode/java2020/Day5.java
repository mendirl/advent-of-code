package io.mendirl.aventofcode.java2020;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day5 {

    static Integer calcul_step1(List<String> inputs) {
        return inputs.stream()
                .map(Day5::place)
                .map(Place::seat)
                .max(Comparator.naturalOrder())
                .orElse(0);

    }

    static Integer calcul_step2(List<String> inputs) {
        List<Integer> collect = inputs.stream()
                .map(Day5::place)
                .map(Place::seat)
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {

            var first = collect.get(i);
            var second = collect.get(i + 1);
            var sub = second - first;
            System.out.println(first);

            if (sub == 2) return second - 1;

        }

        return 0;
    }

    static Place place(String input) {
        var row = new Row(0, 127, 0, 7);

        for (String c : input.split("")) {
            row = CALCUL.valueOf(String.valueOf(c)).convertion().apply(row);
        }

        return new Place(row.start(), row.left(), row.seat());
    }

}

enum CALCUL {
    F("F", row -> new Row(row.start(), row.start() + (row.end() - row.start()) / 2, row.left(), row.right())),
    B("B", row -> new Row(row.start() + (row.end() - row.start() + 1) / 2, row.end(), row.left(), row.right())),
    L("L", row -> new Row(row.start(), row.end(), row.left(), row.left() + (row.right() - row.left()) / 2)),
    R("R", row -> new Row(row.start(), row.end(), row.left() + (row.right() - row.left() + 1) / 2, row.right())),
    ;


    private final String half;
    private final Function<Row, Row> convertion;

    CALCUL(String half, Function<Row, Row> convertion) {
        this.half = half;
        this.convertion = convertion;
    }

    public String half() {
        return half;
    }

    public Function<Row, Row> convertion() {
        return convertion;
    }
}


record Place(int row, int column, int seat) {
}

record Row(int start, int end, int left, int right) {

    public int seat() {
        return start * 8 + left;
    }
}

