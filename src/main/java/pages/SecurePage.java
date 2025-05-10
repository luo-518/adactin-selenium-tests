package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SecurePage extends BasePage {
    
    private By logoutBtn = By.xpath("//td[@class='welcome_menu']//a[@href='Logout.php']");
   
    private By userGreeting = By.id("username_show");

    public SecurePage(WebDriver driver) {
        super(driver);
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//td[@class='welcome_menu']")));
        
        wait.until(ExpectedConditions.titleContains("Search Hotel"));
    }

   
    public String getLoggedInUser() {
        return driver.findElement(userGreeting).getAttribute("value");
    }

    public LogoutPage logoutAndGoToLogin() {
       
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
        return new LogoutPage(driver);
    }
}
