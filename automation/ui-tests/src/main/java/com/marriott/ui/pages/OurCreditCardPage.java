package com.marriott.ui.pages;

import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;



public class OurCreditCardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OurCreditCardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    /*
     * =========================================================
     * NAVIGATION ELEMENTS
     * =========================================================
     */

    @FindBy(xpath = "//button[contains(@data-testid,'credit-cards')]")
    private WebElement creditCardButton;

    @FindBy(xpath = "//a[contains(text(),'See Details')]")
    private WebElement seeDetailsLink;

    @FindBy(xpath = "//a[@data-pt-name='cc_apply_now_bound']")
    private WebElement applyNowButton;

    @FindBy(xpath = "//h1[contains(text(),\"Let's get started\")]")
    private WebElement letsGetStartedHeading;

    /*
     * =========================================================
     * PERSONAL INFORMATION
     * =========================================================
     */

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "middleName")
    private WebElement middleNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "suffix")
    private WebElement suffixDropdown;

    @FindBy(id = "mothersMaidenName")
    private WebElement mothersMaidenNameField;

    @FindBy(id = "ssn")
    private WebElement ssnField;

    /*
     * =========================================================
     * SHADOW DOM — DATE OF BIRTH
     * =========================================================
     */

    private WebElement getDobInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(
                "return document.querySelector('mds-datepicker')" +
                ".shadowRoot.querySelector('mds-text-input')" +
                ".shadowRoot.querySelector('input');"
        );
    }

    /*
     * =========================================================
     * ADDRESS INFORMATION
     * =========================================================
     */

    @FindBy(id = "streetAddress")
    private WebElement streetAddressField;

    @FindBy(id = "suiteAptOther")
    private WebElement suiteAptField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "state")
    private WebElement stateDropdown;

    @FindBy(id = "zipCode")
    private WebElement zipCodeField;

    /*
     * =========================================================
     * CONTACT INFORMATION
     * =========================================================
     */

    @FindBy(id = "emailAddress")
    private WebElement emailAddressField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    /*
     * =========================================================
     * CLICK METHODS
     * =========================================================
     */

    
    
    public void clickCreditCardButton() {
    System.out.println("Clicking Credit Card button from Dashboard");

    WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(creditCardButton)
    );

    element.click();
}

    // public void clickCreditCard() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header")));
        //wait.until(ExpectedConditions.elementToBeClickable(creditCardButton)).click();
    //}




     public void clickSeeDetailsButton() {
    System.out.println("Clicking See Details button");

    WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(seeDetailsLink)
    );

    element.click();
}
    //public void clickSeeDetailsButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(seeDetailsLink)).click();
   //}
    

    public void clickApplyNowButton() {
    System.out.println("Clicking Apply Now button");

    WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(applyNowButton)
    );

    element.click();
}
   //public void clickApplyNowButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(applyNowButton)).click();
   // }

    /*
     * =========================================================
     * VALIDATION METHODS
     * =========================================================
     */

    public boolean isCreditCardButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(creditCardButton)).isDisplayed();
    }

     public boolean isCreditCardLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOf(
                        creditCardButton
                )
        ).isEnabled();
    }


    public boolean isSeeDetailsLinkDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(seeDetailsLink)).isDisplayed();
    }

    public boolean isSeeDetailsLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOf(
                        seeDetailsLink
                )
        ).isEnabled();
    }

    public boolean isApplyNowButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(applyNowButton)).isDisplayed();
    }
     
     public boolean isApplyNowButtinLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOf(
                        applyNowButton
                )
        ).isEnabled();
    }


    public boolean isLetsGetStartedHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(letsGetStartedHeading)).isDisplayed();
    }

    /*
     * =========================================================
     * INPUT METHODS
     * =========================================================
     */

    public void enterFirstName(String firstName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        element.clear();
        element.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(middleNameField));
        element.clear();
        element.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        element.clear();
        element.sendKeys(lastName);
    }

    public void enterDateOfBirth(String dob) {
        WebElement dobInput = getDobInput();
        dobInput.clear();
        dobInput.sendKeys(dob);
    }

    public void enterMothersMaidenName(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(mothersMaidenNameField));
        element.clear();
        element.sendKeys(name);
    }

    public void enterSsn(String ssn) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(ssnField));
        element.clear();
        element.sendKeys(ssn);
    }

    public void enterStreetAddress(String street) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(streetAddressField));
        element.clear();
        element.sendKeys(street);
    }

    public void enterSuiteApt(String suite) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(suiteAptField));
        element.clear();
        element.sendKeys(suite);
    }

    public void enterCity(String city) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(cityField));
        element.clear();
        element.sendKeys(city);
    }

    public void enterZipCode(String zip) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        element.clear();
        element.sendKeys(zip);
    }

    public void enterEmailAddress(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailAddressField));
        element.clear();
        element.sendKeys(email);
    }

    public void enterPhoneNumber(String phone) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        element.clear();
        element.sendKeys(phone);
    }

    /*
     * =========================================================
     * GETTERS FOR ASSERTIONS
     * =========================================================
     */

    public String getEnteredFirstName() { return firstNameField.getAttribute("value"); }
    public String getEnteredMiddleName() { return middleNameField.getAttribute("value"); }
    public String getEnteredLastName() { return lastNameField.getAttribute("value"); }
    public String getEnteredMothersMaidenName() { return mothersMaidenNameField.getAttribute("value"); }
    public String getEnteredSsn() { return ssnField.getAttribute("value"); }
    public String getEnteredStreetAddress() { return streetAddressField.getAttribute("value"); }
    public String getEnteredSuiteApt() { return suiteAptField.getAttribute("value"); }
    public String getEnteredCity() { return cityField.getAttribute("value"); }
    public String getEnteredZipCode() { return zipCodeField.getAttribute("value"); }
    public String getEnteredEmailAddress() { return emailAddressField.getAttribute("value"); }
    public String getEnteredPhoneNumber() { return phoneNumberField.getAttribute("value"); }
}
