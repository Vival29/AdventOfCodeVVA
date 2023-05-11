package hearc.ig;

import hearc.ig.day3.Day3;
import hearc.ig.day4.Day4;

public class Main {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        Day4 day4 = new Day4();

        System.out.println(day3.resolvePuzzlePart1());
        System.out.println(day3.resolvePuzzlePart2());

        System.out.println(day4.resolvePuzzlePart1());
    }
}