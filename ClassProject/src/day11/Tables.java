package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tables {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/tables");

        List<WebElement> firstNames = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        firstNames.forEach(el -> System.out.println(el.getText()));

        List<WebElement> emails = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
        emails.forEach(el -> System.out.println(el.getText()));

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement each : rows) {
            System.out.println(each.findElement(By.xpath(".//td[1]")).getText());   // "." means looking in this specific section
        }
        System.out.println("------------");
        //if we want to find males only
        for (WebElement each : rows) {
            if (each.findElement(By.xpath("./td[3]")).getText().equals("Male")) {
                System.out.println(each.findElement(By.xpath("./td[1]")).getText());
            }
        }
        System.out.println("---------------------");

        //TODO print only age and email for people who is between 40 and 50 from all 10 pages
        List<WebElement> pages = driver.findElements(By.xpath("//a[@class='page-link' and text()]"));
        for (WebElement page : pages) {
            for (WebElement each : rows) {
                try {
                    page.click();
                    String email = each.findElement(By.xpath("./td[6]")).getText();
                    int age = Integer.parseInt(each.findElement(By.xpath("./td[4]")).getText());
                    if (age >= 40 && age <= 50) {
                        System.out.println("Age: " + age + " | " + "Email: " + email);
                    }
                }catch (StaleElementReferenceException e) {
                    driver.navigate().refresh();
                }
            }
        }

        driver.close();
    }
}
