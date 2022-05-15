package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO open the link
        driver.get("http://automation.techleadacademy.io/#/iframes");

        //TODO In Budget Tracker website: add your name + some numbers
        driver.switchTo().frame("parent-iframe");
        driver.switchTo().frame("budget-tracker");
        driver.findElement(By.xpath("//input[@id='t-name']")).sendKeys("Coffee");
        driver.findElement(By.xpath("//input[@id='t-amount']")).sendKeys("5");
        driver.findElement(By.id("add-btn")).click();

        //TODO capture the total amount
        String total = driver.findElement(By.xpath("//div[@class='total']")).getText();
        System.out.println(total);

        //TODO In Shared Note website input captured data: Title - your name, Transaction - Amount
        driver.switchTo().defaultContent();
        driver.switchTo().frame("note");
        driver.findElement(By.xpath("//input[@class='note-title']")).sendKeys("Yaroslav");
        driver.findElement(By.xpath("//textarea[@class='note-textarea']")).sendKeys(total);

        //TODO click save
        driver.findElement(By.className("save-note")).click();
        Thread.sleep(1000);

        //TODO Find newly entered note in left column and click on it
        driver.findElement(By.xpath("//li[@class='list-group-item']/span[text()='Yaroslav']")).click();
        Thread.sleep(1000);

        //TODO Verify if Title on right section is your name and print out the text
        String noteTitle = driver.findElement(By.xpath("//li/span[text()='Yaroslav']")).getText();
        String name = driver.findElement(By.xpath("//input[@class='note-title']")).getAttribute("value");
        System.out.println(name.equals(noteTitle));

        driver.close();
    }
}
