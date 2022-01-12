package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //components
    public CalendarComponent calendarComponent = new CalendarComponent();
    public StateComponent stateComponent = new StateComponent();

    //locators & elements
    private static final String FORM_TITLE = "Student Registration Form";
    private static final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderButton = $(byText("Male")),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbieCheckbox = $(byText("Music")),
            fileUploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit");

//.setValue(myNumber);
   // public CalendarComponent calendar = new CalendarComponent();

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void fillEmailInput(String value) {
        userEmailInput.setValue(value);
    }

    public void setYourGender() {
        genderButton.click();
    }

    public void setPhoneNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void fillSubjectInput(String value) {
        subjectsInput.setValue(value).pressEnter();
    }

    public void setHobbiesCheckbox(String value) {
        hobbieCheckbox.setValue(value).click();
    }

    public void uploadPicture(){
        fileUploadInput.uploadFromClasspath("cat.png");
    }

    public void fillMyAddress(String value){
        addressInput.setValue(value);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    //потом валидацию перенести в отдельный компонент
    public void validation(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));

    }
}
