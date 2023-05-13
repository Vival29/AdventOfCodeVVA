package hearc.ig.day2;

import hearc.ig.day1.Day1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Day2 {
    private static final Logger logger = LoggerFactory.getLogger(Day1.class);
    public static final String PATH = "src/main/java/hearc/ig/day2/inputDay2.txt";

    public Integer resolvePuzzlePart1(List<String> tournament) {
        Integer score = 0;
        for (String match : tournament) {
            char[] hand = match.toCharArray();
            char opponentHand = hand[0];
            char myHand = hand[2];

            switch (opponentHand) {
                case 'A':
                    switch (myHand) {
                        case 'X':
                            score = score + 1 + 3;
                            break;
                        case 'Y':
                            score = score + 2 + 6;
                            break;
                        case 'Z':
                            score = score + 3 + 0;
                            break;
                    }
                    break;
                case 'B':
                    switch (myHand) {
                        case 'X':
                            score = score + 1 + 0;
                            break;
                        case 'Y':
                            score = score + 2 + 3;
                            break;
                        case 'Z':
                            score = score + 3 + 6;
                            break;
                    }
                    break;
                case 'C':
                    switch (myHand) {
                        case 'X':
                            score = score + 1 + 6;
                            break;
                        case 'Y':
                            score = score + 2 + 0;
                            break;
                        case 'Z':
                            score = score + 3 + 3;
                            break;
                    }
                    break;
            }
        }
        return score;
    }

    public Integer resolvePuzzlePart2(List<String> tournament) {
        Integer realscore=0;
        for (String match : tournament) {
            char[] hand = match.toCharArray();
            char opponentHand = hand[0];
            char myHand = hand[2];

            switch (opponentHand) {
                case 'A':
                    switch (myHand) {
                        case 'X':
                            realscore = realscore + 3 + 0;
                            break;
                        case 'Y':
                            realscore = realscore + 1 + 3;
                            break;
                        case 'Z':
                            realscore = realscore + 2 + 6;
                            break;
                    }
                    break;
                case 'B':
                    switch (myHand) {
                        case 'X':
                            realscore = realscore + 1 + 0;
                            break;
                        case 'Y':
                            realscore = realscore + 2 + 3;
                            break;
                        case 'Z':
                            realscore = realscore + 3 + 6;
                            break;
                    }
                    break;
                case 'C':
                    switch (myHand) {
                        case 'X':
                            realscore = realscore + 2 + 0;
                            break;
                        case 'Y':
                            realscore = realscore + 3 + 3;
                            break;
                        case 'Z':
                            realscore = realscore + 1 + 6;
                            break;
                    }
                    break;
            }
        }
        return realscore;
    }
}


