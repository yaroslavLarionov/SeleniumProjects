package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

    public class day04HomeWork {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //TODO: Open the browser -> automationpractice.com
            driver.get("http://automationpractice.com/index.php");

            //TODO: Click "Dresses" button
            List<WebElement> titles = driver.findElements(By.className("sf-with-ul"));
            titles.get(3).click();

            //TODO: Print out value of "href" attributes of items under "Dresses" section
            List<WebElement> subcategories = driver.findElements(By.className("subcategory-name"));
            for (WebElement el : subcategories) {
                System.out.println(el.getText() + ":" + el.getAttribute("href"));
            }

            //TODO: Then Click on "Casual dresses"
            subcategories.get(0).click();

            //TODO: Verify "header" of that section's name is "CASUAL DRESSES"
            WebElement header = driver.findElement(By.className("cat-name"));
            String expected = "CASUAL DRESSES";
            String actual = header.getText();
            if (expected.equals(actual)) {
                System.out.println("Test passed - Header is matching the requirement");
            } else {
                System.out.println("Test failed - Header is not matching the requirement");
            }
            //RESULT: Header "CASUAL DRESSES" contains space in the end making comparison fail. trim() method solves the problem

            //TODO: Navigate back
            driver.navigate().back();

            //TODO: Click on "Evening Dresses"
            //need to recreate the list of categories again because it throws StaleElementReferenceException otherwise
            List<WebElement> subcategories2 = driver.findElements(By.className("subcategory-name"));
            subcategories2.get(1).click();

            //TODO: Print out and Verify title is "Evening Dresses - My Store"
            WebElement title = driver.findElement(By.className("cat-name"));
            String expectedResult = "Evening Dresses - My Store";
            String actualResult = title.getText();
            if (actualResult.equals(expectedResult)) {
                System.out.println("Test passed - Header is matching the requirement");
            } else {
                System.out.println("Test failed - Header is not matching the requirement");
            }
            //RESULT: the header "EVENING DRESSES" doesn't match the "Evening Dresses - My Store"

            driver.close();
        }
    }


