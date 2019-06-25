package trello;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.BoardPage;
import trello.pages.DashboardPage;

import java.sql.Timestamp;

public class BoardPrivacyTest extends TestBase{

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private DashboardPage dashboardPage;
    private String boardName = "Board " + timestamp;

    @BeforeTest
    public void setUp(){
        dashboardPage = autoLogin("taras.nadtochii@gmail.com", "qwer1234");
    }

    @Test
    public void checkPublicBoardPrivacy() {
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .selectPublicOption()
                .clickCreateBoardButton();
        Assert.assertTrue(boardPage.isBoardPublic(), "Board is not public");

    }

    @Test
    public void checkPrivateBoardPrivacy() {
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .selectPrivateOption()
                .clickCreateBoardButton();
        Assert.assertTrue(boardPage.isBoardPrivate(), "Board is not private");

    }

}
