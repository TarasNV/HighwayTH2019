package trello;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.DashboardPage;
import trello.pages.LoginPage;

public class CreateAndDeleteTests {

    private LoginPage loginPage = new LoginPage

    @BeforeTest
    public void setUp(){
        loginPage.open();
        DashboardPage dashboardPage = loginPage.login("taras.nadtochii@gmail.com", "123456");
    }

    @Test
    public void createDashboard(){

    }
}
