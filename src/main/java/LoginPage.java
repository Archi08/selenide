import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement usernameField =  $(byCssSelector("[name='username']"));

    private SelenideElement passwordField =  $(byAttribute("placeholder","Password"));

    private SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement errorMessage = $x("//p[contains(@class, 'oxd-alert-content-text')]");

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot"));

    private SelenideElement logo = $(byAttribute("alt", "company-branding"));

    private SelenideElement credSection = $(byClassName("orangehrm-demo-credentials"));
    public void enterUsername(String usernameValue){
        usernameField.shouldBe(visible,Duration.ofSeconds(10));
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue){
        passwordField.setValue(passwordValue);
    }

    public void pushLoginButton(){
        loginButton.click();
    }

    public void invalidCredText(String expectedText){
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(expectedText));
    }

    public void followTheForgotPasswordLink(){
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void logoIsDisplayed(){
        logo.shouldBe(visible);
    }

    //attributeMatching("fileId", ".*12345.*"))
    public void logoImageIsCorrect(){
        logo.shouldHave(attributeMatching("src",
                ".*branding.png.*"));
    }

    public void credSectionIsDisplayed(){
        credSection.shouldBe(visible);
    }

}
