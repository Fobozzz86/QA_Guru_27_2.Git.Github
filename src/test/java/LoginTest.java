import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeAll
    static void beforeAll() {
        // Конфиг webdriver ждет, пока страница не будет полностью загружена
        Configuration.pageLoadStrategy = "eager";
    }

    void successfulLoginTest() {

        open("https://school.qa.guru");
        //     Ввести адрес электронной почты
        $("[name=email]").setValue("fobozzz@yandex.ru");
        //     Ввести пароль
        $("[name=password]").setValue("33p4AC&A").pressEnter();
        //     Проверить успешную авторизацию
        $(".page-header").should(text("Список тренингов"));

    }

    void successfulLoginAkk() {
        open("https://school.qa.guru/cms/system/login");
        //     Проверить успешную авторизацию аккаунтом
        $(".logined-form").should(text("Здравствуйте, Artur"));

        Selenide.closeWebDriver();
    }
    void negativeLoginTest() {
        open("https://school.qa.guru");
        //     Ввести адрес электронной почты
        $("[name=email]").setValue("fobozzz@yandex.ru");
        //     Ввести пароль
        $("[name=password]").setValue("33p4AC&Artrt").pressEnter();
        //     Проверить не удачную авторизацию с неверным паролем
        $(".btn-error").should(text("Неверный пароль"));

        Selenide.closeWebDriver();
    }

    void negativeEmptyLogin() {
        open("https://school.qa.guru");
        //     Нажать на Вход
        $(".btn-success").pressEnter();
        //     Проверить не удачную авторизацию с незаполненным логином
        $(".btn-error").should(text("Не заполнено поле E-Mail"));

        //      sleep(600_000); //Это для не закрытия браузера после теста
    }

    @Test //такое исполнение делает последовательность тестов
    public void test() {
        successfulLoginTest();
        successfulLoginAkk();
        negativeLoginTest();
        negativeEmptyLogin();

    }
}