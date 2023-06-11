package hearc.ig.day1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
    public static final String PATH = "inputDay1.txt";

    public List<Integer> listSumByElf (List<String> calories) {
        List<List<Integer>> caloriesByElf = splitByNull(calories);
        return caloriesByElf.stream().map(list -> list.stream().mapToInt(Integer::intValue).sum()).collect(Collectors.toList());
    }

    public Integer resolvePuzzlePart1(List<String> calories){
        return listSumByElf(calories).stream().max(Integer::compareTo).orElse(0);
    }

    // Privilégie les fonctions pures (méthodes pures ici), afin de ne pas garder d'état entre tes méthodes (listSumByElf)
    public Integer resolvePuzzlePart2(List<String> calories){
        return listSumByElf(calories).stream()
            .sorted(Collections.reverseOrder(Integer::compareTo))
            .mapToInt(x -> x) // Pour pouvoir utiliser sum()
            .limit(3)
            .sum();
    }

    private List<List<Integer>> splitByNull(List<String> calories) {
        List<List<Integer>> caloriesByElf = new ArrayList<>();
        List<Integer> currentElf = new ArrayList<>();
        for(String calorie:calories){
            if(calorie.equals("")){
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
