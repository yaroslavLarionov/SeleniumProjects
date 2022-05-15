import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.xbox.com/en-US/");


        driver.findElement(By.xpath("//button[@id='search']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='search']")).sendKeys(" Deus Ex");
        driver.findElement(By.xpath("//button[@id='search']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/div/h2/span/following-sibling::a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//img[@alt='Deus Ex: Mankind Divided™']")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//div/div/p[@class and @id]")).getText());

        driver.findElement(By.xpath("//ul[@class='Tabs-module__tabTitles___3CCyh']/li/button[text()='REVIEWS']")).click();
        Thread.sleep(2000);
        System.out.println("Game's score is: " + driver.findElement(By.className(".RatingsHistogram-module__rating___2ydeL x-hidden-focus")).getText());

        List<WebElement> reviewsList = driver.findElements(By.cssSelector("p[class*='reviewText']"));
        System.out.println("First review: " + reviewsList.get(0).getText());







        Thread.sleep(2000);
        driver.close();


    }
}
