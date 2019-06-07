package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.popups.CloseBoardPopup;

public class BoardMenu extends TrelloPageBase {

    private By boardMenuTitle = By.cssSelector(".board-menu-header-title");
    private By btnMoreMenu = By.cssSelector(".js-open-more");
    private By btnCloseBoard = By.cssSelector(".js-close-board");
    private By btnShowMenu = By.cssSelector(".js-show-sidebar");
    WebDriverWait wait;

    public BoardMenu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened(){
        Assert.assertTrue(driver.findElement(boardMenuTitle).isDisplayed(), "Board menu is not opened");
    }
    public BoardMenu clickMoreMenuButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnMoreMenu));
        driver.findElement(btnMoreMenu).click();
        isOpened();
        return this;
    }

    public CloseBoardPopup clikCloseBoardBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCloseBoard));
        driver.findElement(btnCloseBoard).click();
        CloseBoardPopup closeBoardPopup = new CloseBoardPopup(driver);
        closeBoardPopup.isOpened();
        return closeBoardPopup;
    }
}
