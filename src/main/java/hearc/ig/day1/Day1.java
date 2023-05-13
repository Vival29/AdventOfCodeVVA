package hearc.ig.day1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
    private static final Logger logger = LoggerFactory.getLogger(Day1.class);
    public static final String PATH = "src/main/java/hearc/ig/day1/inputDay1.txt";

    List<Integer> listSumByElf = new ArrayList<>();

    public Integer resolvePuzzlePart1(List<String> calories){
        List<List<Integer>> caloriesByElf = splitByNull(calories);
        listSumByElf = caloriesByElf.stream().map(list -> list.stream().mapToInt(Integer::intValue).sum())
                .collect(Collectors.toList());
        return listSumByElf.stream().max(Integer::compareTo).orElse(0);
    }
    public Integer resolvePuzzlePart2(){
        List<Integer> top3Elfs = listSumByElf.stream().sorted(Collections.reverseOrder(Integer::compareTo)).limit(3).collect(Collectors.toList());

        return top3Elfs.stream().reduce(0, (a,b)->a+b);
    }

    private List<List<Integer>> splitByNull(List<String> calories) {
        List<List<Integer>> caloriesByElf = new ArrayList<>();
        List<Integer> currentElf = new ArrayList<>();
        for(String calorie:calories){
            if(calorie == ""){
                caloriesByElf.add(currentElf);
                currentElf = new ArrayList<>();
            } else {
                currentElf.add(Integer.parseInt(calorie));
            }
        }
        caloriesByElf.add(currentElf);
        return caloriesByElf;

    }
}
