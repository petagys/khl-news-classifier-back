package KHLNews;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class Article implements Serializable {
    private String header = "";
    private String text = "";

    public Article(String header, String text) {
        this.header = header;
        this.text = text;
    }


}
