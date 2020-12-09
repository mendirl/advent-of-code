package io.mendirl.aventofcode.java2020;


import java.util.List;

public class Day3 {


    static Integer calcul_step1(List<String> inputs) {
        return calcul(new Coord(3, 1), inputs);
    }

    static Integer calcul_step2(List<String> inputs) {
        return List.of(
                new Coord(1, 1),
                new Coord(3, 1),
                new Coord(5, 1),
                new Coord(7, 1),
                new Coord(1, 2)
        ).stream()
                .map(coord -> calcul(coord, inputs))
                .reduce(1, (x, y) -> x * y);
    }


    static Integer calcul(Coord coord, List<String> inputs) {
        var length = inputs.get(0).length();

        var pos_r = coord.r();
        var pos_d = coord.d();
        var size = 0;

        while (pos_d < inputs.size()) {
            char c = inputs.get(pos_d).charAt(pos_r % length);
            size += c == '#' ? 1 : 0;
            pos_r += coord.r();
            pos_d += coord.d();

        }
        ;
        return size;
    }

}

record Coord(int r, int d) {
}
