package day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SynchronizationClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //default wait time for Selenium is 500 miliseconds and implicitlyWait overrides it
        //if the element is found before implicitly wait time, selenium moves to the next step without fully waiting fore the given time
        //exception will be thrown after given implicitly wait time is reached
        //its only applicable to findElement() and findElements() methods
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://automation.techleadacademy.io/#/tables");
    }

}
