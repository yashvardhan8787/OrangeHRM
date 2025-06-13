package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;
import basePage.Header;
import basePage.NavBar;

/**
 * Page Object Model class for OrangeHRM Dash board Page.
 * All elements are private with public action methods.
 * Uses PageFactory for element initialization.
 */
public class DashboardPage extends BasePage {

    // ===== Constructor =====

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    // ===== Side Panel Navigation =====

    // OrangeHRM banner/logo (side panel)
    @FindBy(css = "div.oxd-brand-banner img[alt='client brand banner']")
    private WebElement sidePanelBrandBanner;

    // Main menu items (left nav) -- all visible modules
    @FindBy(css = "a.oxd-main-menu-item")
    private List<WebElement> mainMenuItems;

    // Main menu search input (if present)
    @FindBy(css = "div.oxd-main-menu-search input")
    private WebElement mainMenuSearchInput;

    // ===== Dashboard Widgets =====

    // Buzz Latest Posts widget header
    @FindBy(xpath = "//p[text()='Buzz Latest Posts']")
    private WebElement buzzWidgetHeader;

    // All Buzz post cards
    @FindBy(css = ".orangehrm-buzz-widget-card")
    private List<WebElement> buzzPostCards;

    // Employee on Leave Today widget header
    @FindBy(xpath = "//p[text()='Employees on Leave Today']")
    private WebElement onLeaveWidgetHeader;

    // "No Employees are on Leave Today" message
    @FindBy(xpath = "//div[contains(@class,'orangehrm-dashboard-widget-body-nocontent')]/p")
    private WebElement noEmployeesOnLeaveMessage;

    // Employee Distribution by Sub Unit widget header
    @FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']")
    private WebElement empDistBySubUnitHeader;

    // Sub Unit chart canvas
    @FindBy(css = ".emp-distrib-chart .oxd-pie-chart canvas")
    private WebElement subUnitPieChartCanvas;

    // Sub Unit chart legend items
    @FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']/ancestor::div[contains(@class,'orangehrm-dashboard-widget')]/descendant::ul[contains(@class,'oxd-chart-legend')]/li/span[@title]")
    private List<WebElement> subUnitLegend;

    // Employee Distribution by Location widget header
    @FindBy(xpath = "//p[text()='Employee Distribution by Location']")
    private WebElement empDistByLocationHeader;

    // Location chart canvas
    @FindBy(xpath = "//p[text()='Employee Distribution by Location']/ancestor::div[contains(@class,'orangehrm-dashboard-widget')]/descendant::canvas")
    private WebElement locationPieChartCanvas;

    // Location chart legend items
    @FindBy(xpath = "//p[text()='Employee Distribution by Location']/ancestor::div[contains(@class,'orangehrm-dashboard-widget')]/descendant::ul[contains(@class,'oxd-chart-legend')]/li/span[@title]")
    private List<WebElement> locationLegend;

    // ===== Footer =====

    @FindBy(css = ".oxd-layout-footer .orangehrm-copyright")
    private List<WebElement> footerCopyrights;


    // ======= Action Methods =======


    /** Get the names of all visible main menu items */
    public List<String> getMainMenuItemNames() {
        return mainMenuItems.stream().map(WebElement::getText).toList();
    }

    /** Click a main menu item by visible text */
    public void clickMenuItemByName(String menuName) {
        for (WebElement item : mainMenuItems) {
            if (item.getText().trim().equalsIgnoreCase(menuName)) {
                item.click();
                break;
            }
        }
    }

    /** Search in the main menu (if search is present) */
    public void searchMainMenu(String keyword) {
        if (mainMenuSearchInput != null && mainMenuSearchInput.isDisplayed()) {
            mainMenuSearchInput.clear();
            mainMenuSearchInput.sendKeys(keyword);
        }
    }

    /** Check if side panel brand banner is displayed */
    public boolean isBrandBannerDisplayed() {
        return sidePanelBrandBanner.isDisplayed();
    }

    // --- Buzz Widget ---

    /** Check if Buzz Latest Posts widget is displayed */
    public boolean isBuzzWidgetDisplayed() {
        return buzzWidgetHeader.isDisplayed();
    }

    /** Get all Buzz post contents (text) */
    public List<String> getAllBuzzPostContents() {
        return buzzPostCards.stream()
            .map(card -> card.findElement(
                org.openqa.selenium.By.cssSelector(".orangehrm-buzz-widget-body")).getText())
            .toList();
    }

    /** Get all Buzz post employee names */
    public List<String> getAllBuzzPostEmployeeNames() {
        return buzzPostCards.stream()
            .map(card -> card.findElement(
                org.openqa.selenium.By.cssSelector(".orangehrm-buzz-widget-header-emp")).getText())
            .toList();
    }

    // --- Employees on Leave Widget ---

    /** Check if Employees on Leave Today widget is displayed */
    public boolean isOnLeaveWidgetDisplayed() {
        return onLeaveWidgetHeader.isDisplayed();
    }

    /** Get the "No Employees are on Leave Today" message */
    public String getNoEmployeesOnLeaveMessage() {
        return noEmployeesOnLeaveMessage.getText();
    }

    // --- Employee Distribution by Sub Unit Widget ---

    /** Check if Employee Distribution by Sub Unit widget is displayed */
    public boolean isEmpDistBySubUnitWidgetDisplayed() {
        return empDistBySubUnitHeader.isDisplayed();
    }

    /** Get all sub unit names from the chart legend */
    public List<String> getSubUnitLegendNames() {
        return subUnitLegend.stream().map(WebElement::getText).toList();
    }

    /** Check if Sub Unit pie chart is displayed */
    public boolean isSubUnitPieChartDisplayed() {
        return subUnitPieChartCanvas.isDisplayed();
    }

    // --- Employee Distribution by Location Widget ---

    /** Check if Employee Distribution by Location widget is displayed */
    public boolean isEmpDistByLocationWidgetDisplayed() {
        return empDistByLocationHeader.isDisplayed();
    }

    /** Get all location names from the chart legend */
    public List<String> getLocationLegendNames() {
        return locationLegend.stream().map(WebElement::getText).toList();
    }

    /** Check if Location pie chart is displayed */
    public boolean isLocationPieChartDisplayed() {
        return locationPieChartCanvas.isDisplayed();
    }
    
 // Add these methods to DashboardPage class

    public String getTopbarBreadcrumbTitle() {
        return Header.getBreadcrumbModuleTitle();
    }

    public boolean isSidePanelDisplayed() {
    	
        return NavBar.isSidePanelPresent();
    }

    // --- Footer ---

    /** Get all footer copyright lines */
    public List<String> getFooterCopyrights() {
        return footerCopyrights.stream().map(WebElement::getText).toList();
    }
}