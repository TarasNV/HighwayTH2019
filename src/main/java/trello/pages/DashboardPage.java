package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trello.pages.popups.CreateBoardPopup;

public class DashboardPage extends TrelloPageBase {

    private By btnProfile = By.cssSelector("[data-test-id = header-member-menu-button]");
    private By btnLogOut = By.cssSelector("[data-test-id = header-member-menu-logout]");
    private By btnCreate = By.cssSelector("[data-test-id = header-create-menu-button]");
    private By createBoardMenuItem = By.cssSelector("[data-test-id = header-create-board-button]");
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened() {
        Assert.assertTrue(driver.findElement(btnProfile).isDisplayed(), "Dashboard page is not opened");
    }

    public LoggedOutPage logout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProfile));
        driver.findElement(btnProfile).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogOut));
        driver.findElement(btnLogOut).click();
        LoggedOutPage loggedOutPage = new LoggedOutPage(driver);
        loggedOutPage.isOpened();
        return loggedOutPage;
    }

    public DashboardPage clickCreateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCreate));
        driver.findElement(btnCreate).click();
        isOpened();
        return this;
    }

    public CreateBoardPopup clickCreateBoardMenuItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createBoardMenuItem));
        driver.findElement(createBoardMenuItem).click();
        CreateBoardPopup createBoardPopup = new CreateBoardPopup(driver);
        createBoardPopup.isOpened();
        return createBoardPopup;
    }

    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProfile));
        String userName = driver.findElement(By.xpath("//button[@data-test-id = 'header-member-menu-button']")).getAttribute("title");
        return userName;
    }

}
