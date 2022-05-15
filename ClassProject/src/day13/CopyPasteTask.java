package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/iframes");


        //TODO Copy "Hello! I am the parent iFrame" text using Actions class
        Actions actions = new Actions(driver);
        driver.switchTo().frame("parent-iframe");
        WebElement text = driver.findElement(By.id("iframe-text"));
        // don't use release() after keyDown(Keys.CONTROL) or it will paste text if you use actions for something else
        actions.click(text).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        //TODO in shared notes type your name and paste the result
        driver.switchTo().defaultContent();
        driver.switchTo().frame("note");

        WebElement nameField = driver.findElement(By.xpath("//input[@class='note-title']"));
        WebElement inputField = driver.findElement(By.xpath("//textarea[@class='note-textarea']"));
        actions.sendKeys(nameField,"Yaroslav").perform();
        actions.click(inputField).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        actions.click(driver.findElement(By.className("save-note"))).perform();

        Thread.sleep(2000);
        driver.close();



    }
}
