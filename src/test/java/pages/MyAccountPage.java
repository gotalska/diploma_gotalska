package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


@Log4j2
public class MyAccountPage extends MainPage {
    public static final By USER_TITLE = By.cssSelector(".logout");
    public static final By PERSONAL_INFORMATION = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[5]/a");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(USER_TITLE);
    }

    @Override
    public boolean isRegisterPageOpened() {
        return false;
    }

    @Step("Open my account")
    public void openMyAccount() {
        driver.get(startUrl + "my-account");
        PageFactory.initElements(driver, this);
    }

    @Step("Open Personal Information")
    public void openPersonalInfo() {
        driver.findElement(PERSONAL_INFORMATION).click();
    }
}