package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShawshankRedemptionInfo {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Method that outputs info about Shawshank Redemption film
     */
    @Test
    public void displayFilmInfo(){
        driver.get("https://www.imdb.com/title/tt0111161/");
        String filmTitle = driver.findElement(By.xpath("//div[@class = 'title_wrapper']/h1")).getText();
        System.out.println("Film title: " + filmTitle);

        String releaseYear = driver.findElement(By.xpath("//div[@class = 'title_wrapper']/h1/span/a")).getText();
        System.out.println("Film release year: " + releaseYear);

        String filmTime = driver.findElement(By.xpath("//div[@class = 'title_wrapper']//time")).getText();
        filmTime = filmTime.replaceAll("[^0-9]+", "");
        Integer filmTimeInMin = Integer.parseInt(filmTime);
        filmTimeInMin = filmTimeToMinutes(filmTimeInMin);
        System.out.println("Duration in minutes: " + filmTimeInMin);
        System.out.println("Duration in seconds: " + filmTimeInMin*60);

        String filmRating = driver.findElement(By.xpath("//span[@itemprop='ratingValue']")).getText();
        System.out.println("Film rating: " + filmRating);

        String filmGenre = driver.findElement(By.xpath("//div[@class = 'title_wrapper']/div[@class='subtext']/a[1]")).getText();
        System.out.println("Genre: " + filmGenre);

        String teaserLink = driver.findElement(By.xpath("//div[@class='slate']/a")).getAttribute("href");
        System.out.println("Link to teaser: " + teaserLink);

        String posterLink = driver.findElement(By.xpath("//div[@class='poster']/a")).getAttribute("href");
        System.out.println("Link to poster: " + posterLink);

        String filmDirector = driver.findElement(By.xpath("//div[@class='plot_summary ']/div[@class='credit_summary_item'][1]/a[1]")).getText();
        System.out.println("Director: " + filmDirector);

        List<WebElement> castList = driver.findElements(By.xpath("//table[@class='cast_list']//td[2]/a"));
        int i = 0;
        System.out.print("Cast: ");
        for (WebElement element : castList) {
            System.out.print(element.getText());
            i++;
            if (i < 5) {
                System.out.print(", ");
            }
            else {
                System.out.println(".");
                break;
            }
        }

        String metascoreRating = driver.findElement(By.xpath("//div[@class='metacriticScore score_favorable titleReviewBarSubItem']/span")).getText();
        System.out.println("Metascore rating: " + metascoreRating);

        String userReviewsNumberText = driver.findElement(By.xpath("//div[@class='titleReviewBarItem titleReviewbarItemBorder']//span/a[1]")).getText();
        userReviewsNumberText = userReviewsNumberText.replaceAll("[^0-9]+", "");
        System.out.println("User reviews: " + userReviewsNumberText);

        String criticsReviewsNumberText = driver.findElement(By.xpath("//div[@class='titleReviewBarItem titleReviewbarItemBorder']//span/a[2]")).getText();
        criticsReviewsNumberText = criticsReviewsNumberText.replaceAll("[^0-9]+", "");
        System.out.println("Critics reviews: " + criticsReviewsNumberText);

        Integer userReviewsInt = Integer.parseInt(userReviewsNumberText);
        Integer criticsReviewsInt = Integer.parseInt(criticsReviewsNumberText);
        System.out.println("Sum of users and critics reviews: " + (userReviewsInt + criticsReviewsInt));

        List<WebElement> recommendList = driver.findElements(By.xpath("//div[contains(@class,'rec_item')]//img"));
        System.out.print("Recommended films list: ");
        i = 0;
        for (WebElement element : recommendList) {
            System.out.print(element.getAttribute("alt"));
            i++;
            if (i < 3){
                System.out.print(", ");
            }
            else {
                System.out.println(".");
                break;
            }
        }
    }

    public int filmTimeToMinutes(int i) {
        int filmTimeMin = (i / 100)*60 + (i % 100);
        return filmTimeMin;
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
