package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePage.BasePage;

/**
 * Page Object Model class for OrangeHRM Login Page
 * All elements are private with corresponding public action methods.
 * Uses PageFactory for element initialization.
 */
public class LoginPage extends BasePage{
	
    // Constructor to initialize elements with PageFactory
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    // Username input field
    @FindBy(name = "username")
    private WebElement usernameInput;

    // Password input field
    @FindBy(name = "password")
    private WebElement passwordInput;

    // Login button
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    // Forgot your password? text/link
    @FindBy(xpath = "//p[contains(@class, 'orangehrm-login-forgot-header')]")
    private WebElement forgotPasswordText;

    // OrangeHRM logo (for assertion/visibility)
    @FindBy(css = "div.orangehrm-login-logo img[alt='orangehrm-logo']")
    private WebElement orangehrmLogo;
    
    @FindBy(className = "orangehrm-login-error")
    private WebElement loginErrorMessage;
    
    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and text()='Required']")
    private WebElement emptyFieldValidationErrorMessage;
    

    // Action Methods

    /**
     * Enter username in the username input field.
     * @param username The username to enter
     */
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * Enter password in the password input field.
     * @param password The password to enter
     */
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Click the login button.
     */
    public void clickLogin() {
        loginButton.click();
    }

    /**
     * Click the "Forgot your password?" link/text.
     */
    public void clickForgotPassword() {
        forgotPasswordText.click();
    }

    /**
     * Check if the OrangeHRM logo is displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isLogoDisplayed() {
        return orangehrmLogo.isDisplayed();
    }
    /**
     * Login with provided username and password
     * @param username The username
     * @param password The password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    /*to check if error message is displayed successfully
     * on login attempt with in valid credentials.
     */


	public boolean isInvalidCredentialsErrorDisplayed() {
		// TODO Auto-generated method stub
		return loginErrorMessage.isDisplayed();
	}

	public boolean isRequiredErrorDisplayed() {
		// TODO Auto-generated method stub
		return emptyFieldValidationErrorMessage.isDisplayed();
	}
    
    
}
