package steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Log in with: user and password")
    public void login(String user, String password) {
        loginPage.openPage();
        assertTrue(loginPage.isPageOpened(), "page isn't open");
        loginPage.login(user, password);
    }

    @Step("register new user")
    public void register(String user1) {
        loginPage.openPage();
        assertTrue(loginPage.isPageOpened(), "page isn't open");
        loginPage.register(user1);
    }
}