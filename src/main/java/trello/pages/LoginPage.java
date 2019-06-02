package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class LoginPage {

    private By emailField = By.cssSelector("#user");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void open() {
        driver.get("https://trello.com/login");
    }

    public DashboardPage login(String email, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        //new WebDriverWait(driver, 10).until(ExpectedConditions.)
        return new DashboardPage();
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        if (driver.getCurrentUrl().equals("Logged out of Trello"))
            return true;
        else
            return false;
    }
}
