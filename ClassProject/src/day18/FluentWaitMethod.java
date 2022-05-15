package day18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 25);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("test"))))

        driver.get("http://automation.techleadacademy.io/#/synchronization");
        Thread.sleep(2000);

        fluentWait(driver, By.id("test"));

       SeleniumUtils.waitUntilVisible(driver, driver.findElement(By.id("test")));

        Thread.sleep(2000);
        driver.close();

    }

    public static WebElement fluentWait(WebDriver driver, By locator) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.withMessage("Waited for 15 seconds to find element --> " + locator.toString());

        WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }
}