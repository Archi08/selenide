import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement header =  $(byTagName("h6"));
    private ElementsCollection widgetCollection =  $$(byClassName("oxd-sheet"));

    public void correctHeaderText(){
        header.shouldBe(visible);
        header.shouldHave(text("Dashboard"));
    }

    public void checkFirstWidgetTitle() {
        widgetCollection.first().$(byClassName("oxd-text")).shouldHave(exactText("Time at work"));
    }

    public void checkAllWidgetTitle(String[] titleName) {
        Map<Integer, String> expectedNames = new HashMap<>();
        for (int i = 0; i < titleName.length; i++) {
            expectedNames.put(i, titleName[i]);
        }
        for (Map.Entry<Integer, String> entry : expectedNames.entrySet()) {
            int widgetIndex = entry.getKey();
            String expectedName = entry.getValue();
            widgetCollection.get(widgetIndex).$(byClassName("oxd-text")).shouldHave(exactText(expectedName));
        }
    }
}
