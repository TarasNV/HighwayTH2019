package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
