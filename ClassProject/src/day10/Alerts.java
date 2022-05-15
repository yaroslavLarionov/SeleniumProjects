package day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/alert");

        //There are 3 types of alert:
        // simple(just one option),
        // prompt(2 options), c
        // onfirmation(we have to type something and then confirm)

        //Alerts cannot be inspected

        //clicking to prompt an alert pop-up window
        driver.findElement(By.className("btn-success")).click();
        Alert alert = driver.switchTo().alert(); //first we need to switch to the alert window and then use one of the methods to dismiss it
        System.out.println(alert.getText());   //to get text of the alert
        alert.accept();
        Thread.sleep(1000);

        driver.findElement(By.className("btn-outline-success")).click();
        System.out.println(alert.getText());
        alert.sendKeys("99");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div/h1[text()='100']")).isDisplayed()); //checking if 2 numbers (1 and 99) were added and are displayed






        driver.close();
    }
}
