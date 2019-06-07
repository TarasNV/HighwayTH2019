package trello;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.BoardMenu;
import trello.pages.BoardNotFoundPage;
import trello.pages.BoardPage;
import trello.pages.DashboardPage;

import java.sql.Timestamp;

public class CreateAndDeleteBoardTests extends TestBase{

    private DashboardPage dashboardPage;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String boardName = "Board " + timestamp;

    @BeforeTest
    public void setUp(){
        dashboardPage = autoLogin("taras.nadtochii@gmail.com", "qwer1234");
    }

    @Test
    public void createBoard(){
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .clickCreateBoardButton();
        Assert.assertEquals(boardPage.getBoardName(), boardName, "BoardPage is not opened");
    }

    @Test
    public void deleteTest() {
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .clickCreateBoardButton();
        BoardMenu boardMenu = new BoardMenu(driver);
        BoardNotFoundPage boardPageAfterDelete = boardMenu
                .clickMoreMenuButton()
                .clikCloseBoardBtn()
                .clickCloseBtn()
                .clickDeleteBoardBtn()
                .clickDeleteBtn();
    }
}
