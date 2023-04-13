package TestCases;

import PageObjects.ProductPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest {

    @Test
    public void checkOutProduct() throws InterruptedException {
        ProductPage productPage = loginPage.loginUser("standard_user", "secret_sauce");
        List<WebElement> products = productPage.getProductList();
        productPage.addProductToCart("Sauce Labs Fleece Jacket");
        Thread.sleep(10000);
    }
}
