package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
        
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");  
        
        wait.until(webDriver ->
            ((String)((org.openqa.selenium.JavascriptExecutor)webDriver)
                .executeScript("return document.readyState"))
            .equals("complete"));
     }

    public void login(String user, String pass) {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
          driver.findElement(By.name("password")).sendKeys(pass);
        
          driver.findElement(By.name("login")).click();
    }
}

