package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframesClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/iframes");

        //need to switch to iframe to perform any actions inside of it
        driver.switchTo().frame("parent-iframe");
        System.out.println(driver.findElement(By.id("iframe-text")).getText());

        //to switch to main window  driver.switchTo().defaultContent()

        //now we can interact with WebElements of the main DOM

        //We cannot switch from one iFrame to another (unless they have parent-child relationship)
        //We cannot switch from main window to child iFrame (we have to switch to parent iFrame and then child iFrame)

        //switching to child budget-tracker iFrame
        driver.switchTo().frame("budget-tracker");
        System.out.println(driver.findElement(By.className("total")).getText());

        //switching back to parent iFrame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("iframe-text")).getText());


        driver.close();
    }
}
