package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();        
        options.addArguments("--headless");                   
        options.addArguments("--no-sandbox");                
        options.addArguments("--disable-gpu");                
        options.addArguments("--window-size=1280,1024");      
        options.addArguments("--incognito");                  
        options.addArguments("--disable-notifications");      
        options.setAcceptInsecureCerts(true);                 
        String remoteUrl = System.getenv("WEBDRIVER_REMOTE_URL");
        if (remoteUrl == null || remoteUrl.isEmpty()) {
            remoteUrl = "http://selenium:4444/wd/hub";
        }
        driver = new RemoteWebDriver(new URL(remoteUrl), options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
