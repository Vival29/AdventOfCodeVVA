package hearc.ig.day4;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class Day4 {

    public static final String PATH = "inputDay4.txt";

    // Tu n'avais pas vesoin de ton état pairs ici, il n'était pas utilisé

    public Integer resolvePuzzlePart1(List<String> pairs) {
        int sum = 0;
        for (String pair : pairs) {
            List<Set<Integer>> ranges = getRanges(pair);
            Set<Integer> rangeElf1 = ranges.get(0);
            Set<Integer> rangeElf2 = ranges.get(1);
            if (oneIsFullyContained(rangeElf1, rangeElf2)) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public Integer resolvePuzzlePart2(List<String> pairs) {

        int sum2 = 0;
        for (String pair : pairs) {
            List<Set<Integer>> ranges = getRanges(pair);
            Set<Integer> rangeElf1 = ranges.get(0);
            Set<Integer> rangeElf2 = ranges.get(1);
            if ((anyOverlaps(rangeElf1, rangeElf2)) || (oneIsFullyContained(rangeElf1, rangeElf2))) {
                sum2 = sum2 + 1;
            }
        }
        return sum2;
    }


    private boolean anyOverlaps(Set<Integer> range1, Set<Integer> range2) {
        return range1.stream().anyMatch(range2::contains);
    }

    // Tu as meilleure temps de faire de la comparaison entre Set plutôt que List.
    private boolean oneIsFullyContained(Set<Integer> range1, Set<Integer> range2) {
        return range1.containsAll(range2) || range2.containsAll(range1);
    }

    private List<Set<Integer>> getRanges(String pair) {
        List<Set<Integer>> ranges = new ArrayList<>();
        String[] elfs = pair.split(",");
        String[] elf1 = elfs[0].split("-");
        String[] elf2 = elfs[1].split("-");

        String elf1start = elf1[0];
        String elf1end = elf1[1];
        String elf2start = elf2[0];
        String elf2end = elf2[1];

        Set<Integer> rangeElf1 = createRangeOfSectionID(elf1start, elf1end);
        Set<Integer> rangeElf2 = createRangeOfSectionID(elf2start, elf2end);
        ranges.add(rangeElf1);
        ranges.add(rangeElf2);
        return ranges;
    }


    private Set<Integer> createRangeOfSectionID(String start, String end) {
        Set<Integer> range = new HashSet<>();
        int s = Integer.parseInt(start);
        int e = Integer.parseInt(end);
        for (int i = s; i < e + 1; i++) {
            range.add(i);
        }
        return range;
    }


}
