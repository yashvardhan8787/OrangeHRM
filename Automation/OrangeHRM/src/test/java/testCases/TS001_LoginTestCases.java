package testCases;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginPage;
import pageObjects.DashboardPage;

public class TS001_LoginTestCases extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TS001_LoginTestCases.class);

    @Test(priority = 1)
    public void loginWithEmptyUsernameAndPassword() {
        SoftAssert softAssert = new SoftAssert();
        logger.info("Test: loginWithEmptyUsernameAndPassword started");

        LoginPage lp = new LoginPage(driver);
        lp.login("       ", "      ");
        logger.info("Submitted login with empty username and password.");

        // Assertion: Required error message should be displayed for username and password
        boolean isUsernameErrorDisplayed = lp.isRequiredErrorDisplayed();
     
        logger.info("Username error displayed: " + isUsernameErrorDisplayed);

        softAssert.assertTrue(isUsernameErrorDisplayed, "Username required error should be displayed.");


        // Also assert that we are still on the login page (logo, title visible)
        softAssert.assertTrue(lp.isLogoDisplayed(), "Login page logo should be displayed.");

        softAssert.assertAll();
         logger.info("Test: loginWithEmptyUsernameAndPassword completed");
    }

    @Test(priority = 2)
    public void loginWithInvalidUsernameAndPassword() {
        SoftAssert softAssert = new SoftAssert();
        logger.info("Test: loginWithInvalidUsernameAndPassword started");

        LoginPage lp = new LoginPage(driver);
        lp.login("yash", "8787021710");
        logger.info("Submitted login with invalid username and password.");

        // Assertion: Invalid credentials error message should be displayed
        boolean isInvalidCredsMessageDisplayed = lp.isInvalidCredentialsErrorDisplayed();
        logger.info("Invalid Credentials error displayed: " + isInvalidCredsMessageDisplayed);

        softAssert.assertTrue(isInvalidCredsMessageDisplayed, "Invalid Credentials error should be displayed.");

        // Still on login page
        softAssert.assertTrue(lp.isLogoDisplayed(), "Login page logo should be displayed.");
    
        softAssert.assertAll();
        logger.info("Test: loginWithInvalidUsernameAndPassword completed");
    }

    @Test(priority = 3)
    public void loginWithValidUsernameAndValidPassword() {
        SoftAssert softAssert = new SoftAssert();
        logger.info("Test: loginWithValidUsernameAndValidPassword started");

        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");
        logger.info("Submitted login with valid username and password.");

        // Assertion: Dashboard should be displayed
        DashboardPage dp = new DashboardPage(driver);
        boolean isDashboardDisplayed = dp.isBuzzWidgetDisplayed() && dp.isOnLeaveWidgetDisplayed();
        logger.info("Dashboard Buzz Widget displayed: " + dp.isBuzzWidgetDisplayed());
        logger.info("Dashboard On Leave Widget displayed: " + dp.isOnLeaveWidgetDisplayed());

        softAssert.assertTrue(isDashboardDisplayed, "Dashboard widgets should be displayed after successful login.");

        softAssert.assertAll();
        logger.info("Test: loginWithValidUsernameAndValidPassword completed");
    }
}