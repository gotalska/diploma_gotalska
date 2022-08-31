package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    public static final By FIRSTNAME_ERROR = By.xpath("\"//li[text()='firstname is required.\n']\"");
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

}