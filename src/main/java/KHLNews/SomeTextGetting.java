package KHLNews;

public class SomeTextGetting {
    private String someText;

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }
    public static String reverseString(String s){
//        System.out.println(getSomeText());
        String someT = new StringBuffer(s).reverse().toString();
        return someT;
    }
}
