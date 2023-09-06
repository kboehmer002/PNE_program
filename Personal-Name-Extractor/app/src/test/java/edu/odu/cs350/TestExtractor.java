package edu.odu.cs350;

import org.junit.Test;

import weka.core.Attribute;

import static org.junit.Assert.*;
// http://junit.sourceforge.net/javadoc/org/junit/Assert.html

import java.io.File;
import java.util.ArrayList;

public class TestExtractor {
    
    @Test
    public void testTrainModel(){

    }

    @Test
    public void testClassifyWord(){

    }

    /**
     * testSetClassifySvm() check to make sure the trained model has been saved
     */
    @Test
    public void testSetClassifySvm(){
        Extractor.setClassifySvm();
        File f = new File("src\\main\\resources\\train.model");
        assertTrue(f.exists());
    }

    /**
     * testSetArributes() checks to make sure the Attributes are correctly set
     */
    @Test
    public void testSetAttributes(){
        Extractor extract = new Extractor();
        Extractor.setAttributes();
        ArrayList<Attribute> temp = extract.getAttrInfo();
        String test = "[@attribute dictionary {true,false}, @attribute places {true,false}, @attribute cities {true,false}, @attribute contries {true,false}, @attribute dticFirst {true,false}, @attribute dticLastN {true,false}, @attribute first {true,false}, @attribute last {true,false}, @attribute honorific {true,false}, @attribute prefix {true,false}, @attribute suffix {true,false}, @attribute stopList {true,false}, @attribute number {true,false}, @attribute punctuation {true,false}, @attribute solocap {true,false}, @attribute allcaps {true,false}, @attribute begincap {true,false}, @attribute newline {true,false}, @attribute other {true,false}, @attribute personalnames {true,false}]";
        assertEquals(test, temp.toString());
    }
}
