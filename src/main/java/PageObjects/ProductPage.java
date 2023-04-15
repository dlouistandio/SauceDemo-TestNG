package PageObjects;

import Components.GeneralObject;
import com.github.dockerjava.api.model.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends GeneralObject {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productPageHeader;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private WebElement products;

    By productName = By.cssSelector(".inventory_item_name");

    By addToCart = By.cssSelector(".btn_inventory");

    public String getHeaderText(){
        return productPageHeader.getText();
    }

    @Step
    public List<WebElement> getProductList(){
        waitElementsDisplay(products);
        return productList;
    }

    @Step
    public WebElement getProductByName(String name){
        WebElement prod = getProductList().stream().filter(products -> products.findElement(productName).getText().equals(name)).findFirst().orElse(null);
        return prod;
    }

    @Step
    public void addProductToCart(String name){
        WebElement prod = getProductByName(name);
        prod.findElement(addToCart).click();
    }

}
