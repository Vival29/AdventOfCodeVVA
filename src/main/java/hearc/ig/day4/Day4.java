package hearc.ig.day4;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class Day4 {

    private static final Logger logger = LoggerFactory.getLogger(Day4.class);
    public static final String PATH = "src/main/java/hearc/ig/day4/inputDay4.txt";
    private List<String> pairs = new ArrayList<>();

    public Integer resolvePuzzlePart1(List<String> pairs) {
        Integer sum = 0;
        for (String pair : pairs) {
            List<List<Integer>> ranges = getRanges(pair);
            List<Integer> rangeElf1 = ranges.get(0);
            List<Integer> rangeElf2 = ranges.get(1);
            if (oneIsFullyContained(rangeElf1, rangeElf2)) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public Integer resolvePuzzlePart2(List<String> pairs) {

        Integer sum2 = 0;
        for (String pair : pairs) {
            List<List<Integer>> ranges = getRanges(pair);
            List<Integer> rangeElf1 = ranges.get(0);
            List<Integer> rangeElf2 = ranges.get(1);
            if ((anyOverlaps(rangeElf1, rangeElf2)) || (oneIsFullyContained(rangeElf1, rangeElf2))) {
                sum2 = sum2 + 1;
            }
        }
        return sum2;
    }


    private boolean anyOverlaps(List<Integer> range1, List<Integer> range2) {
        return range1.stream().anyMatch(range2::contains);
    }

    private boolean oneIsFullyContained(List<Integer> range1, List<Integer> range2) {
        boolean isFullyContained = false;

        if (range1.containsAll(range2) || range2.containsAll(range1)) {
            isFullyContained = true;
        }

        return isFullyContained;

    }

    private List<List<Integer>> getRanges(String pair) {
        List<List<Integer>> ranges = new ArrayList<>();
        String[] elfs = pair.split(",");
        String[] elf1 = elfs[0].split("-");
        String[] elf2 = elfs[1].split("-");

        String elf1start = elf1[0];
        String elf1end = elf1[1];
        String elf2start = elf2[0];
        String elf2end = elf2[1];

        List<Integer> rangeElf1 = createRangeOfSectionID(elf1start, elf1end);
        List<Integer> rangeElf2 = createRangeOfSectionID(elf2start, elf2end);
        ranges.add(rangeElf1);
        ranges.add(rangeElf2);
        return ranges;
    }


    private List<Integer> createRangeOfSectionID(String start, String end) {
        List<Integer> range = new ArrayList<>();
        int s = Integer.parseInt(start);
        int e = Integer.parseInt(end);
        for (int i = s; i < e + 1; i++) {
            range.add(i);
        }
        return range;
    }


}
