package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day01FirefoxDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Selenium");

        Thread.sleep(1000);
        driver.close();
    }
}
