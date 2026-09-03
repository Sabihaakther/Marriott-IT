package com.marriott.ui.pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class MarriottCreditCardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MarriottCreditCardPage(WebDriver driver) {
        this.driver = driver;
       
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    // ============================
    // PUBLIC LOCATOR FOR ASSERTS
    // ============================
    public static final By FIRST_NAME_LOCATOR = By.id("firstName");

    // ============================
    // DASHBOARD LOCATORS
    // ============================
    private By seeDetailsButton =
            By.xpath("//a[contains(.,'See Details')]");

    // ============================
    // APPLY NOW LOCATOR
    // ============================
    private By applyNowButton =
            By.xpath("//a[@data-pt-name='cc_apply_now_bound']");

    // ============================
    // FORM LOCATORS
    // ============================
    private By firstNameField = FIRST_NAME_LOCATOR;
    private By lastNameField = By.id("lastName");
    private By addressField = By.id("address");
    private By cityField = By.id("city");
    private By stateDropdown = By.id("state");
    private By zipField = By.id("zipCode");
    private By phoneField = By.id("phoneNumber");
    private By emailField = By.id("emailAddress");
    private By incomeField = By.id("annualIncome");
    private By employmentDropdown = By.id("employmentStatus");

    private By submitButton =
            By.xpath("//button[contains(.,'Submit')]");

    // ============================
    // ACTION METHODS
    // ============================

    public void clickSeeDetails() {
        WebElement seeDetails = wait.until(
                ExpectedConditions.elementToBeClickable(seeDetailsButton));
        seeDetails.click();
    }

    public void clickApplyNow() {
        WebElement applyNow = wait.until(
                ExpectedConditions.elementToBeClickable(applyNowButton));
        applyNow.click();
    }

    // ============================
    // CORRECT IFRAME SWITCHING
    // ============================

    public void switchToCorrectIframe() {
        wait.until(driver -> {
            for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {
                String src = iframe.getAttribute("src");
                if (src != null && src.contains("apply")) {
                    driver.switchTo().frame(iframe);
                    return true;
                }
            }
            return false;
        });
    }

    // ============================
    // FORM METHODS
    // ============================

    public void fillFirstName(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value);
    }

    public void fillLastName(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(value);
    }

    public void fillAddress(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(value);
    }

    public void fillCity(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(value);
    }

    public void selectState(String value) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        dropdown.sendKeys(value);
    }

    public void fillZip(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipField)).sendKeys(value);
    }

    public void fillPhone(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(value);
    }

    public void fillEmail(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(value);
    }

    public void fillIncome(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(incomeField)).sendKeys(value);
    }

    public void selectEmploymentStatus(String value) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(employmentDropdown));
        dropdown.sendKeys(value);
    }

    public void scrollToSubmitButton() {
        WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", submit);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
    }
}

    


    










