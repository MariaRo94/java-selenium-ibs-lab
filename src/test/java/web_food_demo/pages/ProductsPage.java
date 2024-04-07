package web_food_demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    By lstProducts = By.xpath("//table[@class='table']//tbody/tr/td");
    By product_add = By.xpath(".//button[contains(@class,'btn btn-primary')]");
    By element_type = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[2]/select");
    By element_exotic = By.id("exotic");

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(lstProducts);
    }

    public ProductsPage add() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(product_add))
                .click();
        return this;
    }

    public ProductsPage placeAnItem(String kind, boolean isExotic, String productToAdd) throws InterruptedException {
        Thread.sleep(100);
        Select dropdown = new Select(driver.findElement(element_type));
        dropdown.selectByVisibleText(kind);

        if (isExotic) {
            Thread.sleep(100);
            WebElement checkbox = driver.findElement(element_exotic);
            checkbox.click();
        }

        Thread.sleep(100);

        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(By.id("name"))) //
                .sendKeys(productToAdd);

        Thread.sleep(100);

        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(By.id("save"))) //
                .click();


        Thread.sleep(2000);

        return this;
    }

    public ProductsPage removeAll() throws InterruptedException {

        Thread.sleep(100);

        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/ul/li[2]")))
                .click();

        Thread.sleep(100);

        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/ul/li[2]/div/a[5]")))
                .click();

        Thread.sleep(100);

        return this;
    }
}
