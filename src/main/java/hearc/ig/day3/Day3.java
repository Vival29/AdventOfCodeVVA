package hearc.ig.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class Day3 {
    private static final Logger logger = LoggerFactory.getLogger(Day3.class);
    private List<List<String>> groups = new ArrayList<>();
    private ArrayList<Character> itemByGroup = new ArrayList<>();
    private ArrayList<Character> itemsIdentiques = new ArrayList<>();

    public Integer resolvePuzzlePart1(List<String> sacs) {
        for (String s : sacs) {
            int length = s.length();
            String compartiment1 = s.substring(0, length / 2);
            String compartiment2 = s.substring(length / 2, length);
            itemsIdentiques.add(compareCompartiments(compartiment1, compartiment2));
        }
        return caclulateSum(itemsIdentiques);
    }

    public Integer resolvePuzzlePart2(List<String> sacs) {
        groups = divideByGroups(sacs);
        for (List<String> groupe : groups) {
            itemByGroup.add(compareGroup(groupe));
        }

        return caclulateSum(itemByGroup);
    }

    private Character compareGroup(List<String> groupe) {
        Character result = null;
        List<Character> elf1 = groupe.get(0).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> elf2 = groupe.get(1).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> elf3 = groupe.get(2).chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        elf1.retainAll(elf2);
        elf1.retainAll(elf3);

        for (Character c : elf1) {
            if (c != null) {
                result = c;
            }
        }
        return result;
    }

    private List<List<String>> divideByGroups(List<String> sacs) {
        List<List<String>> elfGroups = new ArrayList<>();
        for (int i = 0; i < sacs.size(); i += 3) {
            int end = Math.min(i + 3, sacs.size());
            List<String> group = sacs.subList(i, end);
            elfGroups.add(group);
        }
        return elfGroups;
    }

    private Integer caclulateSum(List<Character> itemsIdentiques) {
        List<Integer> intList = itemsIdentiques.stream().map(c -> {
            if (c >= 'a' && c <= 'z') {
                return c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z') {
                return c - 'A' + 27;
            } else {
                return null;
            }
        }).toList();

        return intList.stream().reduce(0, Integer::sum);
    }

    private Character compareCompartiments(String compartiment1, String compartiment2) {
        Character result = null;
        List<Character> charComp1 = compartiment1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> charComp2 = compartiment2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        charComp1.retainAll(charComp2);
        for (Character c : charComp1) {
            if (c != null) {
                result = c;
            }
        }
        return result;
    }

    public List<String> getSacs() {
        List<String> sacs = new ArrayList<>();
        try {
            File input = new File("src/main/java/hearc/ig/day3/inputDay3.txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String sac = scanner.nextLine();
                sacs.add(sac);
            }
            scanner.close();

        } catch (FileNotFoundException e) {

            logger.info("Le fichier n'a pas été trouvé.");
            e.printStackTrace();
        }
        return sacs;
    }
}
