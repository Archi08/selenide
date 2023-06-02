import org.junit.Test;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest extends BaseTest{

    private String userAdmin = PropertiesLoader.loadProperties("userAdmin");
    private String adminPassword = PropertiesLoader.loadProperties("adminPassword");

    @Test
    public void successLogin() {
        loginPage.enterUsername(userAdmin);
        loginPage.enterPassword(adminPassword);
        loginPage.pushLoginButton();
        dashboardPage.correctHeaderText();

    }

    @Test
    public void invalidPassword(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin");
        loginPage.pushLoginButton();
        loginPage.invalidCredText("Invalid credentials");
    }


    public void emptyInputFields(){
        //Leave password and username empty
        //check error messages "Required"
    }

    @Test
    public void forgotPassword(){
        loginPage.followTheForgotPasswordLink();
        resetPasswordPage.checkResetPasswordTittle();
        resetPasswordPage.urlIsCorrect();
    }


    @Test
    public void elementsAreVisible(){
        //logo is displayed
        loginPage.logoIsDisplayed();
        //credentionals section is displayed
        loginPage.credSectionIsDisplayed();
        loginPage.logoImageIsCorrect();
    }

    @Test
    public void checkTitlesWidget() {
        loginPage.enterUsername(userAdmin);
        loginPage.enterPassword(adminPassword);
        loginPage.pushLoginButton();
        String[] namesTitles = {"Time at Work", "My Actions", "Quick Launch", "Buzz Latest Posts",
                "Employees on Leave Today", "Employee Distribution by Sub Unit", "Employee Distribution by Location"};
        dashboardPage.checkAllWidgetTitle(namesTitles);
    }
}
