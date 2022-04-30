package day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO open the link
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        //TODO Click first Alert button and print out the text
        driver.findElement(By.id("alertBox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        //TODO Click second Alert button and click OK. Then Verify bottom "Popup box output" has text "Your pressed OK in confirmation popup"
        driver.findElement(By.id("confirmBox")).click();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output'][text()='You pressed OK in confirmation popup']")).isDisplayed());

        //TODO Click third Alert, enter your name and verify in "Popup box output" section
        driver.findElement(By.id("promptBox")).click();
        alert.sendKeys("John Doe");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output'][text()='You entered text John Doe in propmt popup']")).isDisplayed());

        Thread.sleep(2000);
        driver.close();
    }
}
