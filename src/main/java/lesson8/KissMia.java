package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KissMia {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        driver.get("https://kismia.com/");
    }

    @AfterTest
    public void turnOff() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        login();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://kismia.com/matches"), "User is not logged in.");
    }

    @Test
    public void changeSexAndAgeTest() {
        login();
        driver.findElement(By.xpath("//div[@class='new-header__photo']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/profile/settings']")));
        driver.findElement(By.xpath("//a[@href='/profile/settings']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tab='profile']/span")));
        driver.findElement(By.xpath("//div[@data-tab='profile']/span")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='settings-path__line'][3]//input[@value='m']")));


        driver.findElement(By.xpath("//div[@class='settings-path__line'][3]//input[@value='m']")).click();
        driver.findElement(By.xpath("//div[@class='settings-path__line'][3]//input[@value='m']")).sendKeys(Keys.RIGHT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='settings-button-block settings-button-block--blue js_saveBlock']/button[@class='button-FR settings__button button--flat-green js_save']")));
        driver.findElement(By.xpath("//div[@class='settings-button-block settings-button-block--blue js_saveBlock']/button[@class='button-FR settings__button button--flat-green js_save']")).click();

        //driver.findElement(By.cssSelector("#year")).;
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper'][1]/input[@name='email']")));
        driver.findElement(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper'][1]/input[@name='email']")).sendKeys("jodrubirda@desoz.com");
        driver.findElement(By.xpath("//form[@class='home-page-form js_signInForm']/div[@class='home-page-form__label-wrapper home-page-form__label-wrapper--last']/input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//a[@class='home-page-form__submit js_submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='new-header__photo']")));
    }
}
