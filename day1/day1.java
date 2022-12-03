package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class day1 {

    public static void replaceMin(int[] arr, int calorie) {
        if (findMin(arr, calorie) != calorie) {
            int curr = 0;
            for (int i = 0; i < 3; i++) {
                if (arr[curr] > arr[i]) {
                    curr = i;
                }
            }
            arr[curr] = calorie;
        }
    }

    public static int findMin(int[] arr, int calorie) {
        int min = calorie;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        File input = new File("day1/input.txt");

        try {
            Scanner sc = new Scanner(input);
            HashMap hashMap = new HashMap();
            int count = 0;
            int calories = 0;
            int max = 0;
            int[] maxArray = {0, 0, 0};
            while (sc.hasNextLine()) {
                String curr = sc.nextLine();
                if (curr.isBlank()) {
                    hashMap.put(count, calories);
                    count++;
                    max = Math.max(max, calories);
                    replaceMin(maxArray, calories);
                    calories = 0;
                } else {
                    Integer calorie = Integer.parseInt(curr);
                    calories += calorie;
                }
            }
            int total = 0;
            for (int i = 0; i < 3; i++) {
                total += maxArray[i];
            }

            System.out.println("Part 1 answer: " + max);
            System.out.println("Part 2 answer: " + total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
