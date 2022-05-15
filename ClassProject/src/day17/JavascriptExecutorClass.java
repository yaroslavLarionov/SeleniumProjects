package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumUtils;

public class JavascriptExecutorClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/tables");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement nextButton = driver.findElement(By.xpath("//*[text()='Next']/parent::a"));

        SeleniumUtils.scrollIntoView(driver, nextButton);
        js.executeScript("arguments[0].style.background='yellow'", nextButton);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='iFrames']")).click();

        WebElement footerEl = driver.findElement(By.tagName("footer"));
        SeleniumUtils.scrollIntoView(driver, footerEl);
        Thread.sleep(2000);

        //highlight
        js.executeScript("arguments[0].style.background='red'", footerEl);

        SeleniumUtils.highlightElement(driver, driver.findElement(By.linkText("Alert")));


        Thread.sleep(4000);
        driver.close();
    }
}