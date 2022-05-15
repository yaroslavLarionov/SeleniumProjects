package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");
        WebElement element1 = driver.findElement(By.id("links-header"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.id("php-travels"));
        System.out.println(element2.getText());

        WebElement el3 = driver.findElement(By.id("mercury-tours"));
        System.out.println(el3.getText());

        WebElement classEl = driver.findElement(By.className("row"));
        System.out.println(classEl.getText());


        Thread.sleep(1000);
        driver.close();

    }
}
