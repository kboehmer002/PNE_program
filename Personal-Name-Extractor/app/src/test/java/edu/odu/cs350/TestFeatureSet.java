package edu.odu.cs350;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFeatureSet {

    boolean placeholder = true;

    /**
     * 
     */
    @Test
    public void testFeatureSet() {
        assertTrue(placeholder);
    }

    /**
     * Tests that each map produces the same hashmap when compared to the key
     * because they are all utilizing the same test file, therefore confirming they
     * are all generating the hashmap correctly
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testSetAllMaps() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setAllMaps(file, file, file, file, file, file, file, file, file, file, file, file);

        assertEquals(keyMap, FeatureSet.getFirstNameMap());
        assertEquals(keyMap, FeatureSet.getLastNameMap());
        assertEquals(keyMap, FeatureSet.getCitiesMap());
        assertEquals(keyMap, FeatureSet.getDictionaryMap());
        assertEquals(keyMap, FeatureSet.getPlacesMap());
        assertEquals(keyMap, FeatureSet.getDticFirstMap());
        assertEquals(keyMap, FeatureSet.getDticLastMap());
        assertEquals(keyMap, FeatureSet.getHonorificMap());
        assertEquals(keyMap, FeatureSet.getPrefixMap());
        assertEquals(keyMap, FeatureSet.getSuffixMap());
        assertEquals(keyMap, FeatureSet.getCountriesMap());
    }

    /**
     * Tests that testGetSetFirstNameMap() creates the correct hashmap from the
     * document
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetFirstNameMap() throws FileNotFoundException {

        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setFirstNameMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getFirstNameMap(), keyMap);
    }

    /**
     * Tests that testGetSetLastNameMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetLastNameMap() throws FileNotFoundException {

        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setLastNameMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getLastNameMap(), keyMap);
    }

    /**
     * Tests that testGetSetCitiesMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetCitiesMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setCitiesMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getCitiesMap(), keyMap);
    }

    /**
     * Tests that testGetSetDictionaryMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetDictionaryMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setDictionaryMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getDictionaryMap(), keyMap);
    }

    /**
     * Tests that testGetSetPlacesMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetPlacesMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setPlacesMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getPlacesMap(), keyMap);
    }

    /**
     * Tests that testGetSetDticFirstMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetDticFirstMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setDticFirstMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getDticFirstMap(), keyMap);
    }

    /**
     * Tests that testGetSetDticLastMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetDticLastMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setDticLastMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getDticLastMap(), keyMap);
    }

    /**
     * Tests that testGetSetHonorificMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetHonorificMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setHonorificMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getHonorificMap(), keyMap);
    }

    /**
     * Tests that testGetSetPrefixMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetPrefixMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setPrefixMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getPrefixMap(), keyMap);
    }

    /**
     * Tests that testGetSetSuffixMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetSuffixMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setSuffixMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getSuffixMap(), keyMap);
    }

    /**
     * Tests that testGetSetStopListMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetStopListMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setStopListMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getStopListMap(), keyMap);
    }

    /**
     * Tests that testGetSetCountriesMap() creates the correct hashmap from the
     * document and is able to retrieve it
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testGetSetCountriesMap() throws FileNotFoundException {
        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        FeatureSet.setCountriesMap("src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt");
        assertEquals(FeatureSet.getCountriesMap(), keyMap);
    }

    /**
     * Tests that getFeatures() is able to return the proper array of features in
     * regards to each word in the following order:
     * {dict, place, city, country, dticFirst, dticLast, commonFirst, commonLast,
     * honorific, prefix, suffix, kill, num, punct, caplett, caps, uppercase, \n,
     * misc, PER}
     */
    @Test
    public void testGetFeatures() {
        FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
                FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
                FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
                FeatureSet.countriesLoc);
        FeatureSet feat = new FeatureSet();
        FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
                FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
                FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
                FeatureSet.countriesLoc);

        boolean t = true;
        boolean f = false;
        boolean[] k1 = { t, f, f, f, t, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f };
        boolean[] k2 = { t, t, f, f, t, t, f, t, f, f, f, f, f, f, f, f, f, f, f, f };
        boolean[] k3 = { t, t, f, f, t, t, t, t, f, f, f, f, f, f, f, f, t, f, f, f };
        boolean[] k4 = { t, t, f, f, f, t, f, t, f, f, f, f, f, f, f, f, t, f, f, f };
        boolean[] k5 = { f, t, f, f, t, f, t, f, f, f, f, f, f, f, f, f, f, f, f, f };
        boolean[] k6 = { f, f, f, f, f, t, f, f, f, f, f, f, f, f, f, f, f, f, f, f };
        boolean[] k7 = { t, t, f, f, t, t, t, t, f, f, f, f, f, f, f, f, t, f, f, f };
        boolean[] k8 = { t, t, f, f, t, t, f, t, f, f, f, f, f, f, f, f, t, f, f, f };
        boolean[] k9 = { f, f, f, f, f, f, f, f, t, f, f, f, f, f, f, f, t, f, f, f };
        boolean[] k10 = { f, f, f, f, t, t, f, t, f, t, f, f, f, f, f, f, f, f, f, f };
        boolean[] k11 = { t, f, f, f, t, t, f, f, f, f, t, f, f, f, f, f, f, f, f, f };
        boolean[] k12 = { t, f, f, f, f, t, f, t, f, f, f, t, f, f, f, f, f, f, f, f };
        boolean[] k13 = { f, f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f, f, f };
        boolean[] k14 = { f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f, f };
        boolean[] k15 = { f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, f };

        String s1 = "AB";
        String s2 = "park";
        String s3 = "Orlando";
        String s4 = "England";
        String s5 = "alla";
        String s6 = "aalto";
        String s7 = "John";
        String s8 = "Smith";
        String s9 = "Dr.";
        String s10 = "el";
        String s11 = "jr";
        String s12 = "able";
        String s13 = "123";
        String s14 = ";";
        String s15 = "\n";

        assertArrayEquals(feat.getFeatures(s1, false), k1);
        assertArrayEquals(feat.getFeatures(s2, false), k2);
        assertArrayEquals(feat.getFeatures(s3, false), k3);
        assertArrayEquals(feat.getFeatures(s4, false), k4);
        assertArrayEquals(feat.getFeatures(s5, false), k5);
        assertArrayEquals(feat.getFeatures(s6, false), k6);
        assertArrayEquals(feat.getFeatures(s7, false), k7);
        assertArrayEquals(feat.getFeatures(s8, false), k8);
        assertArrayEquals(feat.getFeatures(s9, false), k9);
        assertArrayEquals(feat.getFeatures(s10, false), k10);
        assertArrayEquals(feat.getFeatures(s11, false), k11);
        assertArrayEquals(feat.getFeatures(s12, false), k12);
        assertArrayEquals(feat.getFeatures(s13, false), k13);
        assertArrayEquals(feat.getFeatures(s14, false), k14);
        assertArrayEquals(feat.getFeatures(s15, false), k15);
    }

    /**
     * Test checks that testIsPersonalName() only identifies personal names as words
     * wrapped in <PER> </PER> tags
     */
    @Test
    public void testIsPersonalName() {
        FeatureSet feat = new FeatureSet();
        String name = "<PER>John</PER>";
        String notName = "John";
        assertEquals(feat.isPersonalName(name), true);
        assertEquals(feat.isPersonalName(notName), false);
    }

    /**
     * Test checks that findLexical correctly identifies the lexical features
     */
    @Test
    public void testFindLexical() {
        FeatureSet temp = new FeatureSet();
        FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
                FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
                FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
                FeatureSet.countriesLoc);
        String num1 = "19201";
        String punct1 = ".?";
        assertEquals(true, temp.findLexical(num1)[0]);
        assertEquals(true, temp.findLexical(punct1)[1]);
        assertEquals(true, temp.findLexical("A")[2]);
        assertEquals(true, temp.findLexical("PNE")[3]);
        assertEquals(true, temp.findLexical("John")[4]);
        assertEquals(true, temp.findLexical("\n")[5]);
        assertEquals(true, temp.findLexical("")[6]);
    }

    /**
     * Tests isNumber() only identifies and returns true for numerical values
     */
    @Test
    public void testIsNumber() {
        FeatureSet feat = new FeatureSet();
        String num = "368";
        String notNum = "three-hundred-and-sixty-eight";
        assertEquals(feat.isNumber(num), true);
        assertEquals(feat.isNumber(notNum), false);
    }

    /**
     * Tests isPunct() only identifies and returns true for symbols/punctuation
     */
    @Test
    public void testIsPunct() {
        FeatureSet feat = new FeatureSet();
        String punct1 = ".";
        String punct2 = "'";
        String punct3 = ";";
        String punct4 = ":";
        String punct5 = "?";
        String punct6 = "!";
        String punct7 = "/";
        String word = "NO";

        assertEquals(feat.isPunct(punct1), true);
        assertEquals(feat.isPunct(punct2), true);
        assertEquals(feat.isPunct(punct3), true);
        assertEquals(feat.isPunct(punct4), true);
        assertEquals(feat.isPunct(punct5), true);
        assertEquals(feat.isPunct(punct6), true);
        assertEquals(feat.isPunct(punct7), true);
        assertEquals(feat.isPunct(word), false);
    }

    /**
     * Tests that isCapitalized() checks that the function correctly identifies the
     * type of capitalization present in the word for a capitalized letter,
     * capitalized word, all caps, and no capitalization
     */
    @Test
    public void testIsCapitalized() {
        FeatureSet feat = new FeatureSet();

        String lower = "supercalifragilisticexpialidocious";
        String capLetter = "I";
        String upper = "Supercalifragilisticexpialidocious";
        String allCaps = "SUPERCALIFRAGILISTICEXPIALIDOCIOUS";

        boolean[] lowArr = { false, false, false };
        boolean[] lettArr = { true, false, false };
        boolean[] upArr = { false, false, true };
        boolean[] capsArr = { false, true, false };

        assertArrayEquals(feat.isCapitalized(lower), lowArr);
        assertArrayEquals(feat.isCapitalized(capLetter), lettArr);
        assertArrayEquals(feat.isCapitalized(upper), upArr);
        assertArrayEquals(feat.isCapitalized(allCaps), capsArr);
    }

    /**
     * Tests to see if isNewLine() can correctly identify if the incoming string is
     * a new
     * word as opposed to any other whitespace character or general string
     */
    @Test
    public void testIsNewLine() {
        FeatureSet feat = new FeatureSet();
        String newLine = "\n";
        String returnLine = "\r";
        String tab = "\t";
        String word = "word";
        String num = "42";

        assertEquals(feat.isNewline(newLine), true);
        assertEquals(feat.isNewline(returnLine), false);
        assertEquals(feat.isNewline(tab), false);
        assertEquals(feat.isNewline(word), false);
        assertEquals(feat.isNewline(num), false);
    }

    /**
     * Tests if hashFromFile() can correctly create and return a hashmap from any
     * given file location
     */
    @Test
    public void testHashFromFile() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        Map<String, String> testMap = FeatureSet.hashFromFile(file);

        Map<String, String> keyMap = new HashMap<>();
        String[] temp = { "This", "is", "a Single", "Test", "file", "for our", "map" };
        for (int i = 0; i < temp.length; i++) {
            keyMap.put(temp[i].toLowerCase(), temp[i].toLowerCase());
        }

        assertEquals(testMap, keyMap);
    }

    /**
     * Tests if isInFirstNameMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInFirstNameMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setFirstNameMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInFirstNameMap(inMap[0]), true);
        assertEquals(FeatureSet.isInFirstNameMap(inMap[1]), true);
        assertEquals(FeatureSet.isInFirstNameMap(inMap[2]), true);
        assertEquals(FeatureSet.isInFirstNameMap(inMap[3]), true);

        assertEquals(FeatureSet.isInFirstNameMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInFirstNameMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInFirstNameMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInFirstNameMap(notInMap[3]), false);
    }

    /**
     * Tests if isInLastNameMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInLastNameMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setLastNameMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInLastNameMap(inMap[0]), true);
        assertEquals(FeatureSet.isInLastNameMap(inMap[1]), true);
        assertEquals(FeatureSet.isInLastNameMap(inMap[2]), true);
        assertEquals(FeatureSet.isInLastNameMap(inMap[3]), true);

        assertEquals(FeatureSet.isInLastNameMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInLastNameMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInLastNameMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInLastNameMap(notInMap[3]), false);

    }

    /**
     * Tests if isInCitiesMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInCitiesMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setCitiesMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInCitiesMap(inMap[0]), true);
        assertEquals(FeatureSet.isInCitiesMap(inMap[1]), true);
        assertEquals(FeatureSet.isInCitiesMap(inMap[2]), true);
        assertEquals(FeatureSet.isInCitiesMap(inMap[3]), true);

        assertEquals(FeatureSet.isInCitiesMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInCitiesMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInCitiesMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInCitiesMap(notInMap[3]), false);
    }

    /**
     * Tests if isInDictionaryMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInDictionaryMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setDictionaryMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInDictionaryMap(inMap[0]), true);
        assertEquals(FeatureSet.isInDictionaryMap(inMap[1]), true);
        assertEquals(FeatureSet.isInDictionaryMap(inMap[2]), true);
        assertEquals(FeatureSet.isInDictionaryMap(inMap[3]), true);

        assertEquals(FeatureSet.isInDictionaryMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInDictionaryMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInDictionaryMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInDictionaryMap(notInMap[3]), false);
    }

    /**
     * Tests if isInPlacesMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInPlacesMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setPlacesMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInPlacesMap(inMap[0]), true);
        assertEquals(FeatureSet.isInPlacesMap(inMap[1]), true);
        assertEquals(FeatureSet.isInPlacesMap(inMap[2]), true);
        assertEquals(FeatureSet.isInPlacesMap(inMap[3]), true);

        assertEquals(FeatureSet.isInPlacesMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInPlacesMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInPlacesMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInPlacesMap(notInMap[3]), false);
    }

    /**
     * Tests if isInDitcFirstMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInDticFirstMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setDticFirstMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInDticFirstMap(inMap[0]), true);
        assertEquals(FeatureSet.isInDticFirstMap(inMap[1]), true);
        assertEquals(FeatureSet.isInDticFirstMap(inMap[2]), true);
        assertEquals(FeatureSet.isInDticFirstMap(inMap[3]), true);

        assertEquals(FeatureSet.isInDticFirstMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInDticFirstMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInDticFirstMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInDticFirstMap(notInMap[3]), false);
    }

    /**
     * Tests if isInDitcLastMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInDticLastMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setDticLastMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInDticLastMap(inMap[0]), true);
        assertEquals(FeatureSet.isInDticLastMap(inMap[1]), true);
        assertEquals(FeatureSet.isInDticLastMap(inMap[2]), true);
        assertEquals(FeatureSet.isInDticLastMap(inMap[3]), true);

        assertEquals(FeatureSet.isInDticLastMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInDticLastMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInDticLastMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInDticLastMap(notInMap[3]), false);
    }

    /**
     * Tests if isInHonorificMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInHonorificMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setHonorificMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInHonorificMap(inMap[0]), true);
        assertEquals(FeatureSet.isInHonorificMap(inMap[1]), true);
        assertEquals(FeatureSet.isInHonorificMap(inMap[2]), true);
        assertEquals(FeatureSet.isInHonorificMap(inMap[3]), true);

        assertEquals(FeatureSet.isInHonorificMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInHonorificMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInHonorificMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInHonorificMap(notInMap[3]), false);
    }

    /**
     * Tests if isInPrefixMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInPrefixMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setPrefixMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInPrefixMap(inMap[0]), true);
        assertEquals(FeatureSet.isInPrefixMap(inMap[1]), true);
        assertEquals(FeatureSet.isInPrefixMap(inMap[2]), true);
        assertEquals(FeatureSet.isInPrefixMap(inMap[3]), true);

        assertEquals(FeatureSet.isInPrefixMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInPrefixMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInPrefixMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInPrefixMap(notInMap[3]), false);
    }

    /**
     * Tests if isInSuffixeMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInSuffixMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setSuffixMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInSuffixMap(inMap[0]), true);
        assertEquals(FeatureSet.isInSuffixMap(inMap[1]), true);
        assertEquals(FeatureSet.isInSuffixMap(inMap[2]), true);
        assertEquals(FeatureSet.isInSuffixMap(inMap[3]), true);

        assertEquals(FeatureSet.isInSuffixMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInSuffixMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInSuffixMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInSuffixMap(notInMap[3]), false);
    }

    /**
     * Tests if isInStopListMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInStopListMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setStopListMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInStopListMap(inMap[0]), true);
        assertEquals(FeatureSet.isInStopListMap(inMap[1]), true);
        assertEquals(FeatureSet.isInStopListMap(inMap[2]), true);
        assertEquals(FeatureSet.isInStopListMap(inMap[3]), true);

        assertEquals(FeatureSet.isInStopListMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInStopListMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInStopListMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInStopListMap(notInMap[3]), false);
    }

    /**
     * Tests if isInCountriesMap() can correctly identify if the given string
     * matches an entry in the hashmap and returns the corresponding bool
     */
    @Test
    public void testIsInCountriesMap() {
        String file = "src/test/java/edu/odu/cs350/TestFiles/mapSampleFile.txt";
        FeatureSet.setCountriesMap(file);

        String[] inMap = { "This", "Test", "file", "map" };
        String[] notInMap = { "123", "something", "dog", "world" };

        assertEquals(FeatureSet.isInCountriesMap(inMap[0]), true);
        assertEquals(FeatureSet.isInCountriesMap(inMap[1]), true);
        assertEquals(FeatureSet.isInCountriesMap(inMap[2]), true);
        assertEquals(FeatureSet.isInCountriesMap(inMap[3]), true);

        assertEquals(FeatureSet.isInCountriesMap(notInMap[0]), false);
        assertEquals(FeatureSet.isInCountriesMap(notInMap[1]), false);
        assertEquals(FeatureSet.isInCountriesMap(notInMap[2]), false);
        assertEquals(FeatureSet.isInCountriesMap(notInMap[3]), false);
    }

    /**
     * Tests that personal name tags can be properly removed from any string without
     * altering the word in any way with stripPERTags().
     */
    @Test
    public void testStripPERTags() {
        FeatureSet feat = new FeatureSet();

        String s1 = "<PER>Word</PER>";
        String s2 = "<PER>Doesn't matter what is in here at all</PER>";
        String s3 = "";
        String s4 = "Hello";

        String k1 = "Word";
        String k2 = "Doesn't matter what is in here at all";
        String k3 = "";
        String k4 = "Hello";

        assertEquals(feat.stripPERTags(s1), k1);
        assertEquals(feat.stripPERTags(s2), k2);
        assertEquals(feat.stripPERTags(s3), k3);
        assertEquals(feat.stripPERTags(s4), k4);
    }
}
