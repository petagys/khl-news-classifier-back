package KHLNews;

public enum TextClasses {
    hockeyNews,
    notHockeyNews;


    public static String getRussianClassName(TextClasses textClass){
        System.out.println(textClass);
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
