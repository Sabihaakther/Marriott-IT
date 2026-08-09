package com.marriott.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@role='link' and normalize-space()='Activate online account']")
    private WebElement activateOnlineAccountLink;

    public ActivateOnlineAccountPage clickActivateOnlineAccount() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        activateOnlineAccountLink
                )
        ).click();

        return new ActivateOnlineAccountPage(driver);
    }


    /*
     * Optional validation method
     */
    public boolean isActivateOnlineAccountLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOf(
                        activateOnlineAccountLink
                )
        ).isDisplayed();
    }
      
}








        
