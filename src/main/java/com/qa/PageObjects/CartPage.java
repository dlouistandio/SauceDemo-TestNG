package com.qa.PageObjects;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends GeneralObject{
    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement cartPageHeader;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    public Boolean validateCartList(String productName){
        waitElementsDisplay(cartPageHeader);
        Boolean match = productTitles.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }

    public void clickCheckoutBtn(){
        checkoutButton.click();
    }


}
