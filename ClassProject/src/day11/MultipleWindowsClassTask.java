package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class MultipleWindowsClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO open the link
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        //TODO print out 3 text of 3 buttons
        List<WebElement> list = driver.findElements(By.className("mr-3"));
        list.forEach(el -> System.out.println(el.getText()));

        //TODO open Facebook link
        String currentWindow = driver.getWindowHandle();
        list.get(list.size() - 1).click();

        //TODO  print out "Connect with friend and the world..." text
        switchToNextWindow(driver);
        System.out.println(driver.findElement(By.xpath("//div/h2")).getText());

        //TODO Close facebook window
        driver.close();

        //TODO return to main window (tla practice website)
        driver.switchTo().window(currentWindow);

        //TODO open Google link
        list.get(1).click();

        //TODO print out title of the Google page
        switchToNextWindow(driver);
        System.out.println(driver.getTitle());

        //TODO Click Launch TLA
        driver.close();
        driver.switchTo().window(currentWindow);
        list.get(0).click();

        //TODO Print out text of navigation bar buttons
        switchToNextWindow(driver);
        driver.manage().window().maximize();
        List<WebElement> navElements = driver.findElements(By.xpath("//div[@id='lp-pom-box-346']//a"));
        navElements.forEach(el -> System.out.println(el.getText()));

        driver.quit();
    }
    public static void switchToNextWindow(WebDriver driver){
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow : allWindows) {
            if (!eachWindow.equals(currentWindow)) {
                driver.switchTo().window(eachWindow);
            }
        }
    }
}
