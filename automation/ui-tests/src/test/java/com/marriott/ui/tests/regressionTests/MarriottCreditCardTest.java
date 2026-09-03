package com.marriott.ui.tests.regressionTests;
import com.marriott.ui.base.BaseTest;
import com.marriott.ui.pages.MarriottCreditCardPage;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;




public class MarriottCreditCardTest extends BaseTest {

   
      private WebDriver driver;
    private MarriottCreditCardPage page;
    private WebDriverWait wait;

    private static final Logger LOGGER =
            Logger.getLogger(MarriottCreditCardTest.class.getName());

    private void logger(String message) {
        LOGGER.info(message);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        logger("Opening Marriott Credit Cards dashboard page...");
        driver.get("https://www.marriott.com/credit-cards.mi");

        page = new MarriottCreditCardPage(driver);
    }

    @Test
    public void testFullCreditCardApplicationFlow() {

        logger("Step 1: Clicking SEE DETAILS...");
        String originalWindow = driver.getWindowHandle();
        page.clickSeeDetails();

        logger("Step 2: Switching to Chase window...");
        switchToNewWindow(originalWindow);

        logger("Step 3: Clicking APPLY NOW...");
        page.clickApplyNow();

        logger("Step 4: Switching to new window if opened...");
        switchToNewWindow(driver.getWindowHandle());
       logger("Step 5: Checking if Chase returned 'System Required' page...");

       String pageSource = driver.getPageSource().toLowerCase();
       String title = driver.getTitle().toLowerCase();

      boolean systemRequired =
        title.contains("system required") ||
        pageSource.contains("system required") ||
        pageSource.contains("your system does not meet") ||
        pageSource.contains("requirements to continue");

      if (systemRequired) {
    logger("Chase returned 'System Required' page instead of the application form.");
    logger("This means the current environment (Linux + ChromeDriver) is NOT supported by Chase AEP.");
    Assert.fail("Application form cannot load because Chase displayed 'System Required'. Environment does not meet requirements.");
     }

     logger("Step 6: Switching into correct Chase iframe...");
     page.switchToCorrectIframe();


        logger("Step 7: Waiting for First Name field...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                MarriottCreditCardPage.FIRST_NAME_LOCATOR));

        logger("Step 8: Filling application form...");
        page.fillFirstName("Syed");
        page.fillLastName("Hossain");
        page.fillAddress("123 Main Street");
        page.fillCity("New York");
        page.selectState("NY");
        page.fillZip("10001");
        page.fillPhone("3475551212");
        page.fillEmail("syed@example.com");
        page.fillIncome("95000");
        page.selectEmploymentStatus("Employed");

        logger("Step 9: Scrolling to SUBMIT...");
        page.scrollToSubmitButton();

        logger("Step 10: Clicking SUBMIT...");
        page.clickSubmit();

        logger("Flow completed successfully.");
    }

    private void switchToNewWindow(String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        logger("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
    }
    





