package hearc.ig.day3;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class Day3 {
    public static final String PATH = "inputDay3.txt";

    // Pareil ici, tente d'éviter d'introduire des états lorsqu'ils ne sont pas nécessaires

    public Integer resolvePuzzlePart1(List<String> sacs) {
        List<Character> itemsIdentiques = new ArrayList<>();
        for (String s : sacs) {
            int length = s.length();
            String compartiment1 = s.substring(0, length / 2);
            String compartiment2 = s.substring(length / 2, length);
            itemsIdentiques.add(compareCompartiments(compartiment1, compartiment2));
        }
        return caclulateSum(itemsIdentiques);
    }

    public Integer resolvePuzzlePart2(List<String> sacs) {
        List<Character> itemByGroup = new ArrayList<>();
        List<List<String>> groups = divideByGroups(sacs);
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
        // mapToInt + sum est sans doute plus simple
        return itemsIdentiques.stream().mapToInt(c -> {
            if (c >= 'a' && c <= 'z') {
                return c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z') {
                return c - 'A' + 27;
            } else {
                return 0;
            }
        }).sum();
    }

    private Character compareCompartiments(String compartiment1, String compartiment2) {
        List<Character> charComp1 = compartiment1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> charComp2 = compartiment2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        charComp1.retainAll(charComp2);
        // Tu peux retirer result ici
        for (Character c : charComp1) {
            if (c != null) {
                return c;
            }
        }
        // Et retourner une Exception, car tu es pas censé tombé là..
        throw new IllegalStateException();
    }

}
