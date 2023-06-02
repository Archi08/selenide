import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ResetPasswordPage {

    private SelenideElement header = $(byTagName("h6"));

    public void checkResetPasswordTittle(){
        header.shouldBe(Condition.visible);
        header.shouldHave(text("Reset Password"));
    }


    public void urlIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().
                getCurrentUrl().contains("requestPasswordResetCode"));
    }
}
