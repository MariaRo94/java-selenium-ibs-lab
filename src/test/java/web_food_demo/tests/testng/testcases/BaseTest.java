package web_food_demo.tests.testng.testcases;

import automation.enums.Browsers;
import automation.selenium.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web_food_demo.config.EnvironmentVariables;
import web_food_demo.pages.ProductsPage;

import java.time.Duration;

public abstract class BaseTest {

    // TODO: Externalise config data
    ProductsPage productsPage;
    protected WebDriver driver;
    private Browsers browser = Browsers.CHROME;
    private String url = "http://localhost:8080/food";

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.launch(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);

        productsPage = new ProductsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}