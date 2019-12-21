package KHLNews;


import org.springframework.util.StringUtils;
import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.ms.grammeme.MorfologyParameters;
import ru.textanalysis.tawt.ms.internal.IOmoForm;

import java.util.ArrayList;
import java.util.List;

public class SomeTextGetting {
    private String someText;


    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

//    public SomeTextGetting(String someText){
//        this.someText = someText;
//    }

    public static String reverseString(String s){
//        System.out.println(s);

        VectorizeText vecText = new VectorizeText(s);
        BagOfWords bagofWords = new BagOfWords(vecText.getFilteredWords());

//        String someT = new StringBuffer(s).reverse().toString();
//        VectorizeText vText = new VectorizeText(s);



        return "test";
    }
}
