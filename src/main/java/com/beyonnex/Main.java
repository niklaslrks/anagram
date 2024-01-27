package com.beyonnex;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Check if two strings are anagrams");
            System.out.println("2. Return all anagrams, that you entered for a given subject");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2 or 3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter the possible anagram: ");
                    String anagram = scanner.nextLine();

                    boolean result = Anagram.isAnagram(subject, anagram);
                    System.out.println("Is \"" + anagram + "\" an anagram of \"" + subject + "\"? " + result);
                    break;
                case 2:
                    System.out.print("Enter the subject: ");
                    String subjectToSearch = scanner.nextLine();

                    String[] anagrams = Anagram.findAnagrams(subjectToSearch);
                    System.out.println("Anagrams for \"" + subjectToSearch + "\" are: " + Arrays.toString(anagrams).replace('[', ' ').replace(']', ' '));
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }
}