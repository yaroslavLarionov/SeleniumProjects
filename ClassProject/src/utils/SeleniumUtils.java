package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    /**
     * This method will move your view to the given element
     * @param driver is WebDriver object
     * @param element is a WebElement object
     */
    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor jExecutor = (JavascriptExecutor) driver;
        jExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method will highlight an element with yellow color for visibility
     * @param driver is a WebDriver object
     * @param element is a WebElement object
     */
    public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //will move into view first
        scrollIntoView(driver, element);
        // will highlight element in yellow color
        js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
        Thread.sleep(500);
        // will remove the highlight from the element
        js.executeScript("arguments[0].style.backgroundColor=''", element);
    }
    /**
     * This method will use explicit wait
     * @param driver
     * @param element
     */
    public static void waitUntilVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
