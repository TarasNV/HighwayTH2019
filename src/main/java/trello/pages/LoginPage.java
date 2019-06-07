package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage extends TrelloPageBase {

    private By emailField = By.cssSelector("#user");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.xpath("//input[@id='login']");
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get("https://trello.com/login");
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginPage.isOpened();
        return this;
    }

    public void isOpened() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), "Login page is not opened");
    }

    public DashboardPage login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        DashboardPage dashboardPage = new DashboardPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id = header-member-menu-button]")));
        dashboardPage.isOpened();
        return dashboardPage;
    }
}
