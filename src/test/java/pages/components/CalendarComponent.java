package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement dateInput = $("#dateOfBirthInput");
    private final SelenideElement monthInput = $(".react-datepicker__month-select");
    private final SelenideElement yearInput = $(".react-datepicker__year-select");
    private final ElementsCollection dayInput = $$(".react-datepicker__day");


    public void setDate(String day, String month, String year) {
        dateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.find(Condition.text(day)).click();
    }
}
