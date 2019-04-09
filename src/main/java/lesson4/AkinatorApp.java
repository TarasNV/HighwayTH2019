package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Scanner;

public class AkinatorApp {

    /**
     * Test scenario:
     * - Go to https://ru.akinator.com/
     * - Click Play button
     * - Find and output answer button
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ru.akinator.com/");
        WebElement playButton = driver.findElement(By.xpath("//div[@class='btn-play']"));
        playButton.click();
        int i = 1;

        do {

            WebDriverWait wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='question-number'][text()='" + i + "']")));

            String questionNumber = driver.findElement(By.xpath("//p[@class='question-number']")).getText();
            String questionText = driver.findElement(By.xpath("//p[@class='question-text']")).getText();

            WebElement yesButton = driver.findElement(By.id("a_yes"));
            WebElement noButton = driver.findElement(By.id("a_no"));
            WebElement dontKnowButton = driver.findElement(By.id("a_dont_know"));
            WebElement probablyButton = driver.findElement(By.id("a_probably"));
            WebElement probablyNotButton = driver.findElement(By.id("a_probaly_not"));

            System.out.println(questionNumber + ". " + questionText);
            System.out.println("Enter your answer:\n1 - " + yesButton.getText() + "\n2 - " + noButton.getText() + "\n3 - " + dontKnowButton.getText() + "\n4 - " + probablyButton.getText() + "\n5 - " + probablyNotButton.getText() + "\n0 - End game.");

            boolean checkAnswer = true;
            do {
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();

                switch (answer) {
                    case "1":
                        yesButton.click();
                        checkAnswer = true;
                        break;
                    case "2":
                        noButton.click();
                        checkAnswer = true;
                        break;
                    case "3":
                        dontKnowButton.click();
                        checkAnswer = true;
                        break;
                    case "4":
                        probablyButton.click();
                        checkAnswer = true;
                        break;
                    case "5":
                        probablyNotButton.click();
                        checkAnswer = true;
                        break;
                    case "0":
                        driver.quit();
                        break;
                    default:
                        System.out.println("I don't understand you. Please enter your answer again.");
                        checkAnswer = false;
                        break;
                }

            } while (checkAnswer == false);


            //Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row row_main']")));
            ////div[@class='row row_main']

            List<WebElement> answersList = driver.findElements(By.xpath("//div[@class='database-selection selector dialog-box']/ul/li"));
            if (answersList.size() == 0){
                break;
            }
            else {
                i++;
            }

        }
        while (true);
        String proposalTitle = driver.findElement(By.xpath("//span[@class = 'proposal-title']")).getText();
        System.out.println("Proposal name: " + proposalTitle);
        driver.quit();
    }


}


