package KHLNews;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticlesList {
    public ArticlesList(){}

    public List<Article> readDirectory(String articlesClass){
        try {
            File dir = new File(articlesClass);
            File []arrFiles = dir.listFiles();
            List<File> lst = Arrays.asList(arrFiles);
            List<Article> fileNames = new ArrayList<>();
            int i = 0;
            for (File file : lst) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.parse(file);

                String text = document.getElementsByTagName("text").item(0).getTextContent();
                String header = document.getElementsByTagName("title").item(0).getTextContent();
                Article article = new Article(header, text);
                System.out.println(i);
                i++;
                fileNames.add(article);
            }
            if (fileNames.size() == 0) {
//                System.out.println("In the directory '" + path + "' no xml files founded!");
                throw new FileNotFoundException();
            };
            return fileNames;
        } catch (Exception e){
            System.out.println("Wrong directory! Please, try again..");
            System.exit(0);
            return null;
        }
    }
}
