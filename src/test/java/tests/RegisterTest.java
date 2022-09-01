package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.RegisterPage;


import java.util.Random;

import static org.testng.Assert.*;

@Log4j2
public class RegisterTest extends BaseTest {

    @Test(description = "Positive register with correct user data")
    public void correctUnregisteredData() {
        loginSteps.register(email);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData(firstName, lastName, "", password);
        assertTrue(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }
}