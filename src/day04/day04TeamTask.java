package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class day04TeamTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println("The title of the page: " + driver.getTitle());

        //TODO: Open the webpage, print out main text, print out all Accepted usernames list
        WebElement login = driver.findElement(By.id("login_credentials"));
        System.out.println(login.getText());

        //TODO: input credentials, click login button
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();
        System.out.println("--------------------------------");

        //TODO: print out all names and prices of each item in the list, result should have 6 names with prices
        List<WebElement> itemName = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> itemPrice = driver.findElements(By.className("inventory_item_price"));
        for(int i = 0; i < itemName.size() ; i++) {
            System.out.println(itemName.get(i).getText() + " -> " + itemPrice.get(i).getText());
        }
        System.out.println("--------------------------------");

        //TODO: click first item to open it in separate page
        WebElement firstItem = driver.findElement(By.className("inventory_item_name"));
        firstItem.click();

        //TODO: print out name of the item, description, item price
        WebElement name = driver.findElement(By.className("inventory_details_name"));
        System.out.println("Item's name: " + name.getText());
        WebElement descr = driver.findElement(By.className("inventory_details_desc"));
        System.out.println("Item's description: " + descr.getText());
        WebElement price = driver.findElement(By.className("inventory_details_price"));
        System.out.println("Item's price: " + price.getText());

        //TODO: close the browser
        Thread.sleep(1000);
        driver.close();
    }
}
