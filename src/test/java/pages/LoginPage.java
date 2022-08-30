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
    public static final By REGISTER_NAME = By.id("email_create");
    public static final By PASSWORD = By.id("passwd");
    public static final By LOGIN_BUTTON = By.id("SubmitLogin");
    public static final By REGISTER_BUTTON = By.id("SubmitCreate");

    public static final By CREATE_ACCOUNT = By.id("submitAccount");
    public static final By ERROR_NAME_MESSAGE = By.xpath("//li[text()='An email address required.']");
    public static final By ERROR_PASSWORD_MESSAGE = By.xpath("//li[text()='Password is required.']");
    public static final By ERROR_NOT_RELEVANT_DATA = By.xpath("//li[text()='Authentication failed.']");
    public static final By ERROR_NOT_RELEVANT_PASSWORD = By.xpath("//li[text()='Invalid password.']");
    public static final By ERROR_NOT_RELEVANT_NAME = By.xpath("//li[text()='Invalid email address.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return waitForElement(LOGIN_BUTTON);
    }

    @Override
    public boolean isRegisterPageOpened() {
        return waitForElement(CREATE_ACCOUNT);
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
        driver.findElement(LOGIN_BUTTON).click();
        return this;

    }

    @Step("Open register page")
    public LoginPage register(String user1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_NAME));
        driver.findElement(REGISTER_NAME).sendKeys(user1);
        driver.findElement(REGISTER_BUTTON).click();
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

    public String getWrongNameError() {
        return driver.findElement(ERROR_NOT_RELEVANT_NAME).getText();
    }

    public String getWrongPasswordError() {
        return driver.findElement(ERROR_NOT_RELEVANT_PASSWORD).getText();
    }
}
