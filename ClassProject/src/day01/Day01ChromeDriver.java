package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01ChromeDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");                //this method will wait until the page loads fully
//        driver.navigate().to("https://amazon.com");   //this method doesn't wait till the page is opened and continues executing next step
//        driver.navigate().to("https://google.com");
//        driver.navigate().back();
//        driver.navigate().forward();

        String url = driver.getCurrentUrl();
        System.out.println("URL is: " + url);
        System.out.println("The title is: " + driver.getTitle());

        WebElement title = driver.findElement(By.id("title"));
        System.out.println(title.getText());


        Thread.sleep(1000);
        driver.close();
    }

}
