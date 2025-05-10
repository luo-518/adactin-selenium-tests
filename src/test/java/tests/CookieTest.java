package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CookieTest extends BaseTest {

    @Test
    public void testInjectConsentCookie() {
        
        driver.get("https://adactinhotelapp.com/");  

        
        Cookie consent = new Cookie.Builder("consent", "true")
            .domain("adactinhotelapp.com")
            .path("/")
            .isHttpOnly(false)
            .isSecure(true)
            .expiresOn(java.util.Date.from(
                java.time.Instant.now().plus(java.time.Duration.ofDays(3650))
            ))
            .build();
        driver.manage().addCookie(consent);

        
        driver.navigate().refresh();

        
        Cookie got = driver.manage().getCookieNamed("consent");
        assertEquals("true", got.getValue(), "Consent cookie should be present and true");

       
        LoginPage loginPage = new LoginPage(driver);
  
        String title = driver.getTitle();
        assertEquals("Adactin.com - Hotel Reservation System", title);
    }
}

