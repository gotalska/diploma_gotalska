package pages;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

@Log4j2
public abstract class MainPage {


    WebDriver driver;
    WebDriverWait wait;
    String startUrl = "http://prestashop.qatestlab.com.ua/en/";


    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract boolean isPageOpened();

    boolean waitForElement(By locator) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public abstract boolean isRegisterPageOpened();
}