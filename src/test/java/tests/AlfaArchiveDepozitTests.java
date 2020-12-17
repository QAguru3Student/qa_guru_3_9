package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AlfaArchiveDepozitTests {

    @Test
    @DisplayName("Checking the number of deposits")
    void AlfaArchiveDepozitTest() {
        System.out.println(System.getProperty("java.library.path"));
        step("Open AlfaBank site", () -> {
            open("https://alfabank.ru/");
        });

        step("Go to deposits", () -> {
            $(byText("Вклады")).click();
            $("body").shouldHave(text("Накопительные продукты"));
        });

        step("Go to the list of deposits", () -> {
            $$(byText("Депозиты")).find(visible).parent().click();
            $$(byText("Архивные счета и депозиты")).find(visible).parent().click();
            $$(byText("Депозиты")).find(visible).parent().click();
            $("body").shouldHave(text("Вклады"));
        });

        step("Сheck the number of deposits", () -> {
            $$("div[data-widget-name='CatalogCard']").shouldHaveSize(5);
        });
    }
}
