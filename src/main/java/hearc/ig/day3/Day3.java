package hearc.ig.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day3 {
    private ArrayList<String> sacs = new ArrayList<>();
    private ArrayList<Character> itemsIdentiques = new ArrayList<>();
    public Integer resolvePuzzlePart1() {
        //create an arrayList, split by \n ok
        // each index, split in two arrayList, the two compartement
        // "merge" the two compartment keeping only what is identical
        //give value for each letter then sum
        sacs = getSacs();
        for(String s:sacs){
            int length = s.length();
            String compartiment1 = s.substring(0,length/2);
            String compartiment2 = s.substring(length/2, length);
            itemsIdentiques.add(compareCompartiments(compartiment1, compartiment2));
        }
        return caclulateSum(itemsIdentiques);
    }


    private Integer caclulateSum(ArrayList<Character> itemsIdentiques) {
        int sum = 0;
        List<Integer> intList = itemsIdentiques.stream().map(c -> {
            if (c >= 'a' && c <= 'z') {
                return c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z') {
                return c - 'A' + 27;
            } else {
                return null;
            }
        }).collect(Collectors.toList());

        return intList.stream().reduce(0, Integer::sum);
    }

    private Character compareCompartiments(String compartiment1, String compartiment2) {
        Character result= null;
        List<Character> charComp1 = compartiment1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> charComp2 = compartiment2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        charComp1.retainAll(charComp2);
            for (Character c:charComp1) {
                if(c != null){
                    result = c;
                }
            }
        return result;
    }

    private ArrayList<String> getSacs(){
        try {
            File input = new File("src/main/java/hearc/ig/day3/inputDay3.txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String sac = scanner.nextLine();
                sacs.add(sac);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
            e.printStackTrace();
        }
        return sacs;
    }
}
