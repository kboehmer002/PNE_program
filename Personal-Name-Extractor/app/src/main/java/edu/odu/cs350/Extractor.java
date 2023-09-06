package edu.odu.cs350;

import java.util.ArrayList;
import java.util.Arrays;

import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;


public class Extractor {
        private static ArrayList<String> firstNames;
        private static ArrayList<String> lastNames;
        private static ArrayList<String> citiesNames;
        private static ArrayList<String> dictionaryNames;
        private static ArrayList<String> placesNames;
        private static ArrayList<String> dticFirstNames;
        private static ArrayList<String> dticLastNames;
        private static ArrayList<String> honorificNames;
        private static ArrayList<String> prefixNames; 
        private static ArrayList<String> suffixNames;
        private static ArrayList<String> stopListNames;
        private static ArrayList<String> contriesNames;
        private static ArrayList<String> personalNames;
        private static ArrayList<String> isNumber;
        private static ArrayList<String> punctuation;
        private static ArrayList<String> soloCapLetter;
        private static ArrayList<String> allCaps;
        private static ArrayList<String> beginLetterCap; 
        private static ArrayList<String> isNewLine;
        private static ArrayList<String> isOther;
        
        private static Attribute first;
        private static Attribute last;
        private static Attribute cities;
        private static Attribute dictionary;
        private static Attribute places;
        private static Attribute dticFirst;
        private static Attribute dticLast;
        private static Attribute honorific;
        private static Attribute prefix;
        private static Attribute suffix;
        private static Attribute stopList;
        private static Attribute contries;
        private static Attribute number;
        private static Attribute punct;
        private static Attribute soloCap;
        private static Attribute allCap;
        private static Attribute beginCap;
        private static Attribute newLine;
        private static Attribute other;
        private static Attribute personal;

        private static ArrayList<Attribute> attrInfo;

        private static int numberOfAttributes;

        private static SMO classifySvm;
        
        /**
         * trainModel() used for taining the SMO classifier and saving the trained model 
         *              tokens contains the feature set used for classification
         * 
         * @param tokens Array list of tokens used for training
         * @throws Exception if something goes wrong
         */
        public void trainModel( ArrayList<Token> tokens) throws Exception {

                ArrayList<String> trainingData = new ArrayList<>();

                for(Token tk : tokens){
                        trainingData.add(Arrays.toString(tk.getFeatureSet()));
                }


                Instances training = new Instances( "TrainingData", Extractor.attrInfo, trainingData.size());
                training.setClass(Extractor.personal);

                for(String td : trainingData){
                        td = td.replace("[", "");
                        td = td.replace("]", "");
                        td = td.replace(" ", "");
                        String[] values = td.split(","); 
                        double[] instanceValues = new double[Extractor.numberOfAttributes];

                        instanceValues[0] = training.attribute(0).indexOfValue(values[0]);
                        instanceValues[1] = training.attribute(1).indexOfValue(values[1]);
                        instanceValues[2] = training.attribute(2).indexOfValue(values[2]);
                        instanceValues[3] = training.attribute(3).indexOfValue(values[3]); 
                        instanceValues[4] = training.attribute(4).indexOfValue(values[4]);
                        instanceValues[5] = training.attribute(5).indexOfValue(values[5]);
                        instanceValues[6] = training.attribute(6).indexOfValue(values[6]);
                        instanceValues[7] = training.attribute(7).indexOfValue(values[7]);
                        instanceValues[8] = training.attribute(8).indexOfValue(values[8]); 
                        instanceValues[9] = training.attribute(9).indexOfValue(values[9]); 
                        instanceValues[10] = training.attribute(10).indexOfValue(values[10]);
                        instanceValues[11] = training.attribute(11).indexOfValue(values[11]);
                        instanceValues[12] = training.attribute(12).indexOfValue(values[12]);
                        instanceValues[13] = training.attribute(13).indexOfValue(values[13]); 
                        instanceValues[14] = training.attribute(14).indexOfValue(values[14]);
                        instanceValues[15] = training.attribute(15).indexOfValue(values[15]);
                        instanceValues[16] = training.attribute(16).indexOfValue(values[16]);
                        instanceValues[17] = training.attribute(17).indexOfValue(values[17]);
                        instanceValues[18] = training.attribute(18).indexOfValue(values[18]); 
                        instanceValues[19] = training.attribute(19).indexOfValue(values[19]);   
                        
                        Instance instance = new DenseInstance(1.0, instanceValues);
                        training.add(instance);

                }

                final double gamma = 0.01;
                final double C = 1.0;
        
                SMO svm = new SMO();
                svm.setKernel(new RBFKernel(training, 25007, gamma));
                svm.setC(C);
                svm.buildClassifier(training);
                weka.core.SerializationHelper.write("src\\main\\resources\\train.model", svm);
        }

        /**
         * Machine learning function for deteting if passed in token array contains a personal name
         * 
         * @param shingledArr Shingled token array to be compaired for personal name
         * @return true if the token is a inside the personal name list
         */
        public boolean classifyWord(ArrayList<Token> shingledArr) {
                String tempStringArray = Arrays.toString(shingledArr.get(5).getFeatureSet());
                tempStringArray = tempStringArray.replace("[", "");
                tempStringArray = tempStringArray.replace("]", "");
                tempStringArray = tempStringArray.replace(" ", "");

                String[] dataToClassify = tempStringArray.split(",");

                double[] instanceValues2 = new double[Extractor.numberOfAttributes];
                Instances classificationInstances = new Instances("toBeClassified", Extractor.attrInfo, 1);

                instanceValues2[0] = classificationInstances.attribute(0).indexOfValue(dataToClassify[0]);
                instanceValues2[1] = classificationInstances.attribute(1).indexOfValue(dataToClassify[1]);
                instanceValues2[2] = classificationInstances.attribute(2).indexOfValue(dataToClassify[2]);
                instanceValues2[3] = classificationInstances.attribute(3).indexOfValue(dataToClassify[3]); 
                instanceValues2[4] = classificationInstances.attribute(4).indexOfValue(dataToClassify[4]);
                instanceValues2[5] = classificationInstances.attribute(5).indexOfValue(dataToClassify[5]);
                instanceValues2[6] = classificationInstances.attribute(6).indexOfValue(dataToClassify[6]);
                instanceValues2[7] = classificationInstances.attribute(7).indexOfValue(dataToClassify[7]);
                instanceValues2[8] = classificationInstances.attribute(8).indexOfValue(dataToClassify[8]); 
                instanceValues2[9] = classificationInstances.attribute(9).indexOfValue(dataToClassify[9]); 
                instanceValues2[10] = classificationInstances.attribute(10).indexOfValue(dataToClassify[10]);
                instanceValues2[11] = classificationInstances.attribute(11).indexOfValue(dataToClassify[11]);
                instanceValues2[12] = classificationInstances.attribute(12).indexOfValue(dataToClassify[12]);
                instanceValues2[13] = classificationInstances.attribute(13).indexOfValue(dataToClassify[13]); 
                instanceValues2[14] = classificationInstances.attribute(14).indexOfValue(dataToClassify[14]);
                instanceValues2[15] = classificationInstances.attribute(15).indexOfValue(dataToClassify[15]);
                instanceValues2[16] = classificationInstances.attribute(16).indexOfValue(dataToClassify[16]);
                instanceValues2[17] = classificationInstances.attribute(17).indexOfValue(dataToClassify[17]);
                instanceValues2[18] = classificationInstances.attribute(18).indexOfValue(dataToClassify[18]); 
                instanceValues2[19] = classificationInstances.attribute(19).indexOfValue(dataToClassify[19]);     
                
                Instance toClassify = new DenseInstance(1.0, instanceValues2);
                classificationInstances.add(toClassify);
                classificationInstances.setClass(Extractor.personal);
                toClassify.setDataset(classificationInstances);

                //System.out.println(classificationInstances);
                
                
                //this condition just shows we can wrap names in PER tags without relying on machine learning
                Boolean probablyAName = false;
                if(dataToClassify[6].contains("true")){
                        probablyAName = true;
                }

                
                double predictedCategory;
                try {
                        predictedCategory = Extractor.classifySvm.classifyInstance(toClassify);
                        //System.out.println(predictedCategory);
                        //System.out.println("Classified as " + toClassify.classAttribute().value((int)predictedCategory));
                        String isName = toClassify.classAttribute().value((int)predictedCategory);
                        if(isName == "true" || probablyAName){
                                return true;
                        }
                        else{
                                return false;  
                        }
                } catch (Exception e) {
                        
                        e.printStackTrace();
                        return false;
                }

        }

        /**
         * Used to load pretrained SMO model from file
         * 
         * @throws Exception if something goes wrong
         */
        public static void setClassifySvm(){
                try {
                        Extractor.classifySvm = (SMO)SerializationHelper.read("src\\main\\resources\\train.model");
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
        /**
         * Setting attribute list into Static variable attrInfo
         */
        public static void setAttributes() { 
                Extractor.firstNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.lastNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.citiesNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.dictionaryNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.placesNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.dticFirstNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.dticLastNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.honorificNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.prefixNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.suffixNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.stopListNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.contriesNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.personalNames = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.isNumber = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.punctuation = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.soloCapLetter = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.allCaps = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.beginLetterCap = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.isNewLine = new ArrayList<>(Arrays.asList("true", "false"));
                Extractor.isOther = new ArrayList<>(Arrays.asList("true", "false"));

                Extractor.first = new Attribute("first", firstNames);
                Extractor.last = new Attribute("last", lastNames);
                Extractor.cities = new Attribute("cities", citiesNames);
                Extractor.dictionary = new Attribute("dictionary", dictionaryNames);
                Extractor.places = new Attribute("places", placesNames);
                Extractor.dticFirst = new Attribute("dticFirst", dticFirstNames);
                Extractor.dticLast = new Attribute("dticLastN", dticLastNames);
                Extractor.honorific = new Attribute("honorific", honorificNames);
                Extractor.prefix = new Attribute("prefix", prefixNames);
                Extractor.suffix = new Attribute("suffix", suffixNames);
                Extractor.stopList = new Attribute("stopList", stopListNames);
                Extractor.contries = new Attribute("contries", contriesNames);
                Extractor.number = new Attribute("number", isNumber);
                Extractor.punct = new Attribute("punctuation", punctuation);
                Extractor.soloCap = new Attribute("solocap", soloCapLetter);
                Extractor.allCap = new Attribute("allcaps", allCaps);
                Extractor.beginCap = new Attribute("begincap", beginLetterCap);
                Extractor.newLine = new Attribute("newline", isNewLine);
                Extractor.other = new Attribute("other", isOther);
                Extractor.personal = new Attribute("personalnames", personalNames);

                Extractor.attrInfo = new ArrayList<>();
                Extractor.attrInfo.add(dictionary);
                Extractor.attrInfo.add(places);
                Extractor.attrInfo.add(cities);
                Extractor.attrInfo.add(contries);
                Extractor.attrInfo.add(dticFirst);
                Extractor.attrInfo.add(dticLast);
                Extractor.attrInfo.add(first);
                Extractor.attrInfo.add(last);
                Extractor.attrInfo.add(honorific);
                Extractor.attrInfo.add(prefix);
                Extractor.attrInfo.add(suffix);
                Extractor.attrInfo.add(stopList);
                Extractor.attrInfo.add(number);
                Extractor.attrInfo.add(punct);
                Extractor.attrInfo.add(soloCap);
                Extractor.attrInfo.add(allCap);
                Extractor.attrInfo.add(beginCap);
                Extractor.attrInfo.add(newLine);
                Extractor.attrInfo.add(other);
                Extractor.attrInfo.add(personal);

                Extractor.numberOfAttributes = attrInfo.size();
        }

        /**
         * Getter for attrInfo
         * @return attrInfo which is an ArrayList of Attributes
         */
        public ArrayList<Attribute> getAttrInfo(){
                return attrInfo;
        }
}
