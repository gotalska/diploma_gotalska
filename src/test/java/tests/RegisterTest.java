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
    public void allCorrectUnregisteredData() {
        loginSteps.register(email);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData(firstName, lastName, email, password);
        registerPage.registerCheckBoxes();
        assertTrue(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }

    @Test(description = "Register with only required field: firstname, lastname, email")
    public void allRequiredField() {
        loginSteps.register(user1);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData(firstName, lastName, user1, "");
        assertTrue(new MyAccountPage(driver).isPageOpened(), "smth went wrong");
    }

    @Test(description = "empty First name field")
    public void emptyFirstName() {
        loginSteps.register(user1);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData("", lastName, user1, password);
        registerPage.registerCheckBoxes();
        assertEquals(registerPage.getFirstNameError(), "firstname is required.");
    }

    @Test(description = "empty Last name field")
    public void emptyLastName() {
        loginSteps.register(user1);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData(firstName, "", user1, password);
        registerPage.registerCheckBoxes();
        assertEquals(registerPage.getFirstNameError(), "firstname is required.");
    }

    @Test(description = "empty Last name field")
    public void emptyEmail() {
        loginSteps.register(user1);
        assertTrue(new RegisterPage(driver).isRegisterPageOpened(), "smth went wrong");
        registerPage.registerData(firstName, lastName, "", password);
        registerPage.registerCheckBoxes();
        assertEquals(registerPage.getFirstNameError(), "firstname is required.");
    }
}