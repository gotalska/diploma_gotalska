package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import steps.LoginSteps;
import utils.PropertyReader;

import java.time.Duration;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {


    WebDriver driver;
    LoginPage loginPage;
    LoginSteps loginSteps;
    String user = System.getProperty("user", PropertyReader.getProperty("tiamat136@gmail.com"));
    String password = System.getProperty("password", PropertyReader.getProperty("123456"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (System.getProperty("browser", "chrome").equalsIgnoreCase("chrome")) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (System.getProperty("headless", "false").equals("true"))
                    options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("EDGE")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("Opera")) {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (System.getProperty("browser", "chrome").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            testContext.setAttribute("driver", driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

        user = System.getProperty("user", PropertyReader.getProperty("tiamat136@gmail.com"));
        password = System.getProperty("password", PropertyReader.getProperty("123456"));

        loginPage = new LoginPage(driver);
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}