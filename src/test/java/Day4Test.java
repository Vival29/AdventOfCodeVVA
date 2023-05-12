import hearc.ig.day4.Day4;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day4Test {

    Day4 day4 = new Day4();

    @Test
    void resolvePuzzlePart2_GivenExample_shouldGive4(){
        List<String> pairs = Arrays.asList("2-4,6-8","2-3,4-5","5-7,7-9","2-8,3-7","6-6,4-6","2-6,4-8");
        Assertions.assertEquals(4, day4.resolvePuzzlePart2(pairs));

    }
}
