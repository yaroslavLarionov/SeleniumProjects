package day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HackerRankAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO Navigate to the URL
        driver.get("https://www.hackerrank.com/");

        //TODO On the home page click on Login button
        driver.findElement(By.xpath("//li[@id='menu-item-2887']")).click();
        Thread.sleep(2000);

        //TODO Locate and print out Resources section and print out all items
        List<WebElement> list = driver.findElements(By.xpath("//li[@id='menu-item-605']//li"));
        list.forEach(el -> System.out.println(el.getText()));

        //TODO Click on “Company” link
        driver.findElement(By.xpath("//li[@id='menu-item-814']//a")).click();
        Thread.sleep(2000);

        //TODO Click on “View Open Positions” button
        driver.findElement(By.xpath("//a[@class='fl-button' and @href='/careers']")).click();
        Thread.sleep(2000);

        //TODO In the bottom of the page print out all displayed open positions under “Engineering” section
        List<WebElement> jobs = driver.findElements(By.xpath("//ul[@id='departments']//li[@id='12818']//a"));
        jobs.forEach(job -> System.out.println(job.getText()));

        driver.close();


    }
}

