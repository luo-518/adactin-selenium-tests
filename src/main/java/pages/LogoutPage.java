package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage {
    private By loginAgainLink = By.linkText("Click here to login again");

    public LogoutPage(WebDriver driver) {
        super(driver);
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginAgainLink));
    }

    public LoginPage clickLoginAgain() {
        driver.findElement(loginAgainLink).click();
        return new LoginPage(driver);
    }
}
