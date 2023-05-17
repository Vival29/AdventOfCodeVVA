package hearc.ig;

import hearc.ig.day1.Day1;
import hearc.ig.day2.Day2;
import hearc.ig.day3.Day3;
import hearc.ig.day4.Day4;
import hearc.ig.day5.Day5;

import java.util.List;

public class Main {
    Persistance data = new Persistance();
    public static void main(String[] args) {
        //new Main().runDay1();
        //new Main().runDay2();
        //new Main().runDay3();
        //new Main().runDay4();
        new Main().runDay5();

    }
    public void runDay1(){
        Day1 day1 = new Day1();
        System.out.println("Day1");
        List<String> calories = data.getInputByLine(day1.PATH);
        System.out.println(day1.resolvePuzzlePart1(calories));
        System.out.println(day1.resolvePuzzlePart2() + "\n");
    }

    public void runDay2(){
        Day2 day2 = new Day2();
        System.out.println("Day2");
        List<String> tournament = data.getInputByLine(day2.PATH);
        System.out.println(day2.resolvePuzzlePart1(tournament));
        System.out.println(day2.resolvePuzzlePart2(tournament) + "\n");
    }
    public void runDay3(){
        Day3 day3 = new Day3();
        System.out.println("Day3");
        List<String> sacs = data.getInputByLine(day3.PATH);
        System.out.println(day3.resolvePuzzlePart1(sacs));
        System.out.println(day3.resolvePuzzlePart2(sacs)+ "\n");
    }
    public void runDay4(){
        Day4 day4 = new Day4();
        System.out.println("Day4");
        List<String> pairs = data.getInputByLine(day4.PATH);
        System.out.println(day4.resolvePuzzlePart1(pairs));
        System.out.println(day4.resolvePuzzlePart2(pairs)+ "\n");
    }
    public void runDay5(){
        Day5 day5 = new Day5();
        System.out.println("Day5");
        List<String> rawSteps = data.getInputByLine(day5.PATH);
        System.out.println(day5.resolvePuzzlePart1(rawSteps));
        System.out.println(day5.resolvePuzzlePart2(rawSteps));
    }
}