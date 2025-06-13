package basePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Page Object Model class for the OrangeHRM Header (Top bar).
 * All elements are private with public action methods.
 * Uses PageFactory for element initialization.
 */
public class Header extends BasePage {
	
     // ===== Constructor =====
    public Header(WebDriver driver) {
       super(driver);
    }

    // Hamburger menu icon (top left)
    @FindBy(css = ".oxd-topbar-header-hamburger")
    private WebElement hamburgerMenuIcon;

    // Bread crumb module title (e.g., "Dash board")
    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private static WebElement breadcrumbModuleTitle;

    // User area (right side)
    @FindBy(css = ".oxd-topbar-header-userarea")
    private WebElement userArea;

    // User drop down, tab and elements
    @FindBy(css = ".oxd-userdropdown")
    private WebElement userDropdown;

    @FindBy(css = ".oxd-userdropdown-tab")
    private WebElement userDropdownTab;

    @FindBy(css = ".oxd-userdropdown-img")
    private WebElement userProfileImage;

    @FindBy(css = ".oxd-userdropdown-name")
    private WebElement userName;

    @FindBy(css = ".oxd-userdropdown-icon")
    private WebElement userDropdownIcon;

    // Entire drop down menu (visible after clicking on the drop down tab)
    @FindBy(css = ".oxd-userdropdown-menu")
    private WebElement userDropdownMenu;

    // All drop down menu items ( li )
    @FindBy(css = ".oxd-userdropdown-menu li")
    private List<WebElement> userDropdownMenuItems;

    // Drop down options - About, Support, Change Password, Logout, etc.
    @FindBy(xpath = "//li[contains(@class,'oxd-userdropdown')]/span/following-sibling::ul/li/button")
    private List<WebElement> userDropdownOptionButtons;

    // Individual drop down option buttons (for easy direct access)
    @FindBy(xpath = "//button[normalize-space()='About']")
    private WebElement aboutOptionBtn;

    @FindBy(xpath = "//button[normalize-space()='Support']")
    private WebElement supportOptionBtn;

    @FindBy(xpath = "//button[normalize-space()='Change Password']")
    private WebElement changePasswordOptionBtn;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement logoutOptionBtn;

 

    // ===== Action Methods =====

    /** Click the hamburger menu icon */
    public void clickHamburgerMenu() {
        hamburgerMenuIcon.click();
    }

    /** Get the current bread crumb/module title */
    public static String getBreadcrumbModuleTitle() {
        return  breadcrumbModuleTitle.getText();
    }

    /** Get the user name displayed in the header */
    public String getUserName() {
        return userName.getText();
    }

    /** Open the user drop down */
    public void openUserDropdown() {
        userDropdownTab.click();
    }

    /** Get the profile image src attribute */
    public String getUserProfileImageSrc() {
        return userProfileImage.getAttribute("src");
    }

    /** Check if the user area is displayed */
    public boolean isUserAreaDisplayed() {
        return userArea.isDisplayed();
    }

    /** Check if the user drop down menu is displayed */
    public boolean isUserDropdownMenuDisplayed() {
        return userDropdownMenu.isDisplayed();
    }

    /** Get all visible user drop down menu items' text */
    public List<String> getUserDropdownMenuItemsText() {
        return userDropdownMenuItems.stream().map(WebElement::getText).toList();
    }

    /** Get all actual option button texts (About, Support, Change Password, Logout, etc.) */
    public List<String> getUserDropdownOptionButtonTexts() {
        return userDropdownOptionButtons.stream().map(WebElement::getText).toList();
    }

    /** Click "About" option in drop down */
    public void clickAboutOption() {
        aboutOptionBtn.click();
    }

    /** Click "Support" option in drop down */
    public void clickSupportOption() {
        supportOptionBtn.click();
    }

    /** Click "Change Password" option in drop down */
    public void clickChangePasswordOption() {
        changePasswordOptionBtn.click();
    }

    /** Click "Logout" option in drop down */
    public void clickLogoutOption() {
        logoutOptionBtn.click();
    }

    /**
     * Click a drop down menu item by visible text (case-insensitive, trimmed).
     * Example: "Logout", "Support", "About", etc.
     */
    public void clickUserDropdownMenuItem(String itemText) {
        for (WebElement item : userDropdownMenuItems) {
            if (item.getText().trim().equalsIgnoreCase(itemText.trim())) {
                item.click();
                break;
            }
        }
    }
}
