package hearc.ig;

import hearc.ig.day3.Day3;
import hearc.ig.day4.Day4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        Day4 day4 = new Day4();
        List<String> sacs = day3.getSacs();
        System.out.println(day3.resolvePuzzlePart1(sacs));
        System.out.println(day3.resolvePuzzlePart2(sacs));
        List<String> pairs = day4.getPairs();
        System.out.println(day4.resolvePuzzlePart1(pairs));
        System.out.println(day4.resolvePuzzlePart2(pairs));
    }
}