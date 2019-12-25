package KHLNews.services;

import KHLNews.models.TextClasses;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassificatorerService {

    private Classifier classifier;
    private HashMap<String, Integer> allWords;

    public ClassificatorerService() throws Exception {
        classifier = (Classifier) SerializationHelper.read(new FileInputStream("KHLModelForest.model"));
        allWords = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("hockeyNewsVSnotHockeyNews-bag.txt"), "UTF8"));
        int wordCounter = 0;
        String line = reader.readLine();
        while (line != null) {
            allWords.put(line, wordCounter);
            ++wordCounter;
            line = reader.readLine();
        }
    }

    public TextClasses getClass(ArrayList<String> filteredWords) throws Exception {
        Instances vectorText = classifyText(filteredWords);

        double textClass = classifier.classifyInstance(vectorText.firstInstance());
        return TextClasses.values()[(int) textClass];
    }

    private Instances classifyText(ArrayList<String> normalWords) {
        double[] vector = new double[allWords.size() + 1];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }

        for (int i = 0; i < normalWords.size(); ++i) {
            Integer attributeIndex = allWords.get(normalWords.get(i));
            if (attributeIndex != null) {
                vector[attributeIndex] = vector[attributeIndex] + 1;
            }
        }

        ArrayList<String> textClasses = new ArrayList<>();
        for (int i = 0; i < TextClasses.values().length; ++i) {
            textClasses.add(TextClasses.values()[i].toString());
        }
        Attribute classAttribute = new Attribute("class", textClasses);
        ArrayList<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < allWords.size(); ++i) {
            attributes.add(new Attribute("attribute_word_" + (i + 1)));
        }
        attributes.add(classAttribute);

        Instances vectorizedText;
        vectorizedText = new Instances("text", attributes, 0);
        vectorizedText.setClass(classAttribute);
        vectorizedText.add(new DenseInstance(1.0, vector));
        vectorizedText.instance(0).setClassMissing();
        return vectorizedText;
    }


}
