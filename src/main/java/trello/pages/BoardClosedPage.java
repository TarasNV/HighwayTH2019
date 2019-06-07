package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.popups.DeleteBoardPopup;

public class BoardClosedPage extends TrelloPageBase {

    private By btnDeleteBoard = By.xpath("//a[text()='Permanently Delete Board…']");
    WebDriverWait wait;


    public BoardClosedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void isOpened() {
        Assert.assertTrue(isDeleteBoardButtonDisplayed(), "Permanently delete board button is not displayed");
    }

    public DeleteBoardPopup clickDeleteBoardBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDeleteBoard));
        driver.findElement(btnDeleteBoard).click();
        DeleteBoardPopup deleteBoardPopup = new DeleteBoardPopup(driver);
        deleteBoardPopup.isOpened();
        return deleteBoardPopup;
    }

    public boolean isDeleteBoardButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnDeleteBoard));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
