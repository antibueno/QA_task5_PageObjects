package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators & elements
    private static final String FORM_TITLE = "Student Registration Form";
    private static SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $(".practice-form-wrapper"),
            lastNameInput = $("#lastName");


    //actions
    public static void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public static RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }


    public static void validation(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));

    }
}
