package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SecurePage;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() throws Exception {
        String user = System.getenv("TEST_USER");
        String pass = System.getenv("TEST_PASS");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);

        SecurePage secure = new SecurePage(driver);
       
        LogoutPage logoutPage = secure.logoutAndGoToLogin();
        LoginPage backToLogin = logoutPage.clickLoginAgain();

        assertTrue(driver.findElement(By.id("username")).isDisplayed(),
                   "Username input should be visible after logout and login-again");
    }
}
