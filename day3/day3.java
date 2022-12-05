package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3 {

    public static char findDuplicate(String rucksack) {
        int len = rucksack.length();
        String first = rucksack.substring(0, len/2);
        String second = rucksack.substring(len/2, len);
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < len/2; i++) {
            char firstCurr = first.charAt(i);
            if (list.contains(firstCurr)) {
                continue;
            }
            for (int j = 0; j < len/2; j++) {
                char secondCurr = second.charAt(j);
                if (firstCurr == secondCurr) {
                    return firstCurr;
                }
            }
            list.add(firstCurr);
        }
        throw new IllegalArgumentException("no duplicate char found");
    }

    public static char findBadge(String rucksack1, String rucksack2, String rucksack3) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < rucksack1.length(); i++) {
            char firstCurr = rucksack1.charAt(i);
            if (list.contains(firstCurr)) {
                continue;
            }
            for (int j = 0; j < rucksack2.length(); j++) {
                char secondCurr = rucksack2.charAt(j);
                if (firstCurr == secondCurr) {
                    for (int k = 0; k < rucksack3.length(); k++) {
                        char thirdCurr = rucksack3.charAt(k);
                        if (firstCurr == thirdCurr) {
                            return firstCurr;
                        }
                    }
                }
            }
            list.add(firstCurr);
        }

        throw new IllegalArgumentException("no badge found");
    }

    public static int charToPriority(char c) {
        int priority = c;
        if (priority < 95) {
            priority -= 38;
        } else {
            priority -= 96;
        }
        return priority;
    }

    public static void main(String[] args) {
        File input = new File("day3/input.txt");

        try {
            Scanner sc = new Scanner(input);
            int partOnePriority = 0;
            int partTwoPriority = 0;
            while (sc.hasNextLine()) {
                String rucksack1 = sc.nextLine();
                String rucksack2 = sc.nextLine();
                String rucksack3 = sc.nextLine();
                partOnePriority += charToPriority(findDuplicate(rucksack1));
                partOnePriority += charToPriority(findDuplicate(rucksack2));
                partOnePriority += charToPriority(findDuplicate(rucksack3));
                partTwoPriority += charToPriority(findBadge(rucksack1, rucksack2, rucksack3));
            }
            System.out.println("Part 1 answer: " + partOnePriority);
            System.out.println("Part 2 answer: " + partTwoPriority);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
