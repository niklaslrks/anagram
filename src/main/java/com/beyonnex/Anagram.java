package com.beyonnex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    private static Map<String,List<String>> savedAnagrams = new HashMap<>();
    
    public static boolean isAnagram(String subject, String anagram){
        // Remove any non-alphabetic characters and convert to lower case
        String normalizedSubject = normalizeString(subject);
        String normalizedAnagram = normalizeString(anagram);

        // Check if lengths are equal
        if (normalizedSubject.length() != normalizedAnagram.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charsSubject = normalizedSubject.toCharArray();
        char[] charsAnagram = normalizedAnagram.toCharArray();

        // Sort the char arrays
        Arrays.sort(charsSubject);
        Arrays.sort(charsAnagram);

        // Compare sorted char arrays
        boolean anagrams = Arrays.equals(charsSubject, charsAnagram);

        if(anagrams){
            saveAnagram(subject, anagram);
        }

        return anagrams;
    }

    public static String[] findAnagrams(String subject){
        if(!savedAnagrams.containsKey(subject)){
            return new String[0];
        }

        List<String> anagrams = savedAnagrams.get(subject);
        return anagrams.toArray(new String[anagrams.size()]);        
    }

    private static String normalizeString(String s){
        return s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static void saveAnagram(String subject, String anagram){
        if(!savedAnagrams.containsKey(subject)){
            savedAnagrams.put(subject, new ArrayList<>());
        }

        savedAnagrams.get(subject).add(anagram);
    }
}
