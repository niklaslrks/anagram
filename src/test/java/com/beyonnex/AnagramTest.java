package com.beyonnex;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramTest {

    @Test
    public void shouldReturnTrueForAnagram() {
        assertTrue(Anagram.isAnagram("silent", "listen"));
    }

    @Test
    public void shouldReturnFalseForNoAnagram() {
        assertFalse(Anagram.isAnagram("silent", "noAnagram"));
    }

    @Test
    public void shouldFindAnagrams() {
        Anagram.isAnagram("fired", "fried");

        assertArrayEquals(new String[] { "fried" }, Anagram.findAnagrams("fired"));
    }

    @Test
    public void shouldNotReturnDuplicates() {
        // 1 and 2 are unique, 3 is a duplicate
        Anagram.isAnagram("fired", "fried");
        Anagram.isAnagram("fired", "fierd");
        Anagram.isAnagram("fired", "fried");

        
        assertArrayEquals(new String[] { "fierd", "fried" }, Anagram.findAnagrams("fired"));
    }

    @Test
    public void shouldNotFindAnagrams() {
        Anagram.isAnagram("someWord", "anotherWord");

        assertArrayEquals(new String[] {}, Anagram.findAnagrams("someWord"));
    }
}
