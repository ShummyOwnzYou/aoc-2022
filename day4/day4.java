package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {

    public static int[] parseBounds(String bounds) {
        String[] split = bounds.split(",");
        int firstLeftBound = Integer.parseInt(split[0].split("-")[0]);
        int firstRightBound = Integer.parseInt(split[0].split("-")[1]);
        int secondLeftBound = Integer.parseInt(split[1].split("-")[0]);
        int secondRightBound = Integer.parseInt(split[1].split("-")[1]);
        return new int[] {firstLeftBound, firstRightBound, secondLeftBound, secondRightBound};
    }

    public static int checkFullOverlap(int[] boundsArray) {
        int firstLeftBound = boundsArray[0];
        int firstRightBound = boundsArray[1];
        int secondLeftBound = boundsArray[2];
        int secondRightBound = boundsArray[3];
        if (firstLeftBound >= secondLeftBound && firstRightBound <= secondRightBound) {
            return 1;
        }
        if (firstLeftBound <= secondLeftBound && firstRightBound >= secondRightBound) {
            return 1;
        }
        return 0;
    }

    public static int checkOverlap(int[] boundsArray) {
        int firstLeftBound = boundsArray[0];
        int firstRightBound = boundsArray[1];
        int secondLeftBound = boundsArray[2];
        int secondRightBound = boundsArray[3];
        if (firstRightBound < secondLeftBound || firstLeftBound > secondRightBound) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        File input = new File("day4/input.txt");

        try {
            Scanner sc = new Scanner(input);
            int partOneFullOverlap = 0;
            int partTwoOverlap = 0;
            while (sc.hasNextLine()) {
                int[] bounds = parseBounds(sc.nextLine());
                partOneFullOverlap += checkFullOverlap(bounds);
                partTwoOverlap += checkOverlap(bounds);
            }
            System.out.println("Part 1 answer: " + partOneFullOverlap);
            System.out.println("Part 2 answer: " + partTwoOverlap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
