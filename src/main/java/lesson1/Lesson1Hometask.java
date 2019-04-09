package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Lesson 1 Hometask implementation class
 * Log in to Facebook and print last message
 */

public class Lesson1Hometask {

    /**
     * Main method
     * Scenarion:
     * - Open browser
     * - Go to https://www.facebook.com/
     * - Enter Email
     * - Enter Password
     * - Click Log In button
     * - Click Messages button
     * - Print last message displayed in popup
     * - Close browser
     */



    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("taras.nadtochii@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("***");
        driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
        
        driver.findElement(By.xpath("//a[@class='jewelButton _3eo8']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1ijj']/span[2]")));

        WebElement lastMessage = driver.findElement(By.xpath("//div[@class='_1ijj']/span[2]"));

        String lastMessageText = lastMessage.getText();

        System.out.println("Last message: " + lastMessageText);

        driver.quit();


    }
}
