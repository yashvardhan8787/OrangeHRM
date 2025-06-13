package baseTest;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseTest {

    public static WebDriver driver;
    public static Logger logger;
    public Properties p;

    @BeforeSuite
    @Parameters({"OS", "browser"})
    public void setUp(String OS, String br) throws IOException {
        p = new Properties();
        FileReader file = new FileReader("src/test/resources/config.properties");
        p.load(file);
        
        logger = LogManager.getLogger(this.getClass());

        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + br);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("AppUrl"));
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
