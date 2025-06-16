package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pageObjects.DashboardPage;
import basePage.Header;
import pageObjects.LoginPage;

public class TS002_LogoutTestCases extends BaseTest {

    @Test(priority = 99)
    public void logoutTestCase() {
        // Assumes user is already logged in via BaseTest

        // Create page objects
        DashboardPage dashboardPage = new DashboardPage(driver);
        Header header = new Header(driver);

        // Ensure dashboard is loaded
        Assert.assertTrue(dashboardPage.isBrandBannerDisplayed(), "Dashboard not loaded!");

        // Open user dropdown
        header.openUserDropdown();
        Assert.assertTrue(header.isUserDropdownMenuDisplayed(), "User dropdown menu not displayed!");

        // Click "Logout" option
        header.clickLogoutOption();

        // Verify that the login page is displayed after logout
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logout failed! Login page not displayed.");
    }
}