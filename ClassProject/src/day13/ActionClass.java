package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/actionclass");

        Actions actions = new Actions(driver);

        WebElement buttonHover = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg m-2']"));
        actions.moveToElement(buttonHover).perform();

        WebElement doubleClick = driver.findElement(By.xpath("//button[@class='btn btn-warning m-2 btn-lg']"));
        actions.moveToElement(doubleClick).doubleClick().perform();

        Thread.sleep(3000);
        driver.close();


    }
}
