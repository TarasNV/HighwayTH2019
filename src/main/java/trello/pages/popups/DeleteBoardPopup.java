package trello.pages.popups;

import trello.pages.TrelloPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.BoardNotFoundPage;

public class DeleteBoardPopup extends TrelloPageBase {

    private By btnDelete = By.cssSelector("input[value='Delete']");
    private WebDriverWait wait;


    public DeleteBoardPopup(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void isOpened() {
        Assert.assertTrue(driver.findElement(btnDelete).isDisplayed(), "Delete board popup is not displayed");
    }

    public BoardNotFoundPage clickDeleteBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDelete));
        driver.findElement(btnDelete).click();
        BoardNotFoundPage boardNotFoundPage = new BoardNotFoundPage(driver);
        boardNotFoundPage.isOpened();
        return boardNotFoundPage;
    }
}
