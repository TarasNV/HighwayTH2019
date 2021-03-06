package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoggedOutPage extends TrelloPageBase {
    private By loginButton = By.xpath("//a[@class='global-header-section-button']");
    WebDriverWait wait;

    public LoggedOutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), "Loggedout page is not opened");
    }


}
