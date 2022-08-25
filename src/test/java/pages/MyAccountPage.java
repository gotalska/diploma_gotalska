package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


@Log4j2
public class MyAccountPage extends MainPage {
    public static final By USER_TITLE = By.xpath("//*[@id=\"center_column\"]/h1");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(USER_TITLE);
    }

    @Step("Open my account")
    public void openMyAccount() {
        driver.get(startUrl + "my-account");
        PageFactory.initElements(driver, this);
    }
}