package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.List;

public class CinemaHallSeats {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Pre-conditions:
     * - Open browser
     * Scenario:
     * - Open http://liniakino.com/showtimes/aladdin/
     * - Select the nearest session of "Dambo" film
     * - Open the hall scheme
     * - Calculate number of seats: number of all seats, occupied seats, free seats, % of free seats to all, % of occupied seats to all
     * - Print results to console
     */

    @Test
    public  void seatsInfo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://liniakino.com/showtimes/aladdin/");

        WebElement damboSessionLink = driver.findElement(By.xpath("//a[text()='Дамбо']/../..//div[@class='day-block showtime-day'][1]//li[1]/a"));
        damboSessionLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hall-scheme-container div.seat")));
        List<WebElement> listOfSeats = driver.findElements(By.cssSelector("#hall-scheme-container div.seat"));

        System.out.println("Number of all seats: " + listOfSeats.size());
        List<WebElement> occupiedSeatsList = driver.findElements(By.cssSelector("#hall-scheme-container div.seat-occupied"));
        System.out.println("Occupied seats number: " + occupiedSeatsList.size());
        System.out.println("Free seats number: " + (listOfSeats.size() - occupiedSeatsList.size()));
        System.out.println("Percent of occupied seats: " + (new DecimalFormat("##.##").format((double)(occupiedSeatsList.size()*100)/(double)listOfSeats.size())));
        System.out.println("Percent of free seats: " + (new DecimalFormat("##.##").format((double)((listOfSeats.size() - occupiedSeatsList.size())*100)/(double)listOfSeats.size())));

    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
