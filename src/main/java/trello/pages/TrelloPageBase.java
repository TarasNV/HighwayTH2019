package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class TrelloPageBase {
    public WebDriver driver;
    WebDriverWait wait;
    private By btnHome = By.cssSelector("[aria-label = 'Back to Home']");

    public HomePage clickHomeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnHome));
        driver.findElement(btnHome).click();
        HomePage homePage = new HomePage(driver);
        homePage.isOpened();
        return homePage;
    }

    public abstract void isOpened();
}
