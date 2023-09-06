package edu.odu.cs350;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

//gradle -q run --args="secretTrainingPassword123" < src\main\resources\test.txt > src\main\resources\output.txt

public class Cataloger {

  /**
   * Default constructor for the Cataloger class
   */
  public Cataloger() {
    FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
        FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
        FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
        FeatureSet.countriesLoc);
    Extractor.setAttributes();
    Extractor.setClassifySvm();
  }

  /**
   * Reads inBuffer for block ending in </NER> process then pushes
   * processed block into outBuffer
   * 
   * @param inBuffer   input block needing processed formated with wrapped <NER>
   *                   </NER> tags
   * @param outBuffer  output block after processed formatted with wrapped <NER>
   *                   </NER> tags
   *                   and approprate <PER> </PER> tags
   * @param isTraining logical that indicates if it is training the machine
   * 
   * @throws Exception
   */
  public void processInput(BufferedReader inBuffer, BufferedWriter outBuffer, Boolean isTraining)
      throws Exception {

    Scanner reader = new Scanner(inBuffer);

    if (!isTraining) {
      reader.useDelimiter(Pattern.compile("(?<=</NER>$)\\W", 8));

      while (reader.hasNext()) {
        String str = reader.next();
        Block temp = new Block(str, isTraining);
        outBuffer.write(temp.printMarkedUpBlock());
      }
    } else {
      String str = reader.useDelimiter(Pattern.compile("\\A")).next();
      Block temp = new Block(str, isTraining);
    }
    reader.close();
  }

  /**
   * This is the main function, recives input on standard in,
   * processes output on standard out.
   * 
   * @param args runs only if no args are supplied
   * 
   * @exception e prints to the standard error stream
   */
  public static void main(String[] args) {
    Cataloger cataloger = new Cataloger();
    boolean isTraining = false;

    FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
        FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
        FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
        FeatureSet.countriesLoc);
    Extractor.setAttributes();

    if (args.length == 0)
      try {
        Extractor.setClassifySvm();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new PrintWriter(new OutputStreamWriter(System.out, "UTF-8")));

        cataloger.processInput(reader, writer, isTraining);
        reader.close();
        writer.close();

      } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
      }
    else {
      if (args[0].equals("secretTrainingPassword123")) {
        isTraining = true;

        try {
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
          BufferedWriter writer = new BufferedWriter(new PrintWriter(new OutputStreamWriter(System.out, "UTF-8")));

          cataloger.processInput(reader, writer, isTraining);
          reader.close();
          writer.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
