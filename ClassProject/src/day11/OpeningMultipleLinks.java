package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class OpeningMultipleLinks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/home");
        //capture GUID of main window
        String currentWindow = driver.getWindowHandle();

        //opening all 7 windows
        List<WebElement> links = driver.findElements(By.className("link"));
        links.forEach(WebElement::click);

        //capturing GUID of all windows
        Set<String> windowIDs = driver.getWindowHandles();

        //switch to each window and print out title
        for (String eachWindow: windowIDs) {
            if (!eachWindow.equals(currentWindow)) {
                driver.switchTo().window(eachWindow);
                System.out.println(driver.getTitle());
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
