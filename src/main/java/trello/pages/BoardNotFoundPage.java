package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BoardNotFoundPage extends TrelloPageBase {

    private By title = By.xpath("//h1[text()='Board not found.']");
    WebDriverWait wait;



    public BoardNotFoundPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void isOpened() {
        Wait wait = new FluentWait(driver);
        Assert.assertTrue(isBoardNotFoundTitleDisplayed(), "BoardNotFound title is not displayed");
    }

    public boolean isBoardNotFoundTitleDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(title));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
