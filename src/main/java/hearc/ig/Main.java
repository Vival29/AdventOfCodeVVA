package hearc.ig;

import hearc.ig.day1.Day1;
import hearc.ig.day3.Day3;
import hearc.ig.day4.Day4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        Day3 day3 = new Day3();
        Day4 day4 = new Day4();
        Persistance data = new Persistance();

        List<String> calories = data.getInputByLine(day1.PATH);
        System.out.println("Day1");
        System.out.println(day1.resolvePuzzlePart1(calories));
        System.out.println(day1.resolvePuzzlePart2());
        System.out.println("Day3");
        List<String> sacs = data.getInputByLine(day3.PATH);
        System.out.println(day3.resolvePuzzlePart1(sacs));
        System.out.println(day3.resolvePuzzlePart2(sacs));
        System.out.println("Day4");
        List<String> pairs = data.getInputByLine(day4.PATH);
        System.out.println(day4.resolvePuzzlePart1(pairs));
        System.out.println(day4.resolvePuzzlePart2(pairs));


    }
}