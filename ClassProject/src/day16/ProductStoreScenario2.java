package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStoreScenario2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        //TODO Click on the Phones link under the categories menu(left side of the page).
        driver.findElement(By.xpath("//a[text()='Phones']")).click();
        Thread.sleep(2000);

        //TODO The page should display 7 items:
        List<WebElement> items = driver.findElements(By.cssSelector(".card-block"));
        List<String> expectedItemNames = Arrays.asList(
                "Samsung galaxy s6",
                "Nokia lumia 1520",
                "Nexus 6",
                "Samsung galaxy s7",
                "Iphone 6 32gb",
                "Sony xperia z5",
                "HTC One M9");
        List<String> expectedItemPrice = Arrays.asList(
                "$360",
                "$820",
                "$650",
                "$800",
                "$790",
                "$320",
                "$700");
        System.out.println("actual size: " + items.size());
        System.out.println("expected size: " + expectedItemNames.size());
        if (expectedItemNames.size() != items.size()) {
            System.out.println("failed");
            driver.close();
            return;
        }
        for (int i = 0; i < expectedItemNames.size(); i++) {
            WebElement item = items.get(i);
            String itemName = item.findElement(By.tagName("a")).getText();
            String itemPrice = item.findElement(By.tagName("h5")).getText();

            String expectedName = expectedItemNames.get(i);
            String expectedPrice = expectedItemPrice.get(i);

            System.out.println("actual: " + itemName + " | " + itemPrice + ", expected: " + expectedName + " | " + expectedPrice);
            if (!(expectedName.equals(itemName) && expectedPrice.equals(itemPrice))) {
                System.out.println("failed");
                driver.close();
                return;
            }
        }
        System.out.println("pass");
        System.out.println("----------------------");

        //TODO Click on the Laptop link under the categories menu(left side of the page).
        // Laptops
        Map<String, String> actualItems = getActualItems(driver, "Laptops");
        Map<String, String> expectedItems = new HashMap<>();
        expectedItems.put("Sony vaio i5", "$790");
        expectedItems.put("Sony vaio i7", "$790");
        expectedItems.put("MacBook air", "$700");
        expectedItems.put("Dell i7 8gb", "$700");
        expectedItems.put("2017 Dell 15.6 Inch", "$700");
        expectedItems.put("MacBook Pro", "$1100");

        System.out.println(actualItems);
        System.out.println(expectedItems);
        if (expectedItems.equals(actualItems)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        System.out.println("------");

        // Monitors
        actualItems = getActualItems(driver, "Monitors");
        expectedItems = new HashMap<>();
        expectedItems.put("Apple monitor 24", "$400");
        expectedItems.put("ASUS Full HD", "$230");

        System.out.println(actualItems);
        System.out.println(expectedItems);
        if (expectedItems.equals(actualItems)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        driver.close();
    }

    public static Map<String, String> getActualItems(WebDriver driver, String category) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='" + category + "']")).click();
        Thread.sleep(2000);

        List<WebElement> itmes = driver.findElements(By.cssSelector(".card-block"));
        Map<String, String> actualItems = new HashMap<>();
        for (WebElement item : itmes) {
            String itemName = item.findElement(By.tagName("a")).getText();
            String itemPrice = item.findElement(By.tagName("h5")).getText();
            actualItems.put(itemName, itemPrice);
        }

        return actualItems;
    }
}