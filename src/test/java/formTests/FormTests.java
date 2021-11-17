package formTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObjects.RegistrationPage;
import pageObjects.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static pageObjects.RegistrationPage.typeLastName;

public class FormTests {

    @BeforeEach
    void beforeEach () {
    RegistrationPage.openPage();
    }

    @BeforeAll
    static void beforeALl () {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        //resources
        String firstName = "Denis";
        String lastName = "Kananykhin";
        String myEmail = "useremail@test.com";
        String myNumber = "1234567891";
        String myBirthDate = "25 January,1992";
        String mySubject = "Accounting";
        String myHobbies = "Sports, Music";
        String myPicture = "cat.png";
        String myAddress = "somewhere in Syberia";
        String myStateAndCity = "NCR Delhi";

        //test of text inputs
        RegistrationPage.typeFirstName(firstName)
                    .typeLastName(lastName);
        $(byId("userEmail")).setValue(myEmail);
        $(byText("Male")).click();
        $(byId("userNumber")).setValue(myNumber);

        //test of calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1992");
        $$(".react-datepicker__day").find(Condition.text("25")).click();

        //test of subject input
        $(byId("subjectsInput")).setValue("Acc").pressEnter();

        //test of hobbies checkboxes
        $(byText("Sports")).click();
        $(byText("Music")).click();

        //test of file upload
        $("#uploadPicture").uploadFromClasspath("cat.png");

        //test of current address
        $(byId("currentAddress")).setValue(myAddress);
        //test of State
        $("#state").click();
        $(byText("NCR")).click();
        //test of City
        $("#city").click();
        $(byText("Delhi")).click();
        //press submit button
        $("#submit").click();

        //check all values
        RegistrationPage.validation("Student Name", firstName + " " + lastName);
        RegistrationPage.validation("Student Email", myEmail);
        RegistrationPage.validation("Gender", "Male");
        RegistrationPage.validation("Mobile", myNumber);
        RegistrationPage.validation("Date of Birth", myBirthDate);
        RegistrationPage.validation("Subjects", mySubject);
        RegistrationPage.validation("Hobbies", myHobbies);
        RegistrationPage.validation("Picture", myPicture);
        RegistrationPage.validation("Address", myAddress);
        RegistrationPage.validation("State and City", myStateAndCity);

    }


}