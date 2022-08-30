package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountPage;

import java.util.Random;

import static org.testng.Assert.*;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Positive login with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginSteps.login(user, password);
        assertTrue(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }

    @Test(description = "Empty password")
    public void emptyPassword() {
        loginSteps.login(user, password1);
        assertEquals(loginPage.getPasswordError(), "Password is required.");
    }

    @Test(description = "userName is empty")
    public void emptyUserName() {
        loginSteps.login(user1, password);
        assertEquals(loginPage.getNameError(), "An email address required.");
    }

    @Test(description = "random userName and password")
    public void randomUserNameAndPassword() {
        Random random = new Random();
        String name = random.toString();
        String password = random.toString();
        loginSteps.login(name, password);
        assertFalse(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }

    @Test(description = "Wrong password")
    public void wrongPassword() {
        loginSteps.login(user, "123");
        assertEquals(loginPage.getWrongPasswordError(), "Invalid password.");
    }

    @Test(description = "Wrong name")
    public void wrongName() {
        loginSteps.login("tiamat136", password);
        assertEquals(loginPage.getWrongNameError(), "Invalid email address.");
    }

    @Test(description = "E-mail without account")
    public void emailWithoutAccount() {
        loginSteps.login("tiamat136@yandex.ru", password);
        assertEquals(loginPage.getNotRelevantDateError(), "Authentication failed.");
    }
}