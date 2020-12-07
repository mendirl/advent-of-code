package io.mendirl.aventofcode.java2020;


import java.util.List;

public class Day3 {


    static String place(Coord coord, List<String> grid) {
        var pos_r = 0;
        var pos_d = 0;

        pos_d += coord.d();
        pos_r += coord.r();

        char c = grid.get(pos_d).charAt(pos_r);
        return c == '#' ? "X" : "O";
    }

}

record Coord(int r, int d) {
}
