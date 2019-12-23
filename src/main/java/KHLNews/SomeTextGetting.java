package KHLNews;


import org.springframework.util.StringUtils;
import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.ms.grammeme.MorfologyParameters;
import ru.textanalysis.tawt.ms.internal.IOmoForm;

import java.util.ArrayList;
import java.util.List;

public class SomeTextGetting {
    private String someText;

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }
}
