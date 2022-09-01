package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2
public class RegisterPage extends LoginPage {
    public static final By CREATE_ACCOUNT = By.id("submitAccount");
    public static final By MALE_GENDER = By.id("id_gender1");
    public static final By FEMALE_GENDER = By.id("id_gender2");
    public static final By FIRST_NAME = By.id("customer_firstname");
    public static final By LAST_NAME = By.id("customer_lastname");
    public static final By EMAIL = By.id("email");
    public static final By PASSWORD = By.id("passwd");
    public static final By NEWS = By.id("uniform-newsletter");
    public static final By SPECIAL_OPTIONS = By.id("uniform-optin");
    public static final By DAY = By.id("uniform-days");
    public static final By MONTH = By.id("uniform-months");
    public static final By YEAR = By.id("cuselFrame-years");
    public static final By FIRSTNAME_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]");
    public static final By LASTNAME_ERROR = By.xpath("\"//li[text()='lastname is required.\n']\"");
    public static final By EMAIL_ERROR = By.xpath("\"//li[text()='email is required.\n']\"");
    public static final By REGISTERED_EMAIL_ERROR = By.xpath("\"//li[text()='An account using this email address has already been registered.']\"");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRegisterPageOpened() {
        return waitForElement(CREATE_ACCOUNT);
    }

    @Step("Register with correct data")
    public RegisterPage registerData(String firstName, String lastName, String email, String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_ACCOUNT));
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(EMAIL).clear();
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(newPassword);
        driver.findElement(CREATE_ACCOUNT).click();
        return this;

    }

    @Step("checkboxes")
    public RegisterPage registerCheckBoxes() {
    driver.findElement(MALE_GENDER).click();
    driver.findElement(NEWS).click();
    driver.findElement(SPECIAL_OPTIONS).click();
    return this;
    }

    public String getFirstNameError() {
        return driver.findElement(FIRSTNAME_ERROR).getText();
    }

    public String getLastNameError() {
        return driver.findElement(LASTNAME_ERROR).getText();
    }

    public String getEmailError() {
        return driver.findElement(EMAIL_ERROR).getText();
    }

    public String getRegisterEmailError() {
        return driver.findElement(REGISTERED_EMAIL_ERROR).getText();
    }

}