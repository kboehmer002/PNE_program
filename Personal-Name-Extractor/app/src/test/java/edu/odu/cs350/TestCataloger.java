package edu.odu.cs350;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Stopwatch;
import java.lang.StringBuffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCataloger {
    /**
     * This Test function relies on accurate machine learning, thus it is failing :(
     * 
     * 
     * This is a system test does not require any input. Tests the functionality of
     * the
     * processInput() function such that
     * 
     * @func processInput()
     * @param takes in a buffer
     *              1. A buffer reader and buffer writer can be used to transfer
     *              data in and out
     *              of the function
     *              2. It is able to maintain original block formatting upon output
     *              3. It is able to process multiple blocks at a time of varying
     *              sizes
     *              4. It outputs blocks with properly placed <PER> </PER> tag pairs
     *              as well as
     *              the original placement of the <NER> </NER> tags
     *              5. It returns the resulting blocks using standard out
     */
    @Test
    public void testProcessInput() {
        Cataloger cataloger = new Cataloger();

        StringBuffer buff = new StringBuffer();
        buff.append("word");
        buff.append(" next");
        System.out.println(buff);

        String t1 = "<NER>Ousmane is a Computer Science major.</NER>";
        String t2 = "<NER> Kristi Boehmer likes to watch the Phantom of the Opera!<NER>";
        String t3 = "<NER>John-Henry's favorite color  is    orange<NER>";
        String t4 = "<NER>Charlie, have you ever been to the George Washington Bridge?</NER>";
        String t5 = "<NER>Josh says Abbott Laboratories and Abercrombie & Fitch are not considered personal names.</NER>";
        String t6 = "<NER>How many more tests do I need to write? Have I covered them all yet? I feel like I have written more than Five-Thousand.</NER>";
        String t7 = "<NER></NER>";
        String t8 = "<NER>Hello<NER> <NER> My name is Anna.</NER>";

        String k1 = "<NER><PER>Ousmane</PER> is a Computer Science major.</NER>";
        String k2 = "<NER> <PER>Kristi Boehmer</PER> likes to watch Phantom of the Opera!<NER>";
        String k3 = "<NER><PER>John-Henry's</PER> favorite color  is    orange<NER>";
        String k4 = "<NER><PER>Charlie</PER>, have you ever been to the George Washington Bridge?</NER>";
        String k5 = "<NER><PER>Josh</PER> says Abbott Laboratories and Abercrombie & Fitch are not considered personal names.</NER>";
        String k6 = "<NER>How many more tests do I need to write? Have I covered them all yet? I feel like I have written more than Five-Thousand.</NER>";
        String k7 = "<NER></NER>";
        String k8 = "<NER>Hello<NER> <NER> My name is <PER>Anna</PER>.</NER>";

        try {
            StringReader strReader1 = new StringReader(t1);
            StringReader strReader2 = new StringReader(t2);
            StringReader strReader3 = new StringReader(t3);
            StringReader strReader4 = new StringReader(t4);
            StringReader strReader5 = new StringReader(t5);
            StringReader strReader6 = new StringReader(t6);
            StringReader strReader7 = new StringReader(t7);
            StringReader strReader8 = new StringReader(t8);

            BufferedReader reader1 = new BufferedReader(strReader1);
            BufferedReader reader2 = new BufferedReader(strReader2);
            BufferedReader reader3 = new BufferedReader(strReader3);
            BufferedReader reader4 = new BufferedReader(strReader4);
            BufferedReader reader5 = new BufferedReader(strReader5);
            BufferedReader reader6 = new BufferedReader(strReader6);
            BufferedReader reader7 = new BufferedReader(strReader7);
            BufferedReader reader8 = new BufferedReader(strReader8);

            StringWriter strWriter1 = new StringWriter();
            StringWriter strWriter2 = new StringWriter();
            StringWriter strWriter3 = new StringWriter();
            StringWriter strWriter4 = new StringWriter();
            StringWriter strWriter5 = new StringWriter();
            StringWriter strWriter6 = new StringWriter();
            StringWriter strWriter7 = new StringWriter();
            StringWriter strWriter8 = new StringWriter();

            BufferedWriter writer1 = new BufferedWriter(strWriter1);
            BufferedWriter writer2 = new BufferedWriter(strWriter2);
            BufferedWriter writer3 = new BufferedWriter(strWriter3);
            BufferedWriter writer4 = new BufferedWriter(strWriter4);
            BufferedWriter writer5 = new BufferedWriter(strWriter5);
            BufferedWriter writer6 = new BufferedWriter(strWriter6);
            BufferedWriter writer7 = new BufferedWriter(strWriter7);
            BufferedWriter writer8 = new BufferedWriter(strWriter8);

            cataloger.processInput(reader1, writer1, false);
            cataloger.processInput(reader2, writer2, false);
            cataloger.processInput(reader3, writer3, false);
            cataloger.processInput(reader4, writer4, false);
            cataloger.processInput(reader5, writer5, false);
            cataloger.processInput(reader6, writer6, false);
            cataloger.processInput(reader7, writer7, false);
            cataloger.processInput(reader8, writer8, false);

            reader1.close();
            reader2.close();
            reader3.close();
            reader4.close();
            reader5.close();
            reader6.close();
            reader7.close();
            reader8.close();

            writer1.close();
            writer2.close();
            writer3.close();
            writer4.close();
            writer5.close();
            writer6.close();
            writer7.close();
            writer8.close();

            assertEquals(strWriter1.toString(), k1);
            assertEquals(strWriter2.toString(), k2);
            assertEquals(strWriter3.toString(), k3);
            assertEquals(strWriter4.toString(), k4);
            assertEquals(strWriter5.toString(), k5);
            assertEquals(strWriter6.toString(), k6);
            assertEquals(strWriter6.toString(), k7);
            assertEquals(strWriter6.toString(), k8);

        } catch (Exception e) {
            assertFalse(true);
        }

    }

    /**
     * System test
     * Tests that it can run through 10 pages in under a minute
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testProcessingPower() throws FileNotFoundException {

        Cataloger cataloger = new Cataloger();
        StringWriter strWriter = new StringWriter();

        long timeElapsed = 0;
        Stopwatch stopwatch = Stopwatch.createStarted();

        Extractor.setAttributes();
        FeatureSet.setAllMaps(FeatureSet.firstNameLoc, FeatureSet.lastNameLoc, FeatureSet.citiesLoc,
                FeatureSet.dictionaryLoc, FeatureSet.placesLoc, FeatureSet.dticFirstLoc, FeatureSet.dticLastLoc,
                FeatureSet.honorificLoc, FeatureSet.prefixLoc, FeatureSet.suffixLoc, FeatureSet.stopLoc,
                FeatureSet.countriesLoc);
        Extractor.setClassifySvm();

        FileReader fr = new FileReader("src/test/java/edu/odu/cs350/TestFiles/processTestFile.txt");

        try {
            BufferedReader reader = new BufferedReader(fr);
            BufferedWriter writer = new BufferedWriter(strWriter);
            cataloger.processInput(reader, writer, false);
            reader.close();
            writer.close();
            stopwatch.stop();
            timeElapsed = stopwatch.elapsed(TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(timeElapsed < 60);
    }
}
