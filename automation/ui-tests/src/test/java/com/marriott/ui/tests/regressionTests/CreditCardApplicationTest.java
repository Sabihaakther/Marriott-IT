package com.marriott.ui.tests.regressionTests;

import java.util.logging.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.marriott.ui.base.BaseTest;
import com.marriott.ui.pages.MarriotBonVoyDashboard;
import com.marriott.ui.pages.OurCreditCardPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import com.marriott.ui.pages.OurCreditCardPage;
import org.testng.annotations.*;
import static org.testng.Assert.*;


public class CreditCardApplicationTest extends BaseTest {

   private static final Logger LOGGER = Logger.getLogger(DashboardTest.class.getName());

    private void logger(String message) {
        LOGGER.info(message);
    }

    private MarriotBonVoyDashboard dashboard;
    private OurCreditCardPage creditCardPage;

    /*
     * =========================================================
     * TEST DATA
     * =========================================================
     */

    private static final String FIRST_NAME = "Sabiha";
    private static final String MIDDLE_NAME = "Akther";
    private static final String LAST_NAME = "Rahman";
    private static final String DOB = "01/01/1990";
    private static final String MOTHERS_MAIDEN = "Begum";
    private static final String SSN = "123456789";
    private static final String STREET = "123 Main Street";
    private static final String SUITE = "Apt 4B";
    private static final String CITY = "New York";
    private static final String ZIP = "10001";
    private static final String EMAIL = "sabiha.test@example.com";
    private static final String PHONE = "3475551212";

    /*
     * =========================================================
     * INITIALIZE PAGE OBJECTS
     * =========================================================
     */

    @BeforeMethod
    public void initializePageObjects() {
        logger("Precondition: Initialize the list of Marriot Bon Voy Page");
        //logger("Precondition: Initialize Dashboard and Credit Card Page Objects");
        dashboard = new MarriotBonVoyDashboard(driver);
        creditCardPage = new OurCreditCardPage(driver);
    }

    /*
     * =========================================================
     * FULL CREDIT CARD APPLICATION TEST
     * =========================================================
     */

    @Test
    public void testCreditCardApplicationFlow() throws InterruptedException {

        logger("Step-1: Verify user is on Marriott Bonvoy Dashboard");
        assertEquals(dashboard.isMarriottBonvoyHeaderLogoDisplayed(),true,"Marriott Bonvoy Dashboard was not displayed.");

        logger("Step-2: Verify user is on Marriott Bonvoy Dashboard");
        assertTrue(
                dashboard.isMarriottBonvoyHeaderLogoDisplayed(),
                "Marriott Bonvoy Dashboard was not displayed."
        );
        
        logger("Step-3: Click Credit Card button");
        dashboard.clickCreditCard ();

        logger("Step-4: Verify Credit Card page object initialized");
        assertNotNull(creditCardPage,"Credit Card page object was not initialized.");

         logger("Step-5: Verify Credit Card link is displayed");
        assertEquals(creditCardPage.isCreditCardButtonDisplayed (),true," Credit Card link was not displayed.");

        logger("Step-6: Verify Credit Card link is enabled");
        assertEquals(creditCardPage.isCreditCardLinkEnabled (),true,"Credit Card link was not enabled.");
        
                   // Do to do
    
          logger("Step-7: Click See Details button");
        creditCardPage.clickSeeDetailsButton();

        logger("Step-8: Verify See Details page object initialized");
        assertNotNull(creditCardPage,"See Details page object was not initialized.");

         logger("Step-9: Verify See Details link is displayed");
        assertEquals(creditCardPage.isSeeDetailsLinkDisplayed (),true,"See Details link was not displayed.");

        logger("Step-10: Verify See Details link is enabled");
        assertEquals(creditCardPage.isSeeDetailsLinkEnabled (),true,"See Details link was not enabled.");


        logger("Step-11: Click Apply Now button");
        creditCardPage.clickApplyNowButton();;

        logger("Step-12: Verify Apply Now page object initialized");
        assertNotNull(creditCardPage,"Apply Now page object was not initialized.");

         logger("Step-13: Verify Apply Now link is displayed");
        assertEquals(creditCardPage.isApplyNowButtonDisplayed (),true,"Apply Now link was not displayed.");

        logger("Step-14: Verify Apply Now link is enabled");
        assertEquals(creditCardPage.isApplyNowButtinLinkEnabled(),true,"Apply Now link was not enabled.");




        //logger("Step-4: Click See Details button");
       // creditCardPage.clickSeeDetailsButton();

        //logger("Step-5: Verify See Details link is displayed");
        //assertTrue(
                //creditCardPage.isSeeDetailsLinkDisplayed(),
               // "See Details link was not displayed."
       // );

        //logger("Step-6: Click Apply Now button");
        //creditCardPage.clickApplyNowButton();

        //logger("Step-7: Verify Apply Now button is displayed");
        //assertTrue(
                //creditCardPage.isApplyNowButtonDisplayed(),
                //"Apply Now button was not displayed."
        //);

        logger("Step-15: Verify Let's Get Started heading is displayed");
        assertTrue(
                creditCardPage.isLetsGetStartedHeadingDisplayed(),
                "Let's Get Started heading was not displayed."
        );

        /*
         * =========================================================
         * ENTER PERSONAL INFORMATION
         * =========================================================
         */

        logger("Step-16: Enter First Name");
        creditCardPage.enterFirstName(FIRST_NAME);
        assertEquals(creditCardPage.getEnteredFirstName(), FIRST_NAME);

        logger("Step-17: Enter Middle Name");
        creditCardPage.enterMiddleName(MIDDLE_NAME);
        assertEquals(creditCardPage.getEnteredMiddleName(), MIDDLE_NAME);

        logger("Step-18: Enter Last Name");
        creditCardPage.enterLastName(LAST_NAME);
        assertEquals(creditCardPage.getEnteredLastName(), LAST_NAME);

        logger("Step-19: Enter Date of Birth (Shadow DOM)");
        creditCardPage.enterDateOfBirth(DOB);

        logger("Step-20: Enter Mother's Maiden Name");
        creditCardPage.enterMothersMaidenName(MOTHERS_MAIDEN);
        assertEquals(creditCardPage.getEnteredMothersMaidenName(), MOTHERS_MAIDEN);

        logger("Step-21: Enter SSN");
        creditCardPage.enterSsn(SSN);
        assertEquals(creditCardPage.getEnteredSsn(), SSN);

        /*
         * =========================================================
         * ENTER ADDRESS INFORMATION
         * =========================================================
         */

        logger("Step-22: Enter Street Address");
        creditCardPage.enterStreetAddress(STREET);
        assertEquals(creditCardPage.getEnteredStreetAddress(), STREET);

        logger("Step-23: Enter Suite/Apt");
        creditCardPage.enterSuiteApt(SUITE);
        assertEquals(creditCardPage.getEnteredSuiteApt(), SUITE);

        logger("Step-24: Enter City");
        creditCardPage.enterCity(CITY);
        assertEquals(creditCardPage.getEnteredCity(), CITY);

        logger("Step-25: Enter ZIP Code");
        creditCardPage.enterZipCode(ZIP);
        assertEquals(creditCardPage.getEnteredZipCode(), ZIP);

        /*
         * =========================================================
         * ENTER CONTACT INFORMATION
         * =========================================================
         */

        logger("Step-26: Enter Email Address");
        creditCardPage.enterEmailAddress(EMAIL);
        assertEquals(creditCardPage.getEnteredEmailAddress(), EMAIL);

        logger("Step-27: Enter Phone Number");
        creditCardPage.enterPhoneNumber(PHONE);
        assertEquals(creditCardPage.getEnteredPhoneNumber(), PHONE);

        logger("Step-28: Completed Credit Card Application input validation");

        Thread.sleep(5000);
    }
}

   
  
    



