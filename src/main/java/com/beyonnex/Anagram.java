package com.beyonnex;

import java.util.Arrays;

public class Anagram {
    
    public static boolean isAnagram(String subject, String anagram){
        // Remove any non-alphabetic characters and convert to lower case
        String normalizedString1 = subject.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String normalizedString2 = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Check if lengths are equal
        if (normalizedString1.length() != normalizedString2.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charArray1 = normalizedString1.toCharArray();
        char[] charArray2 = normalizedString2.toCharArray();

        // Sort the char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
}
