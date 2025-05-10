package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecurePage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLoginAndTitle() {
        
        String user = System.getenv("TEST_USER");
        String pass = System.getenv("TEST_PASS");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);


        SecurePage secure = new SecurePage(driver);
        String title = secure.getTitle();
        
        assertTrue(title.contains("Search Hotel"),
           "Expected title to contain 'Search Hotel' but was: " + title);
           
        assertTrue( secure.getLoggedInUser().contains("luoluoluo"),
            "username should contains luoluoluo");

    }
}

