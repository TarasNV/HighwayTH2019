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
    private By btnCreateNewList = By.xpath("//a[@class='open-add-list js-open-add-list']/span");
    private By listNameInput = By.cssSelector(".list-name-input");
    private By btnAddList = By.cssSelector(".mod-list-add-button");
    private By btnListMoreMenu = By.cssSelector(".list-header-extras-menu");
    private By copyListMenuItem = By.xpath("//a[text()='Copy List…']");
    private By copyListName = By.cssSelector(".pop-over-content .js-autofocus");
    private By btnCopyCreateList = By.xpath("//input[@value='Create List']");
    private By archiveListMenuItem = By.xpath("//a[text()='Archive This List']");
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

    public BoardPage addList(String listName) {
        driver.findElement(btnCreateNewList).click();
        driver.findElement(listNameInput).sendKeys(listName);
        driver.findElement(btnAddList).click();
        this.isOpened();
        return this;
    }

    public BoardPage copyList(String listName){
        driver.findElement(btnListMoreMenu).click();
        driver.findElement(copyListMenuItem).click();
        driver.findElement(copyListName).sendKeys(listName);
        driver.findElement(btnCopyCreateList);
        this.isOpened();
        return this;
    }

    public BoardPage deleteList() {
        driver.findElement(btnListMoreMenu).click();
        driver.findElement(archiveListMenuItem).click();
        this.isOpened();
        return this;
    }

    public boolean isBoardBlank() {
        if (driver.findElements(By.cssSelector(".js-list")).isEmpty()) {
            return true;
        } else return false;
    }
}
