package PageObjects;

import Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralObject {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElement alertText;

    public ProductPage loginUser(String user, String pass){
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }

    public String getAlertText(){
        return alertText.getText();
    }

}
