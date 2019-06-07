package trello.pages.popups;

import trello.pages.TrelloPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.BoardClosedPage;

public class CloseBoardPopup extends TrelloPageBase {
    private By btnClose = By.cssSelector("input[value = 'Close']");
    private WebDriverWait wait;


    public CloseBoardPopup(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void isOpened() {
        Assert.assertTrue(driver.findElement(btnClose).isDisplayed(), "Close board popup is not opened");
    }

    public BoardClosedPage clickCloseBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnClose));
        driver.findElement(btnClose).click();
        BoardClosedPage boardClosedPage = new BoardClosedPage(driver);
        boardClosedPage.isOpened();
        return boardClosedPage;
    }
}
