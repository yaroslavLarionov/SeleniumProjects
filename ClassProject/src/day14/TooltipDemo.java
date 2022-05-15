package day14;

import org.omg.PortableInterceptor.ACTIVE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://etsy.com");

        WebElement tooltip = driver.findElement(By.xpath("//span[@role='tooltip']"));
        System.out.println("First result: " + tooltip.getText());

        WebElement cartButton = driver.findElement(By.xpath("//a[@aria-label='Cart']"));
        //moving to element Cart (for the tooltip to show up
        Actions actions = new Actions(driver);
        actions.moveToElement(cartButton).perform();
        System.out.println("Second result: " + tooltip.getText());

        driver.close();
    }
}
