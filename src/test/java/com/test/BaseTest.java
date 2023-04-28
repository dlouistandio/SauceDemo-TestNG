package com.test;

import com.qa.PageObjects.CartPage;
import com.qa.PageObjects.LoginPage;
import com.qa.PageObjects.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest{
    public WebDriver driver;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;

    public WebDriver initDriver() throws IOException {
        Properties props = new Properties();
        DesiredCapabilities caps = new DesiredCapabilities();
        WebDriver driver = null;

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/GlobalData.properties");
        props.load(fis);
        String browserName = props.getProperty("browser");
        String webUrl = props.getProperty("url");

        if (browserName.equalsIgnoreCase("chrome")){
            caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(webUrl);
        return driver;
    }


    @BeforeMethod(alwaysRun = true)
    public void launchApp() throws IOException {
        driver = initDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
