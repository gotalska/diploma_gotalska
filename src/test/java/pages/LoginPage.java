package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2
public class LoginPage extends MainPage {
    public static final By USER_NAME = By.id("email");
    public static final By PASSWORD = By.id("passwd");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"login_form\"]/div/p");
    public static final By ERROR_NAME_MESSAGE = By.xpath("//p[text()='An email address required.']");
    public static final By ERROR_PASSWORD_MESSAGE = By.xpath("//p[text()='Password is required.']");
    public static final By ERROR_NOT_RELEVANT_DATA = By.xpath("//p[text()='Authentication failed.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(LOGIN_BUTTON);
    }

    @Step("Opening login page")
    public void openPage() {
        driver.get(startUrl + "authentication");
        PageFactory.initElements(driver, this);
    }


    @Step("Login by user '{user}' with password '{password}'")
    public LoginPage login(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME));
        driver.findElement(USER_NAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).submit();
        return this;


    }

    public String getNameError() {
        return driver.findElement(ERROR_NAME_MESSAGE).getText();
    }

    public String getPasswordError() {
        return driver.findElement(ERROR_PASSWORD_MESSAGE).getText();
    }

    public String getNotRelevantDateError() {
        return driver.findElement(ERROR_NOT_RELEVANT_DATA).getText();
    }

}