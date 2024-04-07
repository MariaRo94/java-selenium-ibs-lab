package web_food_demo.tests.testng.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_food_demo.pages.ProductsPage;

import java.util.List;

public class TC02_RemoveProductFromList extends BaseTest {
    String product1 = "Репка";
    String product2 = "Персик";
    String product3 = "Батат";
    String product4 = "Гуава";

    @Test
    public void TC002_RemoveProductFromElementList_VEGETABLE() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeRemoving = productsPage
                .add()
                .placeAnItem("Овощ", false, product1)
                .getProducts();

        int countBeforeRemoving = productItemsBeforeRemoving.size() / 3;

        List<WebElement> productItemsAfterRemoving = productsPage
                .removeAll()
                .getProducts();

        int countAfterRemoving = productItemsAfterRemoving.size() / 3;

        Assert.assertNotEquals(countBeforeRemoving, countAfterRemoving);
    }

    @Test
    public void TC002_RemoveProductFromElementList_FRUIT() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeRemoving = productsPage
                .add()
                .placeAnItem("Фрукт", false, product2)
                .getProducts();

        int countBeforeRemoving = productItemsBeforeRemoving.size() / 3;

        List<WebElement> productItemsAfterRemoving = productsPage
                .removeAll()
                .getProducts();

        int countAfterRemoving = productItemsAfterRemoving.size() / 3;

        Assert.assertNotEquals(countBeforeRemoving, countAfterRemoving);
    }

    @Test
    public void TC002_RemoveProductFromElementList_VEGETABLE_EXOTIC() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeRemoving = productsPage
                .add()
                .placeAnItem("Овощ", false, product3)
                .getProducts();

        int countBeforeRemoving = productItemsBeforeRemoving.size() / 3;

        List<WebElement> productItemsAfterRemoving = productsPage
                .removeAll()
                .getProducts();

        int countAfterRemoving = productItemsAfterRemoving.size() / 3;

        Assert.assertNotEquals(countBeforeRemoving, countAfterRemoving);
    }

    @Test
    public void TC002_RemoveProductFromElementList_FRUIT_EXOTIC() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> productItemsBeforeRemoving = productsPage
                .add()
                .placeAnItem("Овощ", false, product4)
                .getProducts();

        int countBeforeRemoving = productItemsBeforeRemoving.size() / 3;

        List<WebElement> productItemsAfterRemoving = productsPage
                .removeAll()
                .getProducts();

        int countAfterRemoving = productItemsAfterRemoving.size() / 3;

        Assert.assertNotEquals(countBeforeRemoving, countAfterRemoving);
    }
}
