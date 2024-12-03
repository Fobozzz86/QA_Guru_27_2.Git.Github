import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
    @Test
    void successfulSearchTest() {
        // Configuration.pageLoadTimeout = 45000;
        Configuration.pageLoadStrategy = "eager";
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("#search").should(text("https://ru.selenide.org"));
        //       sleep(600_000); //Это для не закрытия браузера после теста
    }

}
