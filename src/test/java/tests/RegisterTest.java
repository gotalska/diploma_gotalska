package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;


import java.util.Random;

import static org.testng.Assert.*;

@Log4j2
public class RegisterTest extends BaseTest {

    @Test(description = "Positive login with correct user data")
    public void correctUnregisteredEmail() {
        loginSteps.register(user1);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
    }

}