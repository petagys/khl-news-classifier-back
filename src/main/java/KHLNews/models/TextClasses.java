package KHLNews.models;

public enum TextClasses {
    notHockeyNews,
    hockeyNews;


    public static String getRussianClassName(TextClasses textClass){
        switch (textClass){
            case hockeyNews:
                return "Хоккейные новости";
            case notHockeyNews:
                return "Нехоккейные новости";
            default:
                return "Видимо другой класс";
        }
    }
}
