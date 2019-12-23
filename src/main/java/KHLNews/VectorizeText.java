package KHLNews;

import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.jmorfsdk.loader.JMorfSdkFactory;
import ru.textanalysis.tawt.ms.grammeme.MorfologyParameters;
import ru.textanalysis.tawt.ms.internal.IOmoForm;
import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VectorizeText {
    private String text = "";
    private final List<String> words;
    private final ArrayList<String> filteredWords;
    private static JMorfSdk jMorfSdk;

    public VectorizeText(String text) throws Exception{
        this.text = text;
        words = new ArrayList<>();
        filteredWords = new ArrayList<>();
        jMorfSdk = JMorfSdkFactory.loadFullLibrary();
        vectorizeTextFunc();
    }

    public void vectorizeTextFunc(){
        text = text.toLowerCase().replaceAll("[.,\\/#!\\?$%\\^&\\*;:{}=_`~()«»]", "");
        System.out.println(text);

        String [] badWords = text.split("\\s+");
        for (int i = 0; i < badWords.length;i++){
            words.add(badWords[i]);
        }
        System.out.println(words);

        for (String word : words) {
            for (IOmoForm form : jMorfSdk.getAllCharacteristicsOfForm(word)) {
                if (word.length() > 2 && form.getTypeOfSpeech() != MorfologyParameters.TypeOfSpeech.NOUNPRONOUN
                        && form.getTypeOfSpeech() != MorfologyParameters.TypeOfSpeech.PARTICLE
                        && form.getTypeOfSpeech() != MorfologyParameters.TypeOfSpeech.PRETEXT
                ) {
                    filteredWords.add(form.getInitialFormString());
                    break;
                }
            }
        }
        System.out.println(filteredWords);
    }

    public ArrayList<String> getFilteredWords(){
        return filteredWords;
    }

}
