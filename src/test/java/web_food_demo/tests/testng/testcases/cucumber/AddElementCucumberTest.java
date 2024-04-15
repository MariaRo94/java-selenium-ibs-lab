package web_food_demo.tests.testng.testcases.cucumber;

import automation.enums.Browsers;
import automation.selenium.BrowserFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import web_food_demo.config.EnvironmentVariables;
import web_food_demo.pages.ProductsPage;
import web_food_demo.tests.testng.testcases.BaseTest;

import java.time.Duration;
import java.util.List;

public class AddElementCucumberTest extends BaseTest {
    String product1 = "Репка";
    Integer countBeforeAdding;
    Integer countAfterAdding;

    ProductsPage productsPage;


    public AddElementCucumberTest() throws InterruptedException {

        driver = BrowserFactory.launch(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/food");

        productsPage = new ProductsPage(driver);


        Thread.sleep(200);
    }

    @When("I check elements before adding")
    public void checkElement() {
        List<WebElement> productItemsBeforeAdding = productsPage.getProducts();
        countBeforeAdding = productItemsBeforeAdding.size() / 3;
    }

    @When("I check elements after adding")
    public void addElement() throws InterruptedException {
        List<WebElement> productItemsAfterAdding = productsPage
                .add()
                .placeAnItem("Овощ", false, product1)
                .getProducts();
        countAfterAdding = productItemsAfterAdding.size() / 3;
    }

    @Then("Elements are not equal")
    public void assertThatPageOpens() {
        Assert.assertNotEquals(countBeforeAdding, countAfterAdding);
    }
}
