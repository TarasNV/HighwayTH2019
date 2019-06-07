package trello;

import org.testng.Assert;
import org.testng.annotations.Test;
import trello.pages.DashboardPage;
import trello.pages.LoginPage;

public class LoginTest extends TestBase{

    private static final String USER_NAME = "Taras (taras659)";

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        DashboardPage dashboardPage = loginPage.login("taras.nadtochii@gmail.com", "qwer1234");
        Assert.assertEquals(dashboardPage.getUserName(), USER_NAME, "User is not logged in");
    }

    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        DashboardPage dashboardPage = loginPage.login("taras.nadtochii@gmail.com", "qwer1234");
        Assert.assertEquals(dashboardPage.getUserName(), USER_NAME, "User is not logged in");
        dashboardPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://trello.com/logged-out", "Logged out page is not opened.");
    }
}
