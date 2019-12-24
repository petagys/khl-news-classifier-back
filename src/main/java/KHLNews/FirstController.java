package KHLNews;

import org.springframework.web.bind.annotation.*;


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
    public String greetingNotHockey() {
        return "notHockey";
    }


    @RequestMapping(value = "/someText", method = RequestMethod.POST, consumes = {"application/json"})
//    public String getSomeText(@ModelAttribute SomeTextGetting someTextGetting, Model model) {
//        model.addAttribute("someText", someTextGetting);
    public String getSomeText(@RequestBody SomeTextGetting someTextGetting) throws Exception {
        //JSONObject json = new JSONObject(someTextGetting);
        //System.out.println(json.getString("someInput"));
        //return json.getString("someInput");
//        System.out.println(someTextGetting.getSomeText());
        VectorizeText vecText = new VectorizeText(someTextGetting.getSomeText());
        TextClasses textClass = classificatorer.getClass(vecText.getFilteredWords());
        return TextClasses.getRussianClassName(textClass);
    }
}