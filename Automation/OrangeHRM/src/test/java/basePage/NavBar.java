package basePage;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model class for the OrangeHRM Sidepanel Navbar.
 * All elements are private with public action methods.
 * Uses PageFactory for element initialization.
 */
public class NavBar extends BasePage {
    // ========== Constructor ==========

    public NavBar(WebDriver driver) {
    	super(driver);
    };
    // ========== Brand Elements ==========

    // Brand logo (could be hidden/shown)
    @FindBy(css = "div.oxd-brand-logo img[alt='client brand logo']")
    private static WebElement brandLogo;

    // Brand banner (main banner image)
    @FindBy(css = "div.oxd-brand-banner img[alt='client brand banner']")
    private WebElement brandBanner;

    // Brand link
    @FindBy(css = ".oxd-sidepanel-header .oxd-brand")
    private WebElement brandLink;

    // Sidepanel close button (X)
    @FindBy(css = ".oxd-sidepanel-header-close")
    private WebElement closeSidepanelBtn;

    // ========== Main Menu ==========

    // Main menu search icon (svg)
    @FindBy(css = "div.oxd-main-menu-search svg.oxd-menu-icon")
    private WebElement mainMenuSearchIcon;

    // All main menu items (anchors for navigation)
    @FindBy(css = "a.oxd-main-menu-item")
    private List<WebElement> mainMenuItems;

    // All menu item names (spans inside menu)
    @FindBy(css = "a.oxd-main-menu-item span.oxd-main-menu-item--name")
    private List<WebElement> mainMenuItemNames;

    // Main menu item wrappers (for possible advanced interaction)
    @FindBy(css = "li.oxd-main-menu-item-wrapper")
    private List<WebElement> mainMenuItemWrappers;

    // ========== Individual Navigation Links ==========

    // Admin link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/admin/viewAdminModule')]")
    private WebElement adminLink;

    // PIM link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/pim/viewPimModule')]")
    private WebElement pimLink;

    // Leave link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/leave/viewLeaveModule')]")
    private WebElement leaveLink;

    // Time link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/time/viewTimeModule')]")
    private WebElement timeLink;

    // Recruitment link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/recruitment/viewRecruitmentModule')]")
    private WebElement recruitmentLink;

    // My Info link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/pim/viewMyDetails')]")
    private WebElement myInfoLink;

    // Performance link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/performance/viewPerformanceModule')]")
    private WebElement performanceLink;

    // Dashboard link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/dashboard/index')]")
    private WebElement dashboardLink;

    // Directory link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/directory/viewDirectory')]")
    private WebElement directoryLink;

    // Maintenance link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/maintenance/viewMaintenanceModule')]")
    private WebElement maintenanceLink;

    // Claim link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/claim/viewClaimModule')]")
    private WebElement claimLink;

    // Buzz link
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/buzz/viewBuzz')]")
    private WebElement buzzLink;

    // ========== Brand Actions ==========

    /** Click the brand logo/banner to visit the OrangeHRM site */
    public void clickBrandLink() {
        brandLink.click();
    }

    /** Returns true if the sidepanel close button is displayed */
    public boolean isCloseButtonDisplayed() {
        return closeSidepanelBtn.isDisplayed();
    }

    /** Clicks the sidepanel close (X) button */
    public void clickCloseSidepanel() {
        closeSidepanelBtn.click();
    }

    /** Returns true if the brand banner is displayed */
    public boolean isBrandBannerDisplayed() {
        return brandBanner.isDisplayed();
    }

    /** Returns true if the brand logo is displayed */
    public boolean isBrandLogoDisplayed() {
        return brandLogo.isDisplayed();
    }

    // ========== Main Menu Actions ==========

    /** Get the names of all visible main menu items */
    public List<String> getMainMenuItemNames() {
        return mainMenuItemNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Click a main menu item by its visible text (case-insensitive).
     * @param menuName The name of the menu item (e.g. "Admin", "Recruitment")
     */
    public void clickMenuItemByName(String menuName) {
        for (WebElement item : mainMenuItems) {
            if (item.getText().trim().equalsIgnoreCase(menuName)) {
                item.click();
                break;
            }
        }
    }

    /** Get hrefs of all main menu items */
    public List<String> getMainMenuItemLinks() {
        return mainMenuItems.stream().map(item -> item.getAttribute("href")).collect(Collectors.toList());
    }

    /** Returns true if the main menu search icon is displayed */
    public boolean isMainMenuSearchIconDisplayed() {
        return mainMenuSearchIcon.isDisplayed();
    }

    // ========== Navigation Link Actions ==========

    public void clickAdmin() { adminLink.click(); }
    public void clickPIM() { pimLink.click(); }
    public void clickLeave() { leaveLink.click(); }
    public void clickTime() { timeLink.click(); }
    public void clickRecruitment() { recruitmentLink.click(); }
    public void clickMyInfo() { myInfoLink.click(); }
    public void clickPerformance() { performanceLink.click(); }
    public void clickDashboard() { dashboardLink.click(); }
    public void clickDirectory() { directoryLink.click(); }
    public void clickMaintenance() { maintenanceLink.click(); }
    public void clickClaim() { claimLink.click(); }
    public void clickBuzz() { buzzLink.click(); }

    // Optionally, for test assertions
    public boolean isAdminDisplayed() { return adminLink.isDisplayed(); }
    public boolean isPIMDisplayed() { return pimLink.isDisplayed(); }
    public boolean isLeaveDisplayed() { return leaveLink.isDisplayed(); }
    public boolean isTimeDisplayed() { return timeLink.isDisplayed(); }
    public boolean isRecruitmentDisplayed() { return recruitmentLink.isDisplayed(); }
    public boolean isMyInfoDisplayed() { return myInfoLink.isDisplayed(); }
    public boolean isPerformanceDisplayed() { return performanceLink.isDisplayed(); }
    public boolean isDashboardDisplayed() { return dashboardLink.isDisplayed(); }
    public boolean isDirectoryDisplayed() { return directoryLink.isDisplayed(); }
    public boolean isMaintenanceDisplayed() { return maintenanceLink.isDisplayed(); }
    public boolean isClaimDisplayed() { return claimLink.isDisplayed(); }
    public boolean isBuzzDisplayed() { return buzzLink.isDisplayed(); }

	public static boolean isSidePanelPresent() {
		// TODO Auto-generated method stub
		return brandLogo.isDisplayed();
	}
}