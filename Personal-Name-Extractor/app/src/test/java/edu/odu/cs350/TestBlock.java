package edu.odu.cs350;

import org.junit.Test;

import static org.junit.Assert.*;
// http://junit.sourceforge.net/javadoc/org/junit/Assert.html

import java.util.*;

public class TestBlock {

    /**
     * Tests that addPERTags() adds opening and closing PER tags on either side of
     * the string
     */
    @Test
    public void testAddPERTags() {
        Block raw = new Block();

        String s1 = "Deric";
        String s2 = "John-Henry's";
        String k1 = "<PER>Deric</PER>";
        String k2 = "<PER>John-Henry's</PER>";

        assertEquals(raw.addPERTags(s1), k1);
        assertEquals(raw.addPERTags(s2), k2);
    }

    /**
     * Tests that removeNERTags() strips the provided string of the opening and
     * closing block tags and returns it
     */
    @Test
    public void testRemoveNERTags() {
        Block raw = new Block();
        String withTag = "<NER>someSortOfString</NER>";
        String key = "someSortOfString";
        String str = raw.removeNERTags(withTag);
        assertEquals(str, key);
    }

    /**
     * Tests printMarkedUpBlock()
     * checks that <NER> </NER> tags and <PER> </PER>
     * tags are being consistent
     */
    @Test
    public void testPrintMarkedUpBlock() {
        FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
        FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
        FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
        FeatureSet.countriesLoc);
        Extractor.setAttributes();
        Extractor.setClassifySvm();
        Stack<String> perStack = new Stack<String>();
        String inBound1 = "<NER>Some so Charlie string</NER>";
        String inBound2 = "<NER>word so many Josh words are words</NER>";

        Block raw = new Block(inBound1, false);
        String markedinBound1 = raw.printMarkedUpBlock();
        String[] Split = markedinBound1.split("\\s+");

        for (int i = 0; i < Split.length; i++) {
            if (Split[i].contains("<PER>")) {
                perStack.push(Split[i]);
            }
            if (Split[i].contains("</PER>")) {
                perStack.pop();
            }
        }
        assertEquals(0, perStack.size());

        Block raw2 = new Block(inBound2, false);
        String markedinBound2 = raw2.printMarkedUpBlock();
        Split = markedinBound2.split("\\s+");

        for (int i = 0; i < Split.length; i++) {
            if (Split[i].contains("<PER>")) {
                perStack.push(Split[i]);
            }
            if (Split[i].contains("</PER>")) {
                perStack.pop();
            }
        }
        assertEquals(0, perStack.size());
    }

    /**
     * The test does not require any input. Tests the functionality of the
     * inBound() function such that
     * 1. inBound() properly accepts integer parameter wordCount to be checked 
     * if the input block is less than or equal to 500 words
     */
    @Test
    public void testInBound() {
        Block raw = new Block();

        int below = -1;
        int bottom = 0;
        int aboveBottom = 1;
        int above = 501;
        int upper = 500;
        int belowUpper = 499;

        assertFalse(raw.inBound(below));
        assertTrue(raw.inBound(bottom));
        assertTrue(raw.inBound(aboveBottom));
        assertFalse(raw.inBound(above));
        assertTrue(raw.inBound(upper));
        assertTrue(raw.inBound(belowUpper));
    }

    /**
     * The test does not require any input. Tests the functionality of the
     * setWordCount() and getWordCount() as a pair of functions such that
     * 1. setWordCount() accurately takes the given integer and stores it in the
     * private variable "wordCount" from the Block.
     * 2. getWordCount() retrieves the private variable "wordCount" without altering
     * it.
     */
    @Test
    public void testSetGetWordCount() {
        Block raw = new Block();

        int empty = 0;
        int someWords = 4;
        int fergalicious = 764; /** Yes, there are that many words in Fergelicious. */
        int[] arr = { empty, someWords, fergalicious };

        for (int i = 0; i < arr.length; i++) {
            raw.setWordCount(arr[i]);
            assertEquals(arr[i], raw.getWordCount());
        }
    }

    /**
     * This test does not require any input. Tests the functionality of the
     * setTagIndex() and getTagIndex as a pair of functions such that
     * 1. setTagIndex() properly takes an integer parameter and stores it in the
     * private variable "tagIndex" from Block.
     * 2. getTagIndex() properly retrived the private variable "tagIndex" without
     * altering it.
     */
    @Test
    public void testSetGetTagIndex() {
        Block raw = new Block();

        int index = 5;
        raw.setTagIndex(index);

        assertEquals(index, raw.getTagIndex());
    }



    /**
     * Tests getOpeningTagIndex()
     * Returns the index of the first character
     * that is not some sort of leading 
     * whitespace.(new line, spaces, tabs, etc...)
     */
    @Test
    public void testGetOpeningTagIndex() {
        Block raw = new Block();
        ArrayList<Token> strArr = new ArrayList<>();

        strArr.add(new Token("\n"));
        strArr.add(new Token("\n"));
        strArr.add(new Token("\n"));
        strArr.add(new Token("know"));
        strArr.add(new Token("days"));
        strArr.add(new Token("I"));

        // Actual Index of Tag
        int keyIndex = 3;

        assertEquals(keyIndex, raw.getOpeningTagIndex(strArr));
    }

    /** 
     * Tests attachNERTags()
     * Takes a given string of text and attaches <NER> tags to
     * the first, and last word.
     */
    @Test
    public void testAttachNERTags(){
        Block raw = new Block();
        String test = "This is a block of text, wrap me in NER tags please.";
        
        test = raw.attachNERTags(test, true);
        test = raw.attachNERTags(test, false);
        
        String key = "<NER>This is a block of text, wrap me in NER tags please.</NER>";

        assertEquals(key, test);
    }

    /**
     * Tests shingleArray()
     * Takes a token of interest, and sets it to the center
     * of an array of tokens surrounded by the 5 tokens before,
     * and the 5 tokens after.
     */
    @Test
    public void testShingleArray(){
        Block raw = new Block();
        int index = 2;
        ArrayList<Token> tempArr = new ArrayList<>();
        ArrayList<Token> testArr = new ArrayList<>();
        String[] keyArr = {null, null, null, "We", "are", "testing", "shingling", "arrays", null, null, null};

        tempArr.add(new Token("We"));
        tempArr.add(new Token("are"));
        tempArr.add(new Token("testing"));
        tempArr.add(new Token("shingling"));
        tempArr.add(new Token("arrays"));

        testArr = raw.shingleArray(tempArr, index);

        assertEquals(keyArr[0], testArr.get(0) == null ? testArr.get(0) : testArr.get(0).getWord());
        assertEquals(keyArr[1], testArr.get(1) == null ? testArr.get(1) : testArr.get(1).getWord());
        assertEquals(keyArr[2], testArr.get(2) == null ? testArr.get(2) : testArr.get(2).getWord());
        assertEquals(keyArr[3], testArr.get(3) == null ? testArr.get(3) : testArr.get(3).getWord());
        assertEquals(keyArr[4], testArr.get(4) == null ? testArr.get(4) : testArr.get(4).getWord());
        assertEquals(keyArr[5], testArr.get(5) == null ? testArr.get(5) : testArr.get(5).getWord());
        assertEquals(keyArr[6], testArr.get(6) == null ? testArr.get(6) : testArr.get(6).getWord());
        assertEquals(keyArr[7], testArr.get(7) == null ? testArr.get(7) : testArr.get(7).getWord());
        assertEquals(keyArr[8], testArr.get(8) == null ? testArr.get(8) : testArr.get(8).getWord());
        assertEquals(keyArr[9], testArr.get(9) == null ? testArr.get(9) : testArr.get(9).getWord());
        assertEquals(keyArr[10], testArr.get(10) == null ? testArr.get(10) : testArr.get(10).getWord());

    }
    

     /**
     * Tests findWordCount()
     * Counts how many words are within a string array.
     * 
     * TempArr is passed in with various words and lexical features,
     * and should return with the count of words not including white space,
     * or lexical features.
     *
     */
    @Test
    public void testFindWordCount(){
        Block raw = new Block();
        String[] tempArr = {"\n", "This", " ", "is", " ", "a", " ", "block", "!"};

        int key = 4;

        assertEquals(key, raw.findWordCount(tempArr));
    }

    
}
