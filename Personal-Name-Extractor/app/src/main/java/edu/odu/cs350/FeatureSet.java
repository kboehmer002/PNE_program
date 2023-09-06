package edu.odu.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeatureSet {

    static final String firstNameLoc = "src/main/DictionaryFiles/Dictionary.commonFirstNames.txt";
    static final String lastNameLoc = "src/main/DictionaryFiles/Dictionary.commonLastNames.txt";
    static final String citiesLoc = "src/main/DictionaryFiles/cities.txt";
    static final String dictionaryLoc = "src/main/DictionaryFiles/dictionary.txt";
    static final String placesLoc = "src/main/DictionaryFiles/places.txt";
    static final String dticFirstLoc = "src/main/DictionaryFiles/DTICfirst.txt";
    static final String dticLastLoc = "src/main/DictionaryFiles/DTIClast.txt";
    static final String honorificLoc = "src/main/DictionaryFiles/honorifics.txt";
    static final String prefixLoc = "src/main/DictionaryFiles/prefix.txt";
    static final String suffixLoc = "src/main/DictionaryFiles/suffix.txt";
    static final String stopLoc = "src/main/DictionaryFiles/stoplist.txt";
    static final String countriesLoc = "src/main/DictionaryFiles/countries.txt";

    private static Map<String, String> firstNameMap;
    private static Map<String, String> lastNameMap;
    private static Map<String, String> citiesMap;
    private static Map<String, String> dictionaryMap;
    private static Map<String, String> placesMap;
    private static Map<String, String> dticFirstMap;
    private static Map<String, String> dticLastMap;
    private static Map<String, String> honorificMap;
    private static Map<String, String> prefixMap;
    private static Map<String, String> suffixMap;
    private static Map<String, String> stopListMap;
    private static Map<String, String> countriesMap;

    // Default Constructor
    public FeatureSet() {

    }

    // Hashmap Setters
    /**
     * Setter for all hashmap generation
     * 
     * @param fnl    location of first names file
     * @param lnl    location of last names file
     * @param cl     location of cities file
     * @param dl     location of dictionary file
     * @param pl     location of places file
     * @param dticfl location of DTIC fist name file
     * @param dticll location of DTIC last name file
     * @param hl     location of honorific file
     * @param prl    location of prefix file
     * @param sl     location of suffix file
     * @param stl    location of stop list file
     * @param col    location of countries file
     */
    public static void setAllMaps(String fnl, String lnl, String cl, String dl, String pl, String dticfl, String dticll,
            String hl, String prl, String sl, String stl, String col) {

        setFirstNameMap(fnl);
        setLastNameMap(lnl);
        setCitiesMap(cl);
        setDictionaryMap(dl);
        setPlacesMap(pl);
        setDticFirstMap(dticfl);
        setDticLastMap(dticll);
        setHonorificMap(hl);
        setPrefixMap(prl);
        setSuffixMap(sl);
        setStopListMap(stl);
        setCountriesMap(col);
    }

    /**
     * Generates first name hashmap
     * 
     * @param file location of first name dictionary
     */
    public static void setFirstNameMap(String file) {
        firstNameMap = hashFromFile(file);
    }

    /**
     * Generates last name hashmap
     * 
     * @param file location of last name dictionary
     */
    public static void setLastNameMap(String file) {
        lastNameMap = hashFromFile(file);
    }

    /**
     * Generates cities hashmap
     * 
     * @param file location of cities database
     */
    public static void setCitiesMap(String file) {
        citiesMap = hashFromFile(file);
    }

    /**
     * Generates english dictionary hashmap
     * 
     * @param file location of english dictionary
     */
    public static void setDictionaryMap(String file) {
        dictionaryMap = hashFromFile(file);
    }

    /**
     * Generates places hashmap
     * 
     * @param file location of places database
     */
    public static void setPlacesMap(String file) {
        placesMap = hashFromFile(file);
    }

    /**
     * Generates DTIC first name hashmap
     * 
     * @param file location of DITC first name dictionary
     */
    public static void setDticFirstMap(String file) {
        dticFirstMap = hashFromFile(file);
    }

    /**
     * Generates DTIC last name hashmap
     * 
     * @param file location of DTIC last name dictionary
     */
    public static void setDticLastMap(String file) {
        dticLastMap = hashFromFile(file);
    }

    /**
     * Generates honorific hashmap
     * 
     * @param file location of honorific database
     */
    public static void setHonorificMap(String file) {
        honorificMap = hashFromFile(file);
    }

    /**
     * Generates prefix hashmap
     * 
     * @param file location of prefix database
     */
    public static void setPrefixMap(String file) {
        prefixMap = hashFromFile(file);
    }

    /**
     * Generates suffix hashmap
     * 
     * @param file location of suffix database
     */
    public static void setSuffixMap(String file) {
        suffixMap = hashFromFile(file);
    }

    /**
     * Generates stop list hashmap
     * 
     * @param file location of stop list database
     */
    public static void setStopListMap(String file) {
        stopListMap = hashFromFile(file);
    }

    /**
     * Generates countries hashmap
     * 
     * @param file location of countires database
     */
    public static void setCountriesMap(String file) {
        countriesMap = hashFromFile(file);
    }

    // Hashmap Getters

    /**
     * First name hashmap getter
     * 
     * @return first name hashmap
     */
    public static Map<String, String> getFirstNameMap() {
        return FeatureSet.firstNameMap;
    }

    /**
     * Last name hashmap getter
     * 
     * @return last name hashmap
     */
    public static Map<String, String> getLastNameMap() {
        return FeatureSet.lastNameMap;
    }

    /**
     * Cities hashmap getter
     * 
     * @return cities hashmap
     */
    public static Map<String, String> getCitiesMap() {
        return FeatureSet.citiesMap;
    }

    /**
     * Dictionary hashmap getter
     * 
     * @return dictionary hashmap
     */
    public static Map<String, String> getDictionaryMap() {
        return FeatureSet.dictionaryMap;
    }

    /**
     * Places hashmap getter
     * 
     * @return places hashmap
     */
    public static Map<String, String> getPlacesMap() {
        return FeatureSet.placesMap;
    }

    /**
     * DTIC first name hashmap getter
     * 
     * @return DTIC first name hashmap
     */
    public static Map<String, String> getDticFirstMap() {
        return FeatureSet.dticFirstMap;
    }

    /**
     * DTIC last name hashmap getter
     * 
     * @return DTIC last name hashmap
     */
    public static Map<String, String> getDticLastMap() {
        return FeatureSet.dticLastMap;
    }

    /**
     * Honorific hashmap getter
     * 
     * @return honorific hashmap
     */
    public static Map<String, String> getHonorificMap() {
        return FeatureSet.honorificMap;
    }

    /**
     * Prefix hashmap getter
     * 
     * @return prefix hashmap
     */
    public static Map<String, String> getPrefixMap() {
        return FeatureSet.prefixMap;
    }

    /**
     * Suffix hashmap getter
     * 
     * @return suffix hashmap
     */
    public static Map<String, String> getSuffixMap() {
        return FeatureSet.suffixMap;
    }

    /**
     * Stop lsit hashmap getter
     * 
     * @return stop list hashmap
     */
    public static Map<String, String> getStopListMap() {
        return FeatureSet.stopListMap;
    }

    /**
     * Countries hashmap getter
     * 
     * @return countries hashmap
     */
    public static Map<String, String> getCountriesMap() {
        return FeatureSet.countriesMap;
    }

    /**
     * Ordering in array (size of 13)
     * --------------------------------
     * 0 - Dictionary -
     * 1 - Places -
     * 2 - Cities -
     * 3 - Countries -
     * 4 - DTIC first
     * 5 - DTIC last
     * 6 - common first -
     * 7 - common last -
     * 8 - honorific
     * 9 - prefix
     * 10 - suffix
     * 11 - kill
     * 12 - number
     * 13 - punctuation
     * 14 - solo cap letter
     * 15 - all caps
     * 16 - first letter cap
     * 17 - new line
     * 18 - other
     * 19 - Personal Name
     */
    boolean[] bArr;

    /**
     * Takes a word and categorizes it by it's feature
     * 
     * @param theWord    A word that is passed through
     * @param isTraining Trains the machine what the features of a word are
     * @return Word with personal name
     */
    public boolean[] getFeatures(String theWord, Boolean isTraining) {
        boolean[] bArr = new boolean[20];

        bArr[0] = FeatureSet.isInDictionaryMap(stripPERTags(theWord));
        bArr[1] = FeatureSet.isInPlacesMap(stripPERTags(theWord));
        bArr[2] = FeatureSet.isInCitiesMap(stripPERTags(theWord));
        bArr[3] = FeatureSet.isInCountriesMap(stripPERTags(theWord));
        bArr[4] = FeatureSet.isInDticFirstMap(stripPERTags(theWord));
        bArr[5] = FeatureSet.isInDticLastMap(stripPERTags(theWord));
        bArr[6] = FeatureSet.isInFirstNameMap(stripPERTags(theWord));
        bArr[7] = FeatureSet.isInLastNameMap(stripPERTags(theWord));
        bArr[8] = FeatureSet.isInHonorificMap(stripPERTags(theWord));
        bArr[9] = FeatureSet.isInPrefixMap(stripPERTags(theWord));
        bArr[10] = FeatureSet.isInSuffixMap(stripPERTags(theWord));
        bArr[11] = FeatureSet.isInStopListMap(stripPERTags(theWord));
        bArr[12] = isNumber(stripPERTags(theWord));
        bArr[13] = isPunct(stripPERTags(theWord));
        System.arraycopy(isCapitalized(stripPERTags(theWord)), 0, bArr, 14, 3);
        bArr[17] = isNewline(stripPERTags(theWord));
        bArr[18] = Arrays.toString(bArr).contains("true") ? false : true;
        if (isTraining) {
            bArr[19] = isPersonalName(theWord);
        } else {
            bArr[19] = false;
        }

        return bArr;
    }

    /**
     * Checks to strip <PER> </PER> tags from training data
     * 
     * @param w Is a word with <PER> </PER> tags
     * @return A word without <PER> </PER> tags
     */
    public String stripPERTags(String w) {
        w = w.replace("<PER>", "");
        w = w.replace("</PER>", "");
        return w;
    }

    /**
     * 
     * @param w Is a word that is passed through
     * @return A word that is considered a personal
     *         name and contains PER tags
     * 
     */
    public Boolean isPersonalName(String w) {
        if (w.contains("<PER>")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param str word to be checked for lexical
     * @return boolean array of size 7
     *         With index 0 for isNumber
     *         index 1 for isPunct
     *         index 2 for capLetter
     *         index 3 for allCaps
     *         index 4 for capitalized
     *         index 5 for isNewline
     *         index 6 for other
     */
    public boolean[] findLexical(String str) {
        boolean[] lexicalArray = new boolean[7];
        // Arrays.fill(lexicalArray, Boolean.FALSE);
        lexicalArray[0] = isNumber(str);
        lexicalArray[1] = isPunct(str);
        System.arraycopy(isCapitalized(str), 0, lexicalArray, 2, 3);
        lexicalArray[5] = isNewline(str);
        lexicalArray[6] = Arrays.toString(lexicalArray).contains("true") ? false : true;
        return lexicalArray;
    }

    /**
     * Checks if a token contains a number
     * 
     * @param str Word to be checked for a number
     * @return A number
     */
    public boolean isNumber(String str) {
        Pattern number = Pattern.compile("\\d+?");
        Matcher numMatch = number.matcher(str);
        if (numMatch.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a token contains a punctuation
     * 
     * @param str Word to be checked for it
     * @return A punctuation
     */
    public boolean isPunct(String str) {
        Pattern punct = Pattern.compile("\\p{Punct}+?");
        Matcher punctMatch = punct.matcher(str);
        if (punctMatch.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param str
     * @return boolean array
     *         With index 0 for capLetter
     *         index 1 for allCaps
     *         index 2 for capitalized
     */
    public boolean[] isCapitalized(String str) {
        boolean[] capital = new boolean[3];
        Arrays.fill(capital, Boolean.FALSE);
        Pattern cap = Pattern.compile("\\p{Upper}+?");
        Matcher capMatch = cap.matcher(str);
        if (capMatch.find()) {
            if (str.length() == 1) {
                capital[0] = true;
            } else if (capMatch.matches()) {
                capital[1] = true;
            } else {
                capital[2] = true;
            }
        }
        return capital;
    }

    /**
     * Checks if there is a new lines
     * 
     * @param str A string that contains a new line
     * @return true if there is a new line
     */
    public boolean isNewline(String str) {
        Pattern newLine = Pattern.compile("\\n");
        Matcher newLineMatch = newLine.matcher(str);
        if (newLineMatch.matches()) {
            return true;
        }
        return false;
    }

    /**
     * This will take and read a file can creat hashmaps
     * The two objects for the hashmap are the same
     * 
     * @param filePath A file that is being read in
     * @return Hashmap of the file
     */
    public static Map<String, String> hashFromFile(String filePath) {
        Map<String, String> map = new HashMap<>();
        BufferedReader br = null;
        try {
            File file = new File(filePath);

            br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.equals("")) {
                    map.put(line.toLowerCase(), line.toLowerCase());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /**
     * Checks first name hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInFirstNameMap(String w) {
        return FeatureSet.firstNameMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks last name hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInLastNameMap(String w) {
        return FeatureSet.lastNameMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks cities hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInCitiesMap(String w) {
        return FeatureSet.citiesMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks dictionary hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInDictionaryMap(String w) {
        return FeatureSet.dictionaryMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks places hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInPlacesMap(String w) {
        return FeatureSet.placesMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks DTIC first name hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInDticFirstMap(String w) {
        return FeatureSet.dticFirstMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks DTIC last name hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInDticLastMap(String w) {
        return FeatureSet.dticLastMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks honorific hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInHonorificMap(String w) {
        return FeatureSet.honorificMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks prefix hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInPrefixMap(String w) {
        return FeatureSet.prefixMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks suffix hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInSuffixMap(String w) {
        return FeatureSet.suffixMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks stop list hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInStopListMap(String w) {
        return FeatureSet.stopListMap.get(w.toLowerCase()) == null ? false : true;
    }

    /**
     * Checks conutries hashmap
     * 
     * @param w word to be checked
     * @return boolean if in hashmap
     */
    public static boolean isInCountriesMap(String w) {
        return FeatureSet.countriesMap.get(w.toLowerCase()) == null ? false : true;
    }
}
