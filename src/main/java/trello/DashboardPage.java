package trello;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class DashboardPage {

    private By profileButton = By.xpath("//a[@class='header-btn header-avatar js-open-header-member-menu']");
    private By logOutButton = By.xpath("//a[@class='js-logout']");
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='header-btn header-avatar js-open-header-member-menu']")));
        if (driver.getTitle().equals("Boards | Trello"))
            return true;
        else
            return false;
    }

    public LoggedOutPage logout() {
        driver.findElement(profileButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        driver.findElement(logOutButton).click();
        return new LoggedOutPage();
    }

}
