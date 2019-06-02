package trello.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Timestamp;

import static core.BrowserFactory.*;

public class CreateBoardPopup {
    private By inputBoardTitle = By.cssSelector("[placeholder = \"Add board title\"]");
    private By btnCreateBoard = By.cssSelector("[data-test-id = header-create-board-submit-button]");

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputBoardTitle));
        return driver.findElement(inputBoardTitle).isDisplayed();
    }

    public CreateBoardPopup fillBoardTitle() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputBoardTitle));
        driver.findElement(inputBoardTitle).clear();
        driver.findElement(inputBoardTitle).sendKeys("Board " + timestamp);
        return new CreateBoardPopup();
    }

    public
}
