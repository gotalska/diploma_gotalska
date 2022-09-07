package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.compress.harmony.archive.internal.nls.Messages.getString;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


@Log4j2
public class PersonalInfoPage extends MainPage {
    public static final By FIRST_NAME_FIELD = By.id("firstname");
    public static final By LAST_NAME_FIELD = By.id("lastname");
    public static final By EMAIL_FIELD = By.id("email");

    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public boolean isRegisterPageOpened() {
        return false;
    }

    public boolean requestFirstName(String firstname) {
        String valueFirstName = driver.findElement(FIRST_NAME_FIELD).getAttribute("value");
        assertEquals(firstname, valueFirstName);
        return false;
    }

    public boolean requestLastName(String lastname) {
        String valueLastName = driver.findElement(LAST_NAME_FIELD).getAttribute("value");
        assertEquals(lastname, valueLastName);
        return false;
    }

    public boolean requestEmail(String user) {
        String valueEmail = driver.findElement(EMAIL_FIELD).getAttribute("value");
        assertEquals(user, valueEmail);
        return false;
    }

}
