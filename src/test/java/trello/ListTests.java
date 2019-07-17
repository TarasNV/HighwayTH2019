package trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.pages.BoardPage;
import trello.pages.DashboardPage;

import java.sql.Timestamp;


public class ListTests extends TestBase{

    private DashboardPage dashboardPage;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String boardName = "Board " + timestamp;
    private String listName = "List" + timestamp;

    @BeforeTest
    public void setUp(){
        dashboardPage = autoLogin("taras.nadtochii@gmail.com", "qwer1234");
    }

    @Test
    public void createListTest(){
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .clickCreateBoardButton()
                .addList(listName);
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-list")).getText(), listName, "Created list has wrong name");
    }

    @Test
    public void copyListTest() {
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .clickCreateBoardButton()
                .addList(listName)
                .copyList(listName);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='js-list list-wrapper'][2]//div[@class='list-header-target js-editing-target']")).getText(), listName, "Created list has wrong name");

    }

    @Test
    public void deleteListTest() {
        BoardPage boardPage = dashboardPage
                .clickCreateButton()
                .clickCreateBoardMenuItem()
                .fillBoardTitle(boardName)
                .clickCreateBoardButton()
                .addList(listName)
                .deleteList();
        Assert.assertTrue(boardPage.isBoardBlank(), "List is not deleted");
    }

}
