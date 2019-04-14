package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lesson5Practice {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void listOfFilmsOutput() {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        List<WebElement> listOfFilms = driver.findElements(By.cssSelector("ul[class='showtimes-list'] h1 a"));
        for (WebElement element : listOfFilms) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void listOfFieldsFacebookReg() {
        driver.get("https://www.facebook.com/");
        List<WebElement> listOfRequiredInputs = driver.findElements(By.xpath("//input[@aria-required='true']"));
        for (WebElement element : listOfRequiredInputs) {
            System.out.println(element.getText());
        }
        System.out.println(driver.findElement(By.xpath("//div[@class='mtm mbs _2_68']")).getText());
        //TODO: complete task
        System.out.println();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
