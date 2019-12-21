package KHLNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.jmorfsdk.loader.JMorfSdkFactory;

@SpringBootApplication
public class Application {

//    private static JMorfSdk jMorfSdk;

    public static void main(String[] args) {
//        jMorfSdk = JMorfSdkFactory.loadFullLibrary();
        SpringApplication.run(Application.class, args);

    }
}