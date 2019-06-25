package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BoardPage extends TrelloPageBase {
    private By boardTitle = By.xpath("//span[@class='js-board-editing-target board-header-btn-text']");
    private By btnPermissionLevel = By.cssSelector("#permission-level");

    WebDriverWait wait;

    public BoardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardTitle));
        Assert.assertTrue(driver.findElement(boardTitle).isDisplayed(), "Board page is not opened");
    }

    public String getBoardName() {
        return driver.findElement(By.xpath("//span[@class='js-board-editing-target board-header-btn-text']")).getText();
    }

    public String getBoardPermissionLevel(String boardId) {
        return driver
                .findElement(By.cssSelector("#permission-level .board-header-btn-text"))
                .getText();
    }

    //TODO: complete method
    public String getBoardId() {
        String url = driver.getCurrentUrl();


        return url;
    }

    public boolean isBoardPublic() {
        if (driver.findElement(By.xpath("//span[@class='board-header-btn-text']")).getText().equals("Public"))
            return true;
        else return false;
    }

    public boolean isBoardPrivate() {
        if (driver.findElement(By.xpath("//span[@class='board-header-btn-text']")).getText().equals("Private"))
            return true;
        else return false;
    }
}
