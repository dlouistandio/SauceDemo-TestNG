package TestCases;

import PageObjects.ProductPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUser extends BaseTest {

    @Test
    public void loginValidUser(){
        ProductPage productPage = loginPage.loginUser("standard_user","secret_sauce");
        String headerText = productPage.getHeaderText();
        Assert.assertEquals(headerText, "Products");
    }

    @Test
    public void loginInvalidUser(){
        loginPage.loginUser("standard_user","invalid");
        String alertText = loginPage.getAlertText();
        Assert.assertEquals(alertText, "Epic sadface: Username and password dos not match any user in this service");
    }

}
