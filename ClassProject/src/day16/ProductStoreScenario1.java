package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductStoreScenario1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        //TODO Validate header menu. Expected menu list: Home, Contact, About us, Cart, Log in, Sign up
        List<WebElement> menuList = driver.findElements(By.cssSelector("ul>li>a"));
        System.out.println("Menu items: " + menuList.size());
        List <String> menuListTxt = new ArrayList<>();
        for (WebElement menuLink : menuList) {
            if (menuLink.isDisplayed()) {
                String txt = menuLink.getText().trim();
                txt = txt.contains("(current)") ? txt.split("\n")[0].trim() : txt;
                menuListTxt.add(txt);
            }
        }
        List<String> expectedMenuList = Arrays.asList("Home", "Contact", "About us", "Cart", "Log in", "Sign up");
        System.out.println("actual menu list: " + menuListTxt);
        System.out.println("expected menu list: " + expectedMenuList);
        if (expectedMenuList.equals(menuListTxt)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }
        System.out.println("-------");

        //TODO Validate the Categories links on the left side of the page. Expected list: Phones, Laptops, Monitors
        List<WebElement> actualCategoryList = driver.findElements(By.cssSelector("div>a[id='itemc']"));
        List<String> expectedCategoryList = Arrays.asList("Phones", "Laptops", "Monitors");
        for (int i = 0; i < actualCategoryList.size(); i++) {
            if (expectedCategoryList.get(i).equals(actualCategoryList.get(i).getText())) {
                System.out.println("pass");
            } else {
                System.out.println("failed");
            }
        }
        System.out.println("-------");

        //TODO Validate that there are 9 items displayed and print their name and price in the new line.
        //option #1
        List<WebElement> itemsList = driver.findElements(By.cssSelector(".hrefch"));
        List<WebElement> itemsPrices = driver.findElements(By.cssSelector(".card-block>h5"));
        Thread.sleep(1000);
        if (itemsList.size() == 9) {
            for (int i = 0; i < itemsList.size(); i++) {
                System.out.println(itemsList.get(i).getText() + " | " + itemsPrices.get(i).getText());
            }
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }
        System.out.println("-------");
        //option #2
        Thread.sleep(1000); //use it if it can't find elements
        List<WebElement> items = driver.findElements(By.cssSelector(".card-block"));
        for (WebElement item : items) {
            WebElement itemName = item.findElement(By.cssSelector("a"));
            WebElement itemPrice = item.findElement(By.cssSelector("h5"));
            System.out.println(itemName.getText() + " | " + itemPrice.getText());
        }

        driver.close();
    }
}
