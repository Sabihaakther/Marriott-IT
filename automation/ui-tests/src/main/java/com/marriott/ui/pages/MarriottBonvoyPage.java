package com.marriott.ui.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





   public class MarriottBonvoyPage {

      private WebDriver driver;
    private WebDriverWait wait;

    public MarriottBonvoyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'See Details')]")
    private WebElement seeDetailsButton;

    // REAL Apply Now button from your screenshot
    @FindBy(xpath = "//a[@data-pt-name='cc_apply_now_bound']")
    private WebElement applyNowButton;

    public void clickSeeDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(seeDetailsButton)).click();
    }

    public void clickApplyNow() {

    // 1. Wait for Chase page to load
    wait.until(ExpectedConditions.urlContains("cobrand"));

    // 2. Scroll down to load the button
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");

    // 3. Use the correct locator
    By applyNow = By.xpath("//a[@data-pt-name='cc_apply_now_bound']");

    // 4. Wait for visibility
    wait.until(ExpectedConditions.visibilityOfElementLocated(applyNow));

    WebElement applyNowButton = driver.findElement(applyNow);

    // 5. Scroll into view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyNowButton);

    // 6. Click
    wait.until(ExpectedConditions.elementToBeClickable(applyNowButton)).click();
}
}