package KHLNews.controllers;

import KHLNews.models.Article;
import KHLNews.services.ArticlesListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticlesController {
    @RequestMapping(value = "/getArticles/hockey", method = RequestMethod.GET)
    public List<Article> articlesHockey() {
        ArticlesListService articles = new ArticlesListService();
        List<Article> fileNames = articles.readDirectory("hockey");
        return fileNames;
    }

    @RequestMapping(value = "/getArticles/notHockey", method = RequestMethod.GET)
    public List<Article> articlesNotHockey() {
        ArticlesListService articles = new ArticlesListService();

        List<Article> fileNames = articles.readDirectory("notHockey");
        return fileNames;
    }
}
