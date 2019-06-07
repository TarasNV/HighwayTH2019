package trello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import trello.pages.DashboardPage;
import trello.pages.LoginPage;

public abstract class TestBase {

    public WebDriver driver;


    @BeforeSuite
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void turnOff() {
        driver.quit();
    }

    protected DashboardPage autoLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://trello.com/login");

        return loginPage.login(email, password);
    }

}
