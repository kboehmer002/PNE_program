package edu.odu.cs350;

public class Token {
    private String theWord = "";
    private final int numKindsFeats = 20;
    private boolean[] featureSet = new boolean[numKindsFeats];

    /**
     * Default constructor for Token class
     */
    public Token() {

    }

    /**
     * Constructor intializes token with word that
     * is passed in, and sets featureSet array to all false.
     * 
     * @param w is a word passed in to be set to token's "theWord"
     */
    public Token(String w) {
        this.theWord = w;

        for (int i = 0; i < featureSet.length; i++) {
            featureSet[i] = false;
        }
    }

    /**
     * The setter for features
     * 
     * @param isTraining Is training the machine for setting the features
     */
    public void setFeatures(Boolean isTraining) {
        FeatureSet features = new FeatureSet();
        this.featureSet = features.getFeatures(this.theWord, isTraining);
    }

    /**
     * The getter of FeatureSet
     * 
     * @return The FeatureSet
     */
    public boolean[] getFeatureSet() {
        return this.featureSet;
    }

    /**
     * The setter for the FeatureSet
     * 
     * @param newSet The setter for FeatureSet
     */
    public void setFeatureSet(boolean[] newSet) {
        this.featureSet = newSet;
    }

    /**
     * The getter of a word
     * 
     * @return A word
     */
    public String getWord() {
        return this.theWord;
    }

    /**
     * The setter for a word
     * 
     * @param w A word that is being called in
     */
    public void setWord(String w) {
        this.theWord = w;
    }
}
