package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void textBoxTest() {
        open("/text-box");
        $("#userName").setValue("Test1");
        $("#userEmail").setValue("test1@gmail.com");
        $("#currentAddress").setValue("Test1 Current Address");
        $("#permanentAddress").setValue("Test1 Permanent Address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Test1"));
        $("#output #email").shouldHave(text("test1@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Test1 Current Address"));
        $("#output #permanentAddress").shouldHave(text("Test1 Permanent Address"));
    }
}
