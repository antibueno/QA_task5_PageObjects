package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement dateInput = $("#dateOfBirthInput");
    private SelenideElement monthInput = $(".react-datepicker__month-select");
    private SelenideElement yearInput = $(".react-datepicker__year-select");
    private SelenideElement dayInput = (SelenideElement) $$(".react-datepicker__day");


    public void setDate(String day, String month, String year) {
        dateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.find(String.valueOf(Condition.text(day))).click();
    }
}
