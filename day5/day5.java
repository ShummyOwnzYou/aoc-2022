package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day5 {

    public static List<Deque<Character>> stackList1 = new ArrayList<>();
    public static List<Deque<Character>> stackList2 = new ArrayList<>();

    public static void init() {
        for (int i = 0; i < 9; i++) {
            stackList1.add(new ArrayDeque<>());
            stackList2.add(new ArrayDeque<>());
        }
    }

    public static void populate(String string) {
        for (int j = 0; j < 9; j++) {
            char curr = string.charAt(j * 4 + 1);
            if (curr == ' ') {
                continue;
            }
            stackList1.get(j).add(curr);
            stackList2.get(j).add(curr);
        }
    }

    public static void transfer1(int[] intArr) {
        for (int i = 0; i < intArr[0]; i++) {
            char curr = stackList1.get(intArr[1] - 1).pop();
            stackList1.get(intArr[2] - 1).push(curr);
        }
    }

    public static void transfer2(int[] intArr) {
        Deque<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < intArr[0]; i++) {
            char curr = stackList2.get(intArr[1] - 1).pop();
            temp.push(curr);
        }
        for (int i = 0; i < intArr[0]; i++) {
            char curr = temp.pop();
            stackList2.get(intArr[2] - 1).push(curr);
        }
    }

    public static void main(String[] args) {
        File input = new File("day5/input.txt");
        init();

        try {
            Scanner sc = new Scanner(input);

            for (int i = 0; i < 8; i++) {
                String string = sc.nextLine();
                populate(string);
            }
            sc.nextLine();
            while (sc.hasNextLine()) {
                int[] intArr = new int[3];
                for (int i = 0; i < 3; i++) {
                    sc.next();
                    intArr[i] = sc.nextInt();
                }
                transfer1(intArr);
                transfer2(intArr);
            }
            System.out.print("Part 1 answer: ");
            for (int i = 0; i < 9; i++) {
                System.out.print(stackList1.get(i).peek());
            }
            System.out.print("\nPart 2 answer: ");
            for (int i = 0; i < 9; i++) {
                System.out.print(stackList2.get(i).peek());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
