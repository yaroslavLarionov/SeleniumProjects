package day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day08ClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO Open "http://automation.techleadacademy.io"
        driver.get("http://automation.techleadacademy.io/#/");

        //TODO Store following info in an Array: First name,Last name,email, phone number, address, city, state, zip code
        String[] info = {"John", "Doe", "jdoe@gmail.com", "650-223-1034", "123 N High Street", "Austin", "23014"};

        //TODO Navigate to "Inputs" page
        driver.findElement(By.xpath("//a[@class='navbar-brand ml-3'][3]")).click();
        Thread.sleep(2000);

        //TODO Fill out "Contact Us Today!" section (using array objects)
        List<WebElement> fields = driver.findElements(By.xpath("//input[@class='form-control' and @type='text']"));
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).sendKeys(info[i]);
        }

        //TODO Click "Send"
        driver.findElement(By.xpath("//button[@name='button3']")).click();
        Thread.sleep(2000);

        //TODO Verify you get "Thanks for contacting us, we will get back to you shortly." message
        System.out.println(driver.findElement(By.xpath("//div[@name='answer3']")).getText().equals("Thanks for contacting us, we will get back to you shortly."));

        driver.close();


    }
}
