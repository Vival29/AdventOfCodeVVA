package hearc.ig.day4;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    private static final Logger logger = LogManager.getLogger(Day4.class);
    private ArrayList<String> pairs = new ArrayList<>();

    public Integer resolvePuzzlePart1() {
        Integer sum = 0;
        pairs = getPairs();
        for (String pair : pairs) {
            if (oneIsFullyContained(pair)) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    private boolean oneIsFullyContained(String pair) {
        boolean isFullyContained = false;
        String[] elfs = pair.split(",");
        String[] elf1 = elfs[0].split("-");
        String[] elf2 = elfs[1].split("-");

        String elf1start = elf1[0];
        String elf1end = elf1[1];
        String elf2start = elf2[0];
        String elf2end = elf2[1];

        List<Integer> rangeElf1 = createRangeOfSectionID(elf1start, elf1end);
        List<Integer> rangeElf2 = createRangeOfSectionID(elf2start, elf2end);

        if (rangeElf1.containsAll(rangeElf2) || rangeElf2.containsAll(rangeElf1)) {
            isFullyContained = true;
        }

        return isFullyContained;

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

    private ArrayList<String> getPairs() {
        try {
            File input = new File("src/main/java/hearc/ig/day4/inputDay4.txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String pair = scanner.nextLine();
                pairs.add(pair);
            }
            scanner.close();

        } catch (FileNotFoundException e) {

            logger.info("Le fichier n'a pas été trouvé.");
            e.printStackTrace();
        }
        return pairs;
    }

}
