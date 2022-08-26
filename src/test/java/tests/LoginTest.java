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

    @Test(description = "password is empty")
    public void emptyPassword() {

        loginPage.openPage();
        loginPage.login(user, "");
        assertEquals(loginPage.getPasswordError(), "Password is required.");

    }

    @Test(description = "userName is empty")
    public void emptyUserName() {
        loginPage.openPage();
        loginPage.login(" ", password);
        assertEquals(loginPage.getNameError(), "Username is required.");
    }

    @Test(description = "random userName and password")
    public void randomUserNameAndPassword() {
        Random random = new Random();
        String name = random.toString();
        String password = random.toString();
        loginPage.openPage();
        loginPage.login(name, password);
        assertFalse(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }


}