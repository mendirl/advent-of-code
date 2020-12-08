package io.mendirl.aventofcode.java2020;


import java.util.List;

public class Day3 {


    static Integer calcul(Coord coord, List<String> grid) {
        var length = grid.get(0).length();

        var pos_r = coord.r();
        var pos_d = coord.d();
        var size = 0;

        while (pos_d < grid.size()) {
            char c = grid.get(pos_d).charAt(pos_r % length);
            size += c == '#' ? 1 : 0;
            pos_r += coord.r();
            pos_d += coord.d();

        } ;
        return size;
    }

}

record Coord(int r, int d) {
}
