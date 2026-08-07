package com.marriott.ui.pages;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignInPage {

    private WebDriver driver;
    private MarriotBonVoyDashboard dashboard;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        
    }

    @BeforeMethod
    public void navigateToHomePage() {
        driver.get("https://www.marriott.com/");
        dashboard = new MarriotBonVoyDashboard(driver);
    }

    @Test(description = "Validate Marriott BonVoy login functionality")
    public void verifyLoginFunctionality() {

        String email = "testuser@gmail.com";
        String password = "Test@123";

        dashboard.loginToMarriottBonVoy(email, password);

        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    



    
}
