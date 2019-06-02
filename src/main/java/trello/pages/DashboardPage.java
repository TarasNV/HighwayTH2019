package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trello.popups.CreateBoardPopup;

import static core.BrowserFactory.driver;

public class DashboardPage {

    private By btnProfile = By.xpath("//a[@class='header-btn header-avatar js-open-header-member-menu']");
    private By btnLogOut = By.xpath("//a[@class='js-logout']");
    private By btnCreate = By.cssSelector("[data-test-id = header-create-menu-button]");
    private By createBoardMenuItem = By.cssSelector("[data-test-id = header-create-board-button]");
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='header-btn header-avatar js-open-header-member-menu']")));
        return driver.findElement(btnLogOut).isDisplayed();
    }

    public LoggedOutPage logout() {
        driver.findElement(btnProfile).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogOut));
        driver.findElement(btnLogOut).click();
        return new LoggedOutPage();
    }

    public DashboardPage clickCreateButton() {
        driver.findElement(btnCreate).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(createBoardMenuItem));
        driver.findElement(createBoardMenuItem).click();
        return new DashboardPage();
    }

    public CreateBoardPopup clickCreateBoardMenuItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createBoardMenuItem));
        driver.findElement(createBoardMenuItem).click();
        isOpened();
        return new CreateBoardPopup();
    }

}
