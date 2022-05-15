package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO  Navigate to "https://www.google.com/"
        driver.get("https://google.com");

        //TODO Input "SDET position" in search bar
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("SDET position");
        Thread.sleep(2000);

        //TODO Click on "Google search"
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        //TODO Click on "100+ more jobs" option
        driver.findElement(By.cssSelector("a.esVihe")).click();
        Thread.sleep(2000);

        //TODO Print out names of companies that are hiring from the list
       List<WebElement> companiesHiring = driver.findElements(By.cssSelector("div[class='PuiEXc'] div[class='vNEEBe']"));
       companiesHiring.forEach(company -> System.out.println(company.getText()));

        driver.close();

    }
}
