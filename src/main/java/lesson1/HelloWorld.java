package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelloWorld {
    public WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

    }

    @Test(dependsOnMethods = "method1")
    public static String fullName(String name, String secondName) {
        boolean flag  = true;
        while(true) {
            if (flag)
                break;
        }
        return name + " " + secondName;

    }



}
