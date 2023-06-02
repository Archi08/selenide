import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL =  PropertiesLoader.loadProperties("url");

    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }


    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    DashboardPage dashboardPage = new DashboardPage();
}
