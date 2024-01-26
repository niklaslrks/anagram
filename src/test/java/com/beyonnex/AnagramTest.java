package com.beyonnex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramTest {
    
    @Test
    public void shouldReturnTrueForAnagram(){
        assertTrue(Anagram.isAnagram("silent", "listen"));
    }

    @Test
    public void shouldReturnFalseForNoAnagram(){
        assertFalse(Anagram.isAnagram("silent", "noAnagram"));
    }
}
