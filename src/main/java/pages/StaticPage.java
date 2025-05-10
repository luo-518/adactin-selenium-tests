package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class StaticPage extends BasePage {
    
    private By headerLink = By.xpath("//a[@href='index.php']");

        public StaticPage(WebDriver driver) {
        super(driver);
        
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/Register.php");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLink));
    }

    
    public boolean isLoaded() {
        return driver.findElement(headerLink).isDisplayed();
    }
}  
