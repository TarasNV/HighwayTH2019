package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class LoggedOutPage {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private By loginButton = By.xpath("//a[@class='global-header-section-button']");

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='global-header-section-button']")));
        if (driver.findElement(loginButton).isDisplayed())
            return true;
        else
            return false;
    }


}
