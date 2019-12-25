package KHLNews.controllers;

import KHLNews.models.SomeTextGetting;
import KHLNews.models.TextClasses;
import KHLNews.services.ClassificatorerService;
import KHLNews.services.FilterTextService;
import org.springframework.web.bind.annotation.*;
import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.jmorfsdk.loader.JMorfSdkFactory;



@RestController
public class ClassificatorController {

    private ClassificatorerService classificatorerService;
    private static JMorfSdk jMorfSdk;

    public ClassificatorController() throws Exception {
        jMorfSdk = JMorfSdkFactory.loadFullLibrary();
        classificatorerService = new ClassificatorerService();
    }


    @RequestMapping(value = "/someText", method = RequestMethod.POST, consumes = {"application/json"})
    public String getSomeText(@RequestBody SomeTextGetting someTextGetting) throws Exception {
        FilterTextService vecText = new FilterTextService(someTextGetting.getSomeText());
        TextClasses textClass = classificatorerService.getClass(vecText.getFilteredWords());
        return TextClasses.getRussianClassName(textClass);
    }
}