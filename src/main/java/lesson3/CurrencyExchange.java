package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CurrencyExchange {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cyrrencyInfo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //collect currency values from Privat Bank
        driver.get("https://www.privat24.ua/");
        String privatCurrency = driver.findElement(By.xpath("//div[contains(@class, 'type')][text()='USD']/../div[contains(@class,'rate')]")).getText();
        privatCurrency = privatCurrency.replace(" / ", " ");
        String[] values = privatCurrency.split(" ");
        double privatBuyUSD = Double.parseDouble(values[0]);
        double privatSellUSD = Double.parseDouble(values[1]);System.out.println("Privat buy course: " + privatBuyUSD + "\nPrivat sell course: " + privatSellUSD);

        //collect currency values from Ukrsib Bank
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String ukrsibBuy = driver.findElement(By.xpath("//table[@class='currency__table']//tbody//tr[1]/td[2]")).getText();
        double ukrsibBuyUSD = Double.parseDouble(ukrsibBuy);
        String ukrsibSell = driver.findElement(By.xpath("//table[@class='currency__table']//tbody//tr[1]/td[3]")).getText();
        double ukrsibSellUSD = Double.parseDouble(ukrsibSell);

        //collect currency values from UniversalBank
        driver.get("https://www.universalbank.com.ua/");
        String universalBuy = driver.findElement(By.xpath("//div[contains(@class,'currencies-list')]/div[1]//table[contains(@class,'rate')][1]//tr[2]/td[2]")).getText();
        double universalBuyUSD = Double.parseDouble(universalBuy);
        String universalSell = driver.findElement(By.xpath("//div[contains(@class,'currencies-list')]/div[1]//table[contains(@class,'rate')][1]//tr[2]/td[3]")).getText();
        double universalSellUSD = Double.parseDouble(universalSell);

        //collect currency values from Oschad Bank
        driver.get("https://www.oschadbank.ua/ua");
        String oschadBuy = driver.findElement(By.cssSelector(".buy-USD")).getText();
        double oschadBuyUSD = Double.parseDouble(oschadBuy);
        String oschadSell = driver.findElement(By.cssSelector(".sell-USD")).getText();
        double oschadSellUSD = Double.parseDouble(oschadSell);

        //collect currency values from
        driver.get("https://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Долар США']/../td[5]")));
        String nbuBuyFor100 = driver.findElement(By.xpath("//td[text()='Долар США']/../td[5]")).getText();
        double nbuUSD = Double.parseDouble(nbuBuyFor100)/100;

        //3. Посчитать средний курс валют, отдельно, покупки и продажи между всеми банками (вывести в консоль)
        double avarageBuyUSD = (privatBuyUSD + ukrsibBuyUSD + universalBuyUSD + oschadBuyUSD + nbuUSD) / 5;
        double avarageSellUSD = (privatSellUSD + ukrsibSellUSD + universalSellUSD + oschadSellUSD + nbuUSD) / 5;
        System.out.println("Average USD exchange rate BUY: " + avarageBuyUSD);
        System.out.println("Average USD exchange rate SELL: " + avarageSellUSD);

        //4. Вывести в консоль банк с самым низким курсом покупки доллара
        //5. Вывести в консоль банк с самым высоким курсом продажи
        String[] banks = {"Privat Bank", "Ukrsib Bank", "Universal Bank", "Oschad Bank", "NBU"};
        double[] USDBuyRate = {privatBuyUSD, ukrsibBuyUSD, universalBuyUSD, oschadBuyUSD, nbuUSD};
        double[] USDSellRate = {privatSellUSD, ukrsibSellUSD, universalSellUSD, oschadSellUSD, nbuUSD};
        double minBuyRate = USDBuyRate[0];
        int minBuyBankId = 0;
        double maxSellRate = USDSellRate[0];
        int maxBuyBankId = 0;

        for (int i = 0; i < USDBuyRate.length; i++) {
            if (USDBuyRate[i] < minBuyRate) {
                minBuyRate = USDBuyRate[i];
                minBuyBankId = i;
            }
        }

        for (int j = 0; j < USDSellRate.length; j++) {
            if (USDSellRate[j] > maxSellRate) {
                maxSellRate = USDSellRate[j];
                maxBuyBankId = j;
            }
        }

        System.out.println("Bank with lowest buy rate: " + banks[minBuyBankId] + ". Rate value: " + minBuyRate);
        System.out.println("Bank with highest buy rate: " + banks[maxBuyBankId] + ". Rate value: " + maxSellRate);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
