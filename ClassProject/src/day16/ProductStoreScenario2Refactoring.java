package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStoreScenario2Refactoring {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        //TODO Click on the Phones link under the categories menu(left side of the page).
        driver.findElement(By.xpath("//a[text()='Phones']")).click();
        Thread.sleep(2000);

        //TODO The page should display 7 items:
        //We are using hash maps because we don't need the insertion order of LinkedHashMap, we just need the comparison of keys and values
        //if we were to use the LinkedHashMap and devs changed something on the page changing the order of items, our test case would have failed
        List<WebElement> items = driver.findElements(By.cssSelector(".card-block"));
        Map<String, String> actualItemMap = new HashMap<>();
        for (WebElement item : items) {
            String actualName = item.findElement(By.tagName("a")).getText();
            String actualPrice = item.findElement(By.tagName("h5")).getText();
            actualItemMap.put(actualName, actualPrice);
        }
        Map<String, String> expectedItemMap = new HashMap<>();
        expectedItemMap.put("Samsung galaxy s6", "$360");
        expectedItemMap.put("Nokia lumia 1520", "$820");
        expectedItemMap.put("Nexus 6", "$650");
        expectedItemMap.put("Samsung galaxy s7", "$800");
        expectedItemMap.put("Iphone 6 32gb", "$790");
        expectedItemMap.put("Sony xperia z5", "$320");
        expectedItemMap.put("HTC One M9", "$700");

        Map<String, String> actualLaptopsMap = new HashMap<>();
        for (WebElement item : items) {
            String actualName = item.findElement(By.tagName("a")).getText();
            String actualPrice = item.findElement(By.tagName("h5")).getText();
            actualItemMap.put(actualName, actualPrice);
        }

        if (expectedItemMap.equals(actualItemMap)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        driver.close();
    }
}