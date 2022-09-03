package steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegisterPage;

import static org.testng.Assert.assertTrue;

public class RegisterSteps {
    RegisterPage registerPage;
    LoginPage loginPage;

    public RegisterSteps(WebDriver driver) {
        registerPage = new RegisterPage(driver);
    }
    public void LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("open register page")
    public void register(String user1) {
        loginPage.openPage();
        assertTrue(loginPage.isPageOpened(), "Smth went wrong");
        loginPage.register(user1);
    }
}