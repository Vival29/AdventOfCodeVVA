package hearc.ig.day2;

import hearc.ig.day1.Day1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Day2 {
    public static final String PATH = "inputDay2.txt";

    public Integer resolvePuzzlePart1(List<String> tournament) {
        // On privilégie les types primitifs
        int score = 0;
        for (String match : tournament) {
            char[] hand = match.toCharArray();
            char opponentHand = hand[0];
            char myHand = hand[2];

            // J'ai juste remplacé par le nouveau switch (proposé par mon IDE)
            switch (opponentHand) {
                case 'A' -> {
                    switch (myHand) {
                        case 'X' -> score = score + 1 + 3;
                        case 'Y' -> score = score + 2 + 6;
                        case 'Z' -> score = score + 3 + 0;
                    }
                }
                case 'B' -> {
                    score = switch (myHand) {
                        case 'X' -> score + 1 + 0;
                        case 'Y' -> score + 2 + 3;
                        case 'Z' -> score + 3 + 6;
                        default -> score;
                    };
                }
                case 'C' -> {
                    score = switch (myHand) {
                        case 'X' -> score + 1 + 6;
                        case 'Y' -> score + 2 + 0;
                        case 'Z' -> score + 3 + 3;
                        default -> score;
                    };
                }
            }
        }
        return score;
    }

    public Integer resolvePuzzlePart2(List<String> tournament) {
        // On privilégie les types primitifs
        int realscore=0;
        for (String match : tournament) {
            char[] hand = match.toCharArray();
            char opponentHand = hand[0];
            char myHand = hand[2];

            // J'ai juste remplacé par le nouveau switch (proposé par mon IDE)
            switch (opponentHand) {
                case 'A' -> {
                    switch (myHand) {
                        case 'X' -> realscore = realscore + 3 + 0;
                        case 'Y' -> realscore = realscore + 1 + 3;
                        case 'Z' -> realscore = realscore + 2 + 6;
                    }
                }
                case 'B' -> {
                    realscore = switch (myHand) {
                        case 'X' -> realscore + 1 + 0;
                        case 'Y' -> realscore + 2 + 3;
                        case 'Z' -> realscore + 3 + 6;
                        default -> realscore;
                    };
                }
                case 'C' -> {
                    realscore = switch (myHand) {
                        case 'X' -> realscore + 2 + 0;
                        case 'Y' -> realscore + 3 + 3;
                        case 'Z' -> realscore + 1 + 6;
                        default -> realscore;
                    };
                }
            }
        }
        return realscore;
    }
}


