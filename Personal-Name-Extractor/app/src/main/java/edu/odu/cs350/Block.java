package edu.odu.cs350;

import java.util.ArrayList;

// gradle -q run < src\main\resources\test.txt > src\main\resources\output.txt

public class Block {
    private String[] rawBlock;
    private int wordCount = 0;
    private int tagIndex;
    private ArrayList<Token> tokens;
    private ArrayList<Integer> personalNameIndex;

    /**
     * Default constructor for the Block class
     */
    public Block() {
    }

    /**
     * Constructor for the Block class.
     * Takes a string and splits the block into tokens, removes text before the
     * opening tag, adds <PER> </PER> tags in the appropriate places in the tokens
     * arraylist of strings
     * 
     * @param block is a string of the original block before being split into tokens
     */
    public Block(String block, Boolean isTraining) {
        block = removeNERTags(block);// removes both tags now

        this.rawBlock = block.split(String.format("((?<=%1$s)|(?=%1$s))",
                new Object[] { "^(<\\/?[A-Z]{0,3}>)|\\s|(\\W(?<!(<|>|/))(?!>)) | (?='[^'-]') | " }));

        this.wordCount = findWordCount(this.rawBlock);

        if (inBound(wordCount) || isTraining) {
            this.personalNameIndex = new ArrayList<>();
            this.tokens = new ArrayList<>();

            for (String rb : this.rawBlock) {
                this.tokens.add(new Token(rb));
            }

            for (Token tk : this.tokens) {
                tk.setFeatures(isTraining);
            }

            if (isTraining) {
                Extractor extract = new Extractor();
                try {
                    extract.trainModel(this.tokens);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Extractor extract = new Extractor();
                for (int i = 0; i < this.tokens.size(); i++) {
                    if (extract.classifyWord(this.shingleArray(this.tokens, i))) {
                        personalNameIndex.add(i);
                    }
                }

                for (Integer i : personalNameIndex) {
                    this.tokens.get(i).setWord(addPERTags(this.tokens.get(i).getWord()));
                }

                int lastIndex = this.tokens.size() - 1;
                int firstIndex = getOpeningTagIndex(this.tokens);

                if (firstIndex != -1) {
                    this.tokens.get(firstIndex).setWord(attachNERTags(this.tokens.get(firstIndex).getWord(), true));
                    this.tokens.get(lastIndex).setWord(attachNERTags(this.tokens.get(lastIndex).getWord(), false));
                } else {

                }
            }
        }
    }

    /**
     * Takes in a string for a word that has already been identified as either the
     * first word in a block or the last word in a block and adds <NER> to the first
     * word and </NER> to the last word
     * 
     * @param str     which is a string containing marked up block
     * @param isFirst which is a logical value indicating if it is the first or last
     *                word in the block
     *                True: it is the first word in the block
     *                False: it is the last word in the block
     * @return a string of the word plus the proper block tag <NER> </NER>
     */

    public String attachNERTags(String str, Boolean isFirst) {
        StringBuilder tempWord = new StringBuilder(str);

        if (isFirst) {
            tempWord.insert(0, "<NER>");
        } else {
            tempWord.insert(tempWord.length(), "</NER>");
        }

        return tempWord.toString();
    }

    /**
     * Checks if the character indicates a special spacing practice which will
     * affect tag placement in the final block
     * 
     * @param c a character from the string
     * @return boolean value
     *         True: c is a new line, carriage return, or tab
     *         False: c is any other character
     */
    public boolean lineForms(Character c) {
        return (c == '\n' || c == '\r' || c == '\t');
    }

    /**
     * A getter for the tagIndex
     * 
     * @return the private variable tagIndex
     */
    public int getTagIndex() {
        return this.tagIndex;
    }

    /**
     * A setter for the tagIndex
     * 
     * @param index to be stored in tagIndex
     */
    public void setTagIndex(int index) {
        this.tagIndex = index;
    }

    /**
     * Retrieves a specific block's word count
     * 
     * @return the value of the integer wordCount
     */
    public int getWordCount() {
        return this.wordCount;
    }

    /**
     * Stores the current block's new word count
     * 
     * @param newCount is the integer value of the number of words in the current
     *                 block
     */
    public void setWordCount(int newCount) {
        this.wordCount = newCount;
    }

    /**
     * An identified personal name is marked with personal name tags around a single
     * name with the exceptions of ' and - for instances such as John-Henry's
     * 
     * @param str is a string from the block array that has already been identified
     *            as a personal name
     * @return a string with appropriately placed <PER> </PER> tags on either end of
     *         the word
     */
    public String addPERTags(String str) {
        return "<PER>" + str + "</PER>";
    }

    /**
     * Reads through each string stored in the array to search for the first opening
     * <NER> tag
     * 
     * @param strArr is a string array of the split block to identify the location
     *               of the <NER> tag
     * @return the location of the tag in the rawblock string array. If one is not
     *         found then it returns -1
     */
    public int getOpeningTagIndex(ArrayList<Token> arrList) {

        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).getWord().contains("\n") | arrList.get(i).getWord().contains("\r")
                    | arrList.get(i).getWord().contains("\s")) {
            } else {
                ;
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the <NER> </NER> block tags from a string
     * 
     * @param str is a string containing the <NER> and </NER> tags
     * @return str that has been stripped of the opening and closing block tags
     */
    public String removeNERTags(String str) {
        str = str.replace("</NER>", "");
        str = str.replace("<NER>", "");
        return str;
    }

    // Only gets called by Cataloger if length is within bounds

    /**
     * Prints the final product block. This is only called by Cataloger if the block
     * is within bounds
     * 
     * @return str a continuous string of the reconstructed block
     */
    public String printMarkedUpBlock() {
        String str = "";
        if (this.tokens != null) {
            for (int i = 0; i < this.tokens.size(); i++) {
                str += this.tokens.get(i).getWord();
            }
        }

        return str;
    }

    /**
     * Determines if the block is too large to be processed
     * 
     * @param wordCount
     * @return boolean value
     *         True: wordCount is [0, 500]
     *         False: wordCount is (-infinity, 0) or (500, +infinity)
     */
    public boolean inBound(int wordCount) {
        return ((wordCount <= 500) && (wordCount >= 0));
    }

    /**
     * Shingles tokens for the indicated target word. Anything that is outside the
     * bounds of the array will be marked as "null" in the shingled array
     * 
     * @param arrList an array list of the type Token containing all tokens in the
     *                block
     * @param index   location of the target word in the arrList
     * @return tempArr which is a shingled array of 11 tokens with the target word
     *         in the middle and 5 words before and after the target word.
     */
    public ArrayList<Token> shingleArray(ArrayList<Token> arrList, int index) {
        ArrayList<Token> tempArr = new ArrayList<>();
        int tempIndex = 6;

        tempArr.add(arrList.get(index));

        for (int i = 1; i < tempIndex; i++) {
            if (index + i > arrList.size() - 1) {
                tempArr.add(null);
            } else {
                if (arrList.get(index + i).getWord().contains("\s") || arrList.get(index + i).getWord().contains("\n")
                        || arrList.get(index + i).getWord().contains("\r")) {
                    tempIndex++;
                } else {
                    tempArr.add(arrList.get(index + i));
                }
            }

        }

        tempIndex = 6;

        for (int i = 1; i < tempIndex; i++) {
            if (index - i < 0) {
                tempArr.add(0, null);
            } else {
                if (arrList.get(index - i).getWord().contains("\s") || arrList.get(index - i).getWord().contains("\n")
                        || arrList.get(index - i).getWord().contains("\r")) {
                    tempIndex++;
                } else {
                    tempArr.add(0, arrList.get(index - i));
                }
            }
        }

        return tempArr;
    }

    /**
     * Counts the number of words where whitespace and symbols do not count as
     * words. Words are considered as alphanumeric with the exception of ' and -
     * 
     * @param arr is a string array of all separated lexicals in a single block
     */
    public int findWordCount(String[] arr) {
        int count = 0;

        for (String w : arr) {
            if (w.matches("[^a-zA-Z0-9'-]")
                    || (w.contains("\n") || w.contains("\s") || w.contains("\r") || w.contains("\t"))) {
                // SKIP
            } else {
                count++;
            }
        }

        return count;
    }
}