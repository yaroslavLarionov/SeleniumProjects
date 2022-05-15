package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchXpathOnlyTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO  Navigate to "https://www.google.com/"
        driver.get("https://google.com");

        //TODO Input "SDET position" in search bar
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("SDET position");
        Thread.sleep(2000);

        //TODO Click on "Google search"
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        Thread.sleep(2000);

        //TODO Click on "100+ more jobs" option
        driver.findElement(By.xpath("//a[@class='esVihe']")).click();
        Thread.sleep(2000);

        //TODO Print out names of companies that are hiring from the list
        List<WebElement> listOfCompanies = driver.findElements(By.xpath("//div[@class='vNEEBe']"));
        listOfCompanies.forEach(companyName -> System.out.println(companyName.getText()));

        driver.close();


    }
}
