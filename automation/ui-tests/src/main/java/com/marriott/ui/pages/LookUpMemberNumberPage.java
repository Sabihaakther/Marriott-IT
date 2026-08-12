package com.marriott.ui.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LookUpMemberNumberPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LookUpMemberNumberPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }


    /*
     * =========================================================
     * PAGE ELEMENTS
     * =========================================================
     */

     
    @FindBy(id = "input-Email")
    private WebElement emailAddressField;

    @FindBy(id = "input-firstName")
    private WebElement lookupfirstNameField;

    @FindBy(id = "input-lastName")
    private WebElement lookuplastNameField;

    @FindBy(xpath = "//div[text()='Submit']")
    private WebElement submitButton;

     @FindBy(xpath = "//u[text()='Look up']")
    private WebElement lookUpMemberNumberLink;


    /*
     * =========================================================
     * PAGE VALIDATION METHODS
     * =========================================================
     */

    public boolean isEmailAddressFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOf(emailAddressField)
        ).isDisplayed();
    }

    public boolean isLookupFirstNameFieldDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOf(lookupfirstNameField)
        ).isDisplayed();
    }

    public boolean isLookupLastNameFieldDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOf(lookuplastNameField)
        ).isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOf(submitButton)
        ).isDisplayed();
    }

    public boolean isSubmitButtonEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOf(submitButton)
        ).isEnabled();
    }

    /*
     * =========================================================
     * INDIVIDUAL INPUT METHODS
     * =========================================================
     */

    public void enterEmailAddress(String emailaddress) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(emailAddressField)
        );
        element.clear();
        element.sendKeys(emailaddress);
    }

    public void enterLookupFirstName(String lookupirstName) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(lookupfirstNameField)
        );
        element.clear();
        element.sendKeys(lookupirstName);
    }

    public void enterLookupLastName(String lookuplastName) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(lookuplastNameField)
        );

        element.clear();
        element.sendKeys(lookuplastName);
    }

    

   
    /*
     * =========================================================
     * GET ENTERED FIELD VALUES
     * =========================================================
     *
     * These methods are useful for assertEquals validations.
     */

    public String getEnteredMemberNumber() {
    return emailAddressField.getAttribute("value");
    }

    public String getEnteredFirstName() {
    return lookupfirstNameField.getAttribute("value");
    }

    public String getEnteredLastName() {
    return lookuplastNameField.getAttribute("value");
    }

   


    /*
     * =========================================================
     * ATTRIBUTE VALIDATIONS
     * =========================================================
     */

    public String getMemberNumberMaxLength() {
    return emailAddressField.getAttribute("maxlength");
    }

    public String getFirstNameMaxLength() {
    return lookupfirstNameField.getAttribute("maxlength");
    }

    public String getLastNameMaxLength() {
    return lookuplastNameField.getAttribute("maxlength");
    }

     public String getSubmitButtonText() {
    return wait.until(
            ExpectedConditions.visibilityOf(submitButton)
        ).getText().trim();
    }

    /*
     * =========================================================
     * CONTINUE ACTION
     * =========================================================
     */

    public void clickSubmitButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
    }


    /*
     * =========================================================
     * BASIC PAGE INFORMATION
     * =========================================================
     */

    public String getPageTitle() {
    return driver.getTitle();
    }

    public String getCurrentUrl() {
    return driver.getCurrentUrl();
    }
}

    

