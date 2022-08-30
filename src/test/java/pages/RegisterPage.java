package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class RegisterPage extends LoginPage {
    public static final By CREATE_ACCOUNT = By.id("submitAccount");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRegisterPageOpened() {
        return waitForElement(CREATE_ACCOUNT);
    }

}