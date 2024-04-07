package web_food_demo.tests.testng.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import web_food_demo.pages.ProductsPage;

import java.util.List;

public class TC01_AddProductToList extends BaseTest {

    String product1 = "Репка";
    String product2 = "Персик";
    String product3 = "Батат";
    String product4 = "Гуава";

    @BeforeTest
    public void inti() throws InterruptedException {
        Thread.sleep(200);
    }

    @Test
    public void TC001_AddToCart_NOT_EXOTIC_VEGETABLE() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeAdding = productsPage.getProducts();
        int countBeforeAdding = productItemsBeforeAdding.size() / 3;

        List<WebElement> productItemsAfterAdding = productsPage
                .add()
                .placeAnItem("Овощ", false, product1)
                .getProducts();

        int countAfterAdding = productItemsAfterAdding.size() / 3;

        Assert.assertNotEquals(countBeforeAdding, countAfterAdding);
    }

    @Test
    public void TC002_AddToCart_NOT_EXOTIC_FRUIT() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeAdding = productsPage.getProducts();
        int countBeforeAdding = productItemsBeforeAdding.size() / 3;

        List<WebElement> productItemsAfterAdding = productsPage
                .add()
                .placeAnItem("Фрукт", false, product2)
                .getProducts();

        int countAfterAdding = productItemsAfterAdding.size() / 3;

        Assert.assertNotEquals(countBeforeAdding, countAfterAdding);
    }

    @Test
    public void TC003_AddToCart_EXOTIC_VEGETABLE() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeAdding = productsPage.getProducts();
        int countBeforeAdding = productItemsBeforeAdding.size() / 3;

        List<WebElement> productItemsAfterAdding = productsPage
                .add()
                .placeAnItem("Овощ", true, product3)
                .getProducts();

        int countAfterAdding = productItemsAfterAdding.size() / 3;

        Assert.assertNotEquals(countBeforeAdding, countAfterAdding);
    }

    @Test
    public void TC004_AddToCart_EXOTIC_FRUIT_Checkout() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeAdding = productsPage.getProducts();
        int countBeforeAdding = productItemsBeforeAdding.size() / 3;

        List<WebElement> productItemsAfterAdding = productsPage
                .add()
                .placeAnItem("Фрукт", true, product4)
                .getProducts();

        int countAfterAdding = productItemsAfterAdding.size() / 3;

        Assert.assertNotEquals(countBeforeAdding, countAfterAdding);
    }
}
