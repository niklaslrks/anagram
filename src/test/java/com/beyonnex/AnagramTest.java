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
    public void shouldNotFindAnagrams() {
        Anagram.isAnagram("someWord", "anotherWord");

        assertArrayEquals(new String[] {}, Anagram.findAnagrams("someWord"));
    }
}
