package KHLNews.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class Article implements Serializable {
    @JsonProperty("Заголовок статьи")
    private String header = "";
    @JsonProperty("Текст статьи")
    private String text = "";

    public Article(String header, String text) {
        this.header = header;
        this.text = text;
    }


}
