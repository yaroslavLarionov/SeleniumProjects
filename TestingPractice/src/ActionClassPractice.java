import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClassPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        WebElement text = driver.findElement(By.xpath("//div/div/h2[@class='a-color-base headline truncate-2line']"));
        Actions actions = new Actions(driver);
        Action copyText = actions.moveToElement(text).click().doubleClick().keyDown(Keys.CONTROL).sendKeys("C").release().build();
        copyText.perform();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //actions.moveToElement(searchBox).click().keyDown(Keys.CONTROL).sendKeys("v").release().sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        Action typeName = actions.moveToElement(searchBox).click().sendKeys("Yaroslav").build();
        typeName.perform();




        Thread.sleep(2000);
        driver.close();
    }
}
