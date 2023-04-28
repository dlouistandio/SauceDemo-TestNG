package com.qa.PageObjects;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
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

    @Step
    public void loginUser(String user, String pass){
        log().info("Username Is " + user);
        usernameField.sendKeys(user);
        log().info("Password Is " + pass);
        passwordField.sendKeys(pass);
        loginButton.click();
    }

    @Step
    public String getAlertText(){
        log().info("Get alert text");
        return alertText.getText();
    }

}
