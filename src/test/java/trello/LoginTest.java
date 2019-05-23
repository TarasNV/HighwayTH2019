package trello;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        DashboardPage dashboardPage = loginPage.login("taras.nadtochii@gmail.com", "qwer1234");
        Assert.assertTrue(dashboardPage.isOpened(), "Dashboard page is not opened. User is not logged in.");
    }

    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        DashboardPage dashboardPage = loginPage.login("taras.nadtochii@gmail.com", "qwer1234");
        Assert.assertTrue(dashboardPage.isOpened(), "Dashboard page is not opened. User is not logged in.");
        LoggedOutPage loggedOutPage = dashboardPage.logout();
        Assert.assertTrue(loggedOutPage.isOpened(), "Logged out page is not opened.");
    }
}
