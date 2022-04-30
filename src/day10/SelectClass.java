package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/selectclass");

        Select select = new Select(driver.findElement(By.name("select1")));
        select.selectByVisibleText("Three");
        select.selectByValue("Seven");

        List<WebElement> allOptions = select.getOptions();
        System.out.println(allOptions.size());        //10
        allOptions.forEach(el -> System.out.println(el.getText()));
        System.out.println("-----------------------");

        Select select2 = new Select(driver.findElement(By.name("select2")));
        List<WebElement> colors = select2.getOptions();
        colors.forEach(el -> System.out.println(el.getText()));

        select2.selectByValue("Yellow");
        Thread.sleep(1000);
        System.out.println("----------------------");

        //If there is no select tag for us to use , we need to use click() and then css,xpath selector and click() again
        driver.findElement(By.className("btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-item' and text()='Run']")).click();
        Thread.sleep(1000);

        Select select3 = new Select(driver.findElement(By.id("cars")));
        Thread.sleep(1000);
        select3.selectByVisibleText("SDET");
        Thread.sleep(1000);
        select3.selectByIndex(4);
        select3.selectByValue("Director");
        Thread.sleep(1000);

        //we can also use deselect() any options or all as well
        //TODO Click Home and Verify text "You have clicked -- Home -- button" is displayed
        driver.findElement(By.xpath("//ul[@class='main-navigation']//a[text()='Home']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h4/b[text()='Home']")).isDisplayed());
        Thread.sleep(1000);

        //TODO Click WordPress Development -> Plugins AND Verify text "You have clicked -- Plugins -- button" is displayed
        driver.findElement(By.xpath("//li/a[text()='WordPress Development']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li/a[text()='Plugins']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h4/b[text()='Plugins']")).isDisplayed());

        driver.close();
    }
}
