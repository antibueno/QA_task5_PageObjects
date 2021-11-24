package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static pages.TestData.myState;

public class StateComponent {
    private static SelenideElement stateInput = $("#state"),
    cityInput = $("#city");

    public void setStateInput(String value){
        stateInput.click();
        $(byText(value)).click();
    }

    public void setCityInput(String value) {
        cityInput.click();
        $(byText(value)).click();
    }
}
