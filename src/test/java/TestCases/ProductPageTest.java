package TestCases;

import PageObjects.ProductPage;
import Utils.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Swag Labs")
@Feature("Checkout")
public class ProductPageTest extends BaseTest {

    @Story("Add Item to cart")
    @Link(name = "allure", type = "mylink")
    @Issue("12")
    @TmsLink("TMS Link")
    @Description("User add sauce lab jacket to cart")
    @Test( description = "Choose Sauce Labs Jacket")
    public void checkOutProduct() throws InterruptedException {
        ProductPage productPage = loginPage.loginUser("standard_user", "secret_sauce");
        List<WebElement> products = productPage.getProductList();
        productPage.addProductToCart("Sauce Labs Fleece Jacket");
        Thread.sleep(10000);
    }
}
