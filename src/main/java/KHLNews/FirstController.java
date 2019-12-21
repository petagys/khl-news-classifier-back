package KHLNews;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class FirstController {
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    //public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String greeting() {
        //model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/someText", method = RequestMethod.POST, consumes = {"application/json"})
//    public String getSomeText(@ModelAttribute SomeTextGetting someTextGetting, Model model) {
//        model.addAttribute("someText", someTextGetting);
    public String getSomeText(@RequestBody SomeTextGetting someTextGetting) {
        //JSONObject json = new JSONObject(someTextGetting);
        //System.out.println(json.getString("someInput"));
        //return json.getString("someInput");
        System.out.println(someTextGetting.getSomeText());

        return SomeTextGetting.reverseString(someTextGetting.getSomeText());
    }
}