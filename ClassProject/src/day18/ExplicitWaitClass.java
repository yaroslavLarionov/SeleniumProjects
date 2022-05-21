package day18;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("http://automation.techleadacademy.io/#/synchronization");

        // TODO 1. In "Text Display" section: enter text
       driver.findElement(By.id("input-text")).sendKeys("My text");
       driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

       //TODO wait until it is displayed
       WebElement textBox = driver.findElement(By.id("text-display"));
       wait.until(ExpectedConditions.textToBePresentInElement(textBox, "My text"));

       //TODO print out the displayed text
       System.out.println(textBox.getText());
       System.out.println("------------------------------------------");

       //TODO 2. In "Alert" section: click Display Alert button
        driver.findElement(By.xpath("//button[text()='Display alert']")).click();

        //TODO wait until it displays
        wait.until(ExpectedConditions.alertIsPresent());

        //TODO print out the text of the alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        //TODO 3. In "Weather" section: Input city name
        driver.findElement(By.xpath("//input[@class='form-control m-2']")).sendKeys("Austin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //TODO wait for it to display
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("weather-dashboard")), "Austin"));

        //TODO print out whole displayed info
        System.out.println(driver.findElement(By.id("weather-dashboard")).getText());

        Thread.sleep(3000); //we are using thread sleep to wait and observe the actions
        driver.close();
    }
}
