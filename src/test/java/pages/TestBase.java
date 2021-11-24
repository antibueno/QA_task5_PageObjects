package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }
}
