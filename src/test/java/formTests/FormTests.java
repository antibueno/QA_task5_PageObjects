package formTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TestBase;
import static pages.TestData.*;

public class FormTests extends TestBase{

    @BeforeEach
    void beforeEach () {
        registrationPage.openPage();
    }

    @Test
    void registrationFormTests() {
        //test of text inputs
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.fillEmailInput(myEmail);
        registrationPage.setYourGender();
        registrationPage.setPhoneNumber(myNumber);

        //test of calendar
        registrationPage.calendarComponent.setDate("25", "January", "1992");

        //test of subject input
        registrationPage.fillSubjectInput(mySubject);

        //test of hobbies checkboxes
        registrationPage.setHobbiesCheckbox(myHobbie);

        //test of file upload
        registrationPage.uploadPicture();

        //test of current address
        registrationPage.fillMyAddress(myAddress);

        //test of State
        registrationPage.stateComponent.setStateInput(myState);
        //test of City
        registrationPage.stateComponent.setCityInput(myCity);
        //press submit button
        registrationPage.clickSubmitButton();

        //check all values
        registrationPage.validation("Student Name", firstName + " " + lastName);
        registrationPage.validation("Student Email", myEmail);
        registrationPage.validation("Gender", "Male");
        registrationPage.validation("Mobile", myNumber);
        registrationPage.validation("Date of Birth", myBirthDate);
        registrationPage.validation("Subjects", mySubject);
        registrationPage.validation("Hobbies", myHobbie);
        registrationPage.validation("Picture", myPicture);
        registrationPage.validation("Address", myAddress);
        registrationPage.validation("State and City", myState + myCity);
    }
}