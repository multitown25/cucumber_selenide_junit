package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import java.io.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepDefs {
    @Given("^open kpfu\\.ru$")
    public void openKpfuRu() {
        open("https://kpfu.ru");
    }

    // нажать на кнопку "Личный кабинет"
    @When("press button by class {string}")  // or @When("^press button by class \"([^\"]*)\"$") - doesnt matter
    public void pressButtonByClass(String className) { // lk-link
        $(byClassName(className)).click();
    }

    // ввести логин и пароль
    @And("type to input with name {string} text: {string}")
    public void typeToInputWithNameText(String name, String text) {
        $(By.name(name)).setValue(text); // p_login // p_pass
    }

    // нажать на кнопку "Отправить"
    @And("press element with value {string}")
    public void pressElementWithValue(String value) {
        $(byValue(value)).pressEnter(); // Отправить
    }

    @Then("element with name {string} should exist")
    public void elementWithNameShouldExist(String name) {
        $(byText(name)).should(Condition.exist); // Выход
    }

    @Given("^open shelly.kpfu.ru/e-ksu/main_blocks.startpage$")
    public void openStartPage() {
        open("https://shelly.kpfu.ru/e-ksu/main_blocks.startpage");
    }

    @When("press button by text {string}")
    public void pressButtonByText(String text) {
        $(byText(text)).click();

    }

    @Then("element by text {string} should exist")
    public void elementByTextShouldExist(String text) {
        $(byText(text)).should((Condition.exist));
    }


    @When("press button by title {string}")
    public void pressButtonByTitle(String title) {
        $(byTitle(title)).click();
    }

    @Then("element by class {string} should have text {string}")
    public void elementByClassShouldHaveText(String value, String text) {
        $(byClassName(value)).shouldHave(Condition.exactText(text));
    }


    @Given("^open shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.offor_document\\?p_menu=14$")
    public void openPageWithDocs() {
        open("https://shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.offor_document?p_menu=14");
    }

    @And("press button to download some file by xPath {string} should have text {string}")
    public void pressButtonToDownloadSomeFileByXPathShouldHaveText(String xPath, String text) {
        try {
            File doc = $(byXpath(xPath)).download(); // "//*[@id=\"tab1\"]/p[3]/a"
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(doc), "windows-1251"));
            String line;
            String result = "Строка " + text + " не содержится в документе";
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line.replaceAll("<[^>]*>", ""));
                if (line.contains(text)) {
                    result = "Строка " + text + " содержится в документе";
                    break;
                }
            }
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Given("^open shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa$")
    public void openShellyKpfuRuEKsuNew_stud_personalStud_anketa() {
        open("https://shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa");
    }

    @When("press button to download new photo")
    public void pressButtonToDownloadNewPhoto() {
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).should(Condition.exist).click();
        $(byClassName("blue-btn")).shouldHave(Condition.exactText("Да")).click();
        $(byName("p_file")).uploadFile(new File("src/test/resources/newPhoto.jpg"));
        $(byValue(" Добавить фото (до 5 Мб)")).click();
    }

    @Then("element by class {string} should exist")
    public void elementByClassShouldExist(String text) {
        $(byClassName(text)).should(Condition.exist);
    }
}
