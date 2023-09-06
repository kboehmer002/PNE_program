package edu.odu.cs350;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestToken {

    /**
     * Integration Test
     * 
     * Test checks that the string of a word is stored as a token and the featureset
     * is initialized to false when the token constructor is supplied with a string
     */
    @Test
    public void testToken() {
        boolean[] feat = new boolean[20];
        for (int i = 0; i < 20; i++) {
            feat[i] = false;
        }

        String word = "IDon'tCareHowBigTheRoomIsICastFireball!";

        Token tok = new Token(word);
        assertEquals(tok.getWord(), word);
        assertArrayEquals(tok.getFeatureSet(), feat);
    }

    /**
     * Tests that setFeatures() successfully calls the FeatureSet constructor and
     * featureSet is assigned boolean values
     */
    @Test
    public void testSetFeatures() {
        Token tok = new Token();
        tok.setFeatures(false);
        assertTrue(tok.getFeatureSet() != null);
    }

    /**
     * Tests getter and setter for featureSet can alter the featureSet array
     */
    @Test
    public void testGetSetFeatureSet() {
        Token tok = new Token();

        boolean[] newSet1 = new boolean[20];
        boolean[] newSet2 = new boolean[20];
        for (int i = 0; i < 20; i++) {
            newSet1[i] = true;
            newSet2[i] = false;
        }

        tok.setFeatureSet(newSet1);
        assertArrayEquals(tok.getFeatureSet(), newSet1);

        tok.setFeatureSet(newSet2);
        assertArrayEquals(tok.getFeatureSet(), newSet2);
    }

    /**
     * Tests that getter and setter for theWord can assign a string to theWord and
     * return it without altering the string
     */
    @Test
    public void testGetSetWord() {
        Token tok = new Token();
        String word = "RollForInitiative";
        tok.setWord(word);

        assertEquals(tok.getWord(), word);
    }
}