package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/home");
        System.out.println(driver.getTitle());

        //getting GU ID (global unique identifier)
        String currentWindow = driver.getWindowHandle();
        Thread.sleep(2000);

        //opening new window
        driver.findElement(By.id("sauce-demo")).click();

        //capturing IDs of all open windows
        Set<String> allWindows = driver.getWindowHandles();

        //switch to second window
        for (String eachWindow : allWindows) {
            if (!eachWindow.equals(currentWindow)) {
                driver.switchTo().window(eachWindow);
            }
        }
        System.out.println(driver.getTitle());  //Swag Labs

        //switch back to previous window
        driver.switchTo().window(currentWindow);

        Thread.sleep(2000);
        driver.quit();
    }
}
