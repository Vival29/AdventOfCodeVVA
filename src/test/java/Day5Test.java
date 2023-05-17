
import hearc.ig.day5.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class Day5Test {
    Day5 day5 = Mockito.mock(Day5.class);
    Map<Integer, LinkedList<String>> stacksTest = new HashMap<>();
    @BeforeEach
            void init(){
        List<String> one = new LinkedList<>(Arrays.asList("N", "Z"));
        List<String> two = new LinkedList<>(Arrays.asList("D", "C", "M"));
        List<String> three = new LinkedList<>(Arrays.asList("P"));
        stacksTest.put(1, (LinkedList<String>) one);
        stacksTest.put(2, (LinkedList<String>) two);
        stacksTest.put(3, (LinkedList<String>) three);
    }

    @Test
    void resolvePuzzlePart2_GivenExample_shouldGiveMCD(){
        List<String> rawSteps = Arrays.asList("move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2");
        Mockito.when(day5.initialSituation()).thenReturn(stacksTest);
        Assertions.assertEquals("MCD", day5.resolvePuzzlePart2(rawSteps));

    }
}
