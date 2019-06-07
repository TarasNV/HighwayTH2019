package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends TrelloPageBase {

    private By boardsSidebarItem = By.xpath("//nav[@class='home-left-sidebar-container']//span[text()='Boards']");
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void isOpened(){
        Assert.assertTrue(driver.findElement(boardsSidebarItem).isDisplayed(), "Home page is not opened");
    }

}
