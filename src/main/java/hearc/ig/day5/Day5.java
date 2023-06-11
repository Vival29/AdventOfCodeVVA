package hearc.ig.day5;

import java.io.Serializable;
import java.util.*;

public class Day5 implements Serializable {
    public static final String PATH = "inputDay5.txt";

    public String resolvePuzzlePart1(List<String> rawSteps){
        Map<Integer, LinkedList<String>> stacks = initialSituation();
        List<String> steps = getSteps(rawSteps);
        for(String step:steps){
            List<String> current = List.of(step.split("-"));
            int numberOfMove = Integer.parseInt(current.get(0));
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
        Map<Integer, LinkedList<String>> stacks = initialSituation();
        List<String> steps = getSteps(rawSteps);
        for(String step:steps){
            List<String> current = List.of(step.split("-"));
            int numberToMove = Integer.parseInt(current.get(0));
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
            // Un StringBuilder ou un String ici ne fait aucune différence, le compilateur
            // fait la même chose
            String step = current.get(1)
                + "-"
                + current.get(3)
                + "-"
                + current.get(5);
            steps.add(step);
        }
        return steps;
    }

    public Map<Integer, LinkedList<String>> initialSituation(){
        LinkedList<String> one = new LinkedList<>(Arrays.asList("S", "P", "W", "N", "J", "Z"));
        LinkedList<String> two = new LinkedList<>(Arrays.asList("T", "S", "G"));
        LinkedList<String> three = new LinkedList<>(Arrays.asList("H", "L", "R", "Q", "V"));
        LinkedList<String> four = new LinkedList<>(Arrays.asList("D", "T", "S", "V"));
        LinkedList<String> five = new LinkedList<>(Arrays.asList("J", "M", "B", "D", "T", "Z", "Q"));
        LinkedList<String> six = new LinkedList<>(Arrays.asList("L", "Z", "C", "D", "J", "T", "W", "M"));
        LinkedList<String> seven = new LinkedList<>(Arrays.asList("J", "T", "G", "W", "M", "P", "L"));
        LinkedList<String> eight = new LinkedList<>(Arrays.asList("H", "Q", "F", "B", "T", "M", "G", "N"));
        LinkedList<String> nine = new LinkedList<>(Arrays.asList("W", "Q", "B", "P", "C", "G", "D", "R"));

        Map<Integer, LinkedList<String>> stacks = new HashMap<>();
        stacks.put(1, one);
        stacks.put(2, two);
        stacks.put(3, three);
        stacks.put(4, four);
        stacks.put(5, five);
        stacks.put(6, six);
        stacks.put(7, seven);
        stacks.put(8, eight);
        stacks.put(9, nine);
        return stacks;
    }
    //move x from y to z
    // x--> le nombre de fois qu'on repete l'opération (dequeue from x add to y) a déplacer de index y a index z

}
