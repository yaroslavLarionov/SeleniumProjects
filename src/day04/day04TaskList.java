package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day04TaskList {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automation.techleadacademy.io/#/");

        List<WebElement> allBtns = driver.findElements(By.className("link"));
        allBtns.forEach(element -> System.out.println(element.getText()));

        System.out.println(allBtns.get(4).getAttribute("href"));
//        WebElement hrefValue = driver.findElement(By.id("passion-tea-company"));
//        System.out.println(hrefValue.getAttribute("href"));

        Thread.sleep(1000);
        driver.close();
    }
}
