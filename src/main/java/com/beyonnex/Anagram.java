package com.beyonnex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagram {

    private static Map<String,Set<String>> savedAnagrams = new HashMap<>();
    
    /**
     * Implementation of feature #1. Compares two strings and determines if they are anagrams
     * @param subject The subject to compare against
     * @param anagram The possible anagram in question
     * @return True if the strings are anagrams
     */
    public static boolean isAnagram(String subject, String anagram){
        // Normalize the string
        String normalizedSubject = normalizeString(subject);
        String normalizedAnagram = normalizeString(anagram);

        // Check for equal length
        if (normalizedSubject.length() != normalizedAnagram.length()) {
            return false;
        }

        // Convert to char array and sort them
        char[] charsSubject = normalizedSubject.toCharArray();
        char[] charsAnagram = normalizedAnagram.toCharArray();
        Arrays.sort(charsSubject);
        Arrays.sort(charsAnagram);

        // Compare sorted char arrays
        boolean anagrams = Arrays.equals(charsSubject, charsAnagram);

        // Save the anagram for feature #2
        if(anagrams){
            saveAnagram(subject, anagram);
        }

        return anagrams;
    }

    /**
     * Implementation of feature #2. Finds anagrams for a given subject
     * @param subject The subject to find the anagrams for
     * @return An array with the anagrams previously entered for the subject
     */
    public static String[] findAnagrams(String subject){
        if(!savedAnagrams.containsKey(subject)){
            return new String[0];
        }

        Set<String> anagrams = savedAnagrams.get(subject);
        return anagrams.toArray(new String[anagrams.size()]);        
    }

    private static String normalizeString(String s){
        return s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static void saveAnagram(String subject, String anagram){
        if(!savedAnagrams.containsKey(subject)){
            savedAnagrams.put(subject, new HashSet<>());
        }

        savedAnagrams.get(subject).add(anagram);
    }
}
