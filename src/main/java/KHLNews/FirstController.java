package KHLNews;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class FirstController {

    private Classificatorer classificatorer;
    private VectorizeText vectorizeText;

    public FirstController() throws Exception {
        classificatorer = new Classificatorer();

    }

    @RequestMapping(value = "/getArticles/hockey", method = RequestMethod.GET)
    public String greetingHockey() {
        return "hockey";
    }

    @RequestMapping(value = "/getArticles/notHockey", method = RequestMethod.GET)
    public ArrayList<Article> greetingNotHockey() {
        ArticlesList articles = new ArticlesList();

        ArrayList<Article> fileNames = (ArrayList<Article>) articles.readDirectory("notHockey");
        return fileNames;
    }


    @RequestMapping(value = "/someText", method = RequestMethod.POST, consumes = {"application/json"})
    public String getSomeText(@RequestBody SomeTextGetting someTextGetting) throws Exception {
        VectorizeText vecText = new VectorizeText(someTextGetting.getSomeText());
        TextClasses textClass = classificatorer.getClass(vecText.getFilteredWords());
        return TextClasses.getRussianClassName(textClass);
    }
}