package hearc.ig.day5;

import java.io.Serializable;
import java.util.*;

public class Day5 implements Serializable {
    public static final String PATH = "src/main/java/hearc/ig/day5/inputDay5.txt";
    Map<Integer, LinkedList<String>> stacks = new HashMap<>();

    public String resolvePuzzlePart1(List<String> rawSteps){
        initialSituation();
        List<String> steps = getSteps(rawSteps);
        for(String step:steps){
            List<String> current = List.of(step.split("-"));
            Integer numberOfMove = Integer.parseInt(current.get(0));
            Integer from = Integer.parseInt(current.get(1));
            Integer to = Integer.parseInt(current.get(2));
            for(int i=0; i<numberOfMove;i++){
                String crate = stacks.get(from).removeFirst();
                stacks.get(to).addFirst(crate);
            }
        }
        return getTopCrates(stacks);
    }
    public String resolvePuzzlePart2(List<String> rawSteps){
        initialSituation();
        List<String> steps = getSteps(rawSteps);
        for(String step:steps){
            List<String> current = List.of(step.split("-"));
            Integer numberToMove = Integer.parseInt(current.get(0));
            Integer from = Integer.parseInt(current.get(1));
            Integer to = Integer.parseInt(current.get(2));
            if(numberToMove==1){
                String crate = stacks.get(from).removeFirst();
                stacks.get(to).addFirst(crate);
            } else {
                List<String> tmp = stacks.get(from).subList(0, numberToMove);
                List<String> tmpCopy = new ArrayList<>(tmp);
                while(numberToMove>0) {
                    stacks.get(to).addFirst(tmpCopy.get(numberToMove - 1));
                    stacks.get(from).removeFirst();
                    numberToMove--;
                }

            }
        }
        return getTopCrates(stacks);
    }

    private String getTopCrates(Map<Integer, LinkedList<String>> stacks) {
        StringBuilder answer = new StringBuilder();
        answer.append(stacks.get(1).getFirst());
        answer.append(stacks.get(2).getFirst());
        answer.append(stacks.get(3).getFirst());
        if(stacks.size()>3) {
            answer.append(stacks.get(4).getFirst());
            answer.append(stacks.get(5).getFirst());
            answer.append(stacks.get(6).getFirst());
            answer.append(stacks.get(7).getFirst());
            answer.append(stacks.get(8).getFirst());
            answer.append(stacks.get(9).getFirst());
        }
        return answer.toString();
    }

    private List<String> getSteps(List<String> rawSteps) {
        List<String> steps = new ArrayList<>();

        for(String rawStep:rawSteps){
            List<String> current = List.of(rawStep.split(" "));
            StringBuilder step = new StringBuilder();
            step.append(current.get(1));
            step.append("-");
            step.append(current.get(3));
            step.append("-");
            step.append(current.get(5));
            steps.add(step.toString());
        }
        return steps;
    }

    public Map<Integer, LinkedList<String>> initialSituation(){
        stacks.clear();
        List<String> one = new LinkedList<>(Arrays.asList("S", "P", "W", "N", "J", "Z"));
        List<String> two = new LinkedList<>(Arrays.asList("T", "S", "G"));
        List<String> three = new LinkedList<>(Arrays.asList("H", "L", "R", "Q", "V"));
        List<String> four = new LinkedList<>(Arrays.asList("D", "T", "S", "V"));
        List<String> five = new LinkedList<>(Arrays.asList("J", "M", "B", "D", "T", "Z", "Q"));
        List<String> six = new LinkedList<>(Arrays.asList("L", "Z", "C", "D", "J", "T", "W", "M"));
        List<String> seven = new LinkedList<>(Arrays.asList("J", "T", "G", "W", "M", "P", "L"));
        List<String> eight = new LinkedList<>(Arrays.asList("H", "Q", "F", "B", "T", "M", "G", "N"));
        List<String> nine = new LinkedList<>(Arrays.asList("W", "Q", "B", "P", "C", "G", "D", "R"));

        stacks.put(1, (LinkedList<String>) one);
        stacks.put(2, (LinkedList<String>) two);
        stacks.put(3, (LinkedList<String>) three);
        stacks.put(4, (LinkedList<String>) four);
        stacks.put(5, (LinkedList<String>) five);
        stacks.put(6, (LinkedList<String>) six);
        stacks.put(7, (LinkedList<String>) seven);
        stacks.put(8, (LinkedList<String>) eight);
        stacks.put(9, (LinkedList<String>) nine);


        return stacks;
    }
    //move x from y to z
    // x--> le nombre de fois qu'on repete l'opération (dequeue from x add to y) a déplacer de index y a index z

}
