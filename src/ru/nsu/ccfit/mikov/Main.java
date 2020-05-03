package ru.nsu.ccfit.mikov;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string length");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter number please");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char code = (char) (getRandomLetterOrNumber());
            stringBuilder.append(code);
        }
        System.out.println(stringBuilder.toString());

        System.out.println("Enter first character");
        String first = in.nextLine();
        int firstCount = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            int index = (int) stringBuilder.charAt(i);
            if (index >= 65 && index <= 90) {
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, first);
                firstCount++;
            }
        }

        System.out.println("Enter second character");
        String second = in.nextLine();
        int secondCount = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            int index = (int) stringBuilder.charAt(i);
            if (index >= 48 && index <= 57) {
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, second);
                secondCount++;
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println("Number of repetitions of the first character: " + firstCount);
        System.out.println("Number of repetitions of the second character: " + secondCount);

    }

    public static int getRandomLetterOrNumber() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 48; i <= 57; i++) {
            list.add(i);
        }
        for (int i = 65; i <= 90; i++) {
            list.add(i);
        }
        Random rand = new Random();
        return (list.get(rand.nextInt(list.size())));
    }
}
