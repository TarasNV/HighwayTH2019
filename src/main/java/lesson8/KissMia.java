package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KissMia {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://kismia.com/");
    }

    @Test
    public void loginTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper'][1]/input[@name='email']")));
        driver.findElement(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper'][1]/input[@name='email']")).sendKeys("jodrubirda@desoz.com");
        driver.findElement(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper home-page-form__label-wrapper--last']/input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//a[@class='home-page-form__submit js_submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='new-header__photo']")));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://kismia.com/matches"), "User is not logged in.");
    }

    @AfterTest
    public void turnOff() {
        driver.quit();
    }
}
