package trello.pages.popups;

import trello.pages.TrelloPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.BoardPage;

public class CreateBoardPopup extends TrelloPageBase {

    private By inputBoardTitle = By.cssSelector("[placeholder = \"Add board title\"]");
    private By btnCreateBoard = By.cssSelector("[data-test-id = header-create-board-submit-button]");
    private By btnDropdownPrivacy = By.xpath("//span[@name='private' or @name='public']/..");
    private By btnPrivateOption = By.xpath("//li//span[@name='private']/../..");
    private By btnPublicOption = By.xpath("//li//span[@name='public']/../..");
    private By btnConfirmPublicBoard = By.xpath("//button[text()='Yes, Make Board Public']");

    WebDriverWait wait;


    public CreateBoardPopup(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened() {
        Assert.assertTrue(driver.findElement(btnCreateBoard).isDisplayed(), "Create board popup is not opened");
    }

    public CreateBoardPopup fillBoardTitle(String boardName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(inputBoardTitle));
        driver.findElement(inputBoardTitle).clear();
        driver.findElement(inputBoardTitle).sendKeys(boardName);
        isOpened();
        return this;
    }

    public BoardPage clickCreateBoardButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCreateBoard));
        driver.findElement(btnCreateBoard).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='js-board-editing-target board-header-btn-text']")));
        BoardPage boardPage = new BoardPage(driver);
        boardPage.isOpened();
        return boardPage;
    }

    public CreateBoardPopup selectPrivateOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDropdownPrivacy));
        driver.findElement(btnDropdownPrivacy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPrivateOption));
        driver.findElement(btnPrivateOption).click();
        return this;
    }

    public CreateBoardPopup selectPublicOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDropdownPrivacy));
        driver.findElement(btnDropdownPrivacy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPublicOption));
        driver.findElement(btnPublicOption).click();
        driver.findElement(btnConfirmPublicBoard).click();
        return this;
    }
}
