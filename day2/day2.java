package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {

    // can't resist cs2103t principles even though should follow cs3233 principles

    private static final String THEIR_ROCK = "A";
    private static final String THEIR_PAPER = "B";
    private static final String THEIR_SCISSORS = "C";
    private static final String YOUR_ROCK = "X";
    private static final String YOUR_PAPER = "Y";
    private static final String YOUR_SCISSORS = "Z";
    private static final String LOSE_ROUND = "X";
    private static final String DRAW_ROUND = "Y";
    private static final String WIN_ROUND = "Z";
    private static final int ROCK_POINT = 1;
    private static final int PAPER_POINT = 2;
    private static final int SCISSORS_POINT = 3;
    private static final int LOSE_POINT = 0;
    private static final int DRAW_POINT = 3;
    private static final int WIN_POINT = 6;

    public static int calculateScorePartOne(String theirs, String yours) {
        int score = 0;
        switch (yours) {
            case YOUR_ROCK -> {
                score += ROCK_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += DRAW_POINT;
                    case THEIR_PAPER -> score += LOSE_POINT;
                    case THEIR_SCISSORS -> score += WIN_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + yours);
                }
            }
            case YOUR_PAPER -> {
                score += PAPER_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += WIN_POINT;
                    case THEIR_PAPER -> score += DRAW_POINT;
                    case THEIR_SCISSORS -> score += LOSE_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + yours);
                }
            }
            case YOUR_SCISSORS -> {
                score += SCISSORS_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += LOSE_POINT;
                    case THEIR_PAPER -> score += WIN_POINT;
                    case THEIR_SCISSORS -> score += DRAW_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + yours);
                }
            }
            default -> throw new IllegalArgumentException(theirs + " " + yours);
        }
        return score;
    }

    public static int calculateScorePartTwo(String theirs, String round) {
        int score = 0;
        switch (round) {
            case LOSE_ROUND -> {
                score += LOSE_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += SCISSORS_POINT;
                    case THEIR_PAPER -> score += ROCK_POINT;
                    case THEIR_SCISSORS -> score += PAPER_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + round);
                }
            }
            case DRAW_ROUND -> {
                score += DRAW_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += ROCK_POINT;
                    case THEIR_PAPER -> score += PAPER_POINT;
                    case THEIR_SCISSORS -> score += SCISSORS_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + round);
                }
            }
            case WIN_ROUND -> {
                score += WIN_POINT;
                switch (theirs) {
                    case THEIR_ROCK -> score += PAPER_POINT;
                    case THEIR_PAPER -> score += SCISSORS_POINT;
                    case THEIR_SCISSORS -> score += ROCK_POINT;
                    default -> throw new IllegalArgumentException(theirs + " " + round);
                }
            }
            default -> throw new IllegalArgumentException(theirs + " " + round);
        }
        return score;
    }

    public static void main(String[] args) {
        File input = new File("day2/input.txt");

        try {
            Scanner sc = new Scanner(input);
            int partOneScore = 0;
            int partTwoScore = 0;
            while (sc.hasNextLine()) {
                String[] round = sc.nextLine().split("\s");
                partOneScore += calculateScorePartOne(round[0], round[1]);
                partTwoScore += calculateScorePartTwo(round[0], round[1]);
            }
            System.out.println("Part 1 answer: " + partOneScore);
            System.out.println("Part 2 answer: " + partTwoScore);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
