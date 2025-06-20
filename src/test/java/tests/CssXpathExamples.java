package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpath() {
        // <input type-"email" class-"inputtext login_form_input_box" name-"email" id-*email" data-testid-"email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $x("//*[data-testid='email']").setValue("1");

        // <input type-"email" class-"inputtext login_form_input_box" name-"email" id-*email">
        $("#email").setValue("1");
        $(by("id", "email")).setValue("1");
        $(byId("email")).setValue("1");
        $("#email").setValue("1");
        $x("//*[@id='email']").setValue("1");

        // <input type-"email" class-"inputtext login_form_input_box" name-"email">
        $("[name=email]").setValue("1");
        $(by("name", "email")).setValue("1");
        $(byName("email")).setValue("1");
        $x("//*[@name='email']").setValue("1");

        // <input type-"email" class-"inputtext login_form_input_box">
        $("[class=inputtext][class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        // Так как тут два разных элемента, то мы добавляем пробел.
        // В строках 29-33 пробел не нужен, так как это были классы одного элемента
        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("1");
        $(".inputtext").$(".login_form_input_box").setValue("1");
        $("div.inputtext").$("input.login_form_input_box").setValue("1");
        $("div.inputtext input.login_form_input_box").setValue("1");

        // <div>Hello, qa.guru!</div>
        $(byText("Hello, qa.guru!"));
        $(withText("Hello, qa.guru!"));
        $x("//*[contains(text(),'Hello, qa.guru!')]");
    }
}
