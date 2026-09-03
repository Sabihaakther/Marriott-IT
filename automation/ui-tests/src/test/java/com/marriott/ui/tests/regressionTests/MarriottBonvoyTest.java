package com.marriott.ui.tests.regressionTests;
import com.marriott.ui.base.BaseTest;
import com.marriott.ui.pages.MarriotBonVoyDashboard;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.marriott.ui.pages.MarriottBonvoyPage;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.logging.Logger;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

public class MarriottBonvoyTest extends BaseTest {
        private static final Logger LOGGER =
            Logger.getLogger(MarriottBonvoyTest.class.getName());

    private void logger(String message) {
        LOGGER.info(message);
    }

    private MarriottBonvoyPage bonvoyPage;

    private static final String FIRST_NAME = "Syed";
    private static final String LAST_NAME = "Ahmed";
    private static final String EMAIL = "syed@test.com";
    private static final String PASSWORD = "Password123!";

    @BeforeMethod
    public void initializePageObjects() {

        logger("Precondition: Initialize Marriott Bonvoy Page Objects");

        bonvoyPage = new MarriottBonvoyPage(driver);

        logger("Navigate to Marriott Credit Cards page");
        driver.get("https://www.marriott.com/credit-cards.mi");
    }

    @Test
    public void testMarriottBonvoyJoinFlow() {

    logger("Step‑1: Click See Details");
    bonvoyPage.clickSeeDetails();

    logger("Step‑2: Click Apply Now");
    bonvoyPage.clickApplyNow();

    logger("Step‑3: Validate navigation");
    assertTrue(driver.getCurrentUrl().contains("marriott.com"),
            "Apply Now did not navigate to the Marriott application page.");
}

}