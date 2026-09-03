package com.marriott.ui.pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;


public class SpecialOfferPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SpecialOfferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    /*
     * =========================================================
     * LOCATORS
     * =========================================================
     */

    @FindBy(xpath = "//a[@role='menuitem' and @aria-label='Offers']")
    private WebElement specialOffersButton;

    @FindBy(xpath = "//a[contains(text(),'Offers')]")
    private WebElement specialOffersHeading;

    @FindBy(xpath = "//span[contains(text(), 'Shop Marriott')]")
    private WebElement shopMarriottLink;

 // Shop Now button inside the banner (from your screenshot)
    @FindBy(xpath = "//a[contains(text(),'Shop Now')]")
    private WebElement shopNowButton;

      // SHOP link in top navigation (from your screenshot)
    //@FindBy(xpath = "//a[contains(text(),'SHOP')]")
    //private WebElement shopTopNavLink;

   

    /*
     * =========================================================
     * CLICK METHODS
     * =========================================================
     */

    public void clickSpecialOffersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(specialOffersButton)).click();
    }

    public void clickShopMarriottLink() {
        wait.until(ExpectedConditions.elementToBeClickable(shopMarriottLink)).click();
    }

    public void clickShopNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shopNowButton)).click();
    }

    public boolean isSpecialOffersHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(specialOffersHeading)).isDisplayed();
    }

    public boolean isShopNowButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shopNowButton)).isDisplayed();
    }

    public void switchToNewTab() {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}














