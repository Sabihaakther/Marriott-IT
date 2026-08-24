package com.marriott.ui.tests.regressionTests;
import com.marriott.ui.base.BaseTest;
import com.marriott.ui.pages.MarriotBonVoyDashboard;
import com.marriott.ui.pages.SpecialOfferPage;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.logging.Logger;



public class SpecialOfferTest extends BaseTest {

  private static final Logger LOGGER =
            Logger.getLogger(SpecialOfferTest.class.getName());

    private void logger(String message) {
        LOGGER.info(message);
    }

    private MarriotBonVoyDashboard dashboard;
    private SpecialOfferPage specialOfferPage;

    @BeforeMethod
    public void initializePageObjects() {
        logger("Precondition: Initialize Dashboard and Special Offer Page Objects");
        dashboard = new MarriotBonVoyDashboard(driver);
        specialOfferPage = new SpecialOfferPage(driver);
    }

    @Test
    public void testSpecialOfferNavigationFlow() throws InterruptedException {

        logger("Step-1: Verify Dashboard header logo is displayed");
        assertTrue(
                dashboard.isMarriottBonvoyHeaderLogoDisplayed(),
                "Dashboard header logo was not displayed."
        );

        logger("Step-2: Click Special Offers button");
        specialOfferPage.clickSpecialOffersButton();

        logger("Step-3: Verify Special Offers page heading is displayed");
        assertTrue(
                specialOfferPage.isSpecialOffersHeadingDisplayed(),
                "Special Offers heading was not displayed."
        );

        logger("Step-4: Click Shop Marriott link");
        specialOfferPage.clickShopMarriottLink();

        logger("Step-5: Switch to new tab");
        specialOfferPage.switchToNewTab();

        // Re-initialize Page Object
        specialOfferPage = new SpecialOfferPage(driver);

        logger("Step-6: Click Shop Now button from banner");
        specialOfferPage.clickShopNowButton();

        logger("Step-7: Verify Shop Now button is displayed");
        assertTrue(
                specialOfferPage.isShopNowButtonDisplayed(),
                "Shop Now button was not displayed."
        );

        Thread.sleep(5000);
        logger("Step-8: Completed Special Offer navigation flow successfully");
    }
    }

