package com.test.TestCase;

import com.test.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Swag Labs")
@Feature("Login")
public class LoginUser extends BaseTest {

    @Story("Login valid user")
    @Link(name = "allure", type = "mylink")
    @Issue("1")
    @TmsLink("TMS Link")
    @Description("Login User with valid id and password")
    @Test( description = "Login valid user", groups = { "login" })
    public void loginValidUser() {
        loginPage.loginUser("standard_user","secret_sauce");
        String headerText = productPage.getHeaderText();
        Assert.assertEquals(headerText, "Products");
    }

    @Story("Login invalid user")
    @Link(name = "allure", type = "mylink")
    @Issue("1")
    @TmsLink("TMS Link")
    @Description("Login User with invalid id and password")
    @Test( description = "Login invalid user", groups = { "login" })
    public void loginInvalidUser(){
        loginPage.loginUser("standard_user","invalid");
        String alertText = loginPage.getAlertText();
        Assert.assertEquals(alertText, "Epic sadface: Username and password do not match any user in this service");
    }

}
