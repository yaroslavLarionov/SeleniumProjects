package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class day03Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/inputs");
        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Doe");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("johndoe@gmail.com");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("650-321-1054");
        WebElement address = driver.findElement(By.name("address"));
        address.sendKeys("17 North High Street");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Austin");
        //option 1 to for state category - typing the text
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Texas");
        //option 2 for state category - selecting from the dropdown menu
        //Select state = new Select(driver.findElement(By.name("state")));
        //state.selectByVisibleText("Texas");

        WebElement zipcode = driver.findElement(By.name("zip"));
        zipcode.sendKeys("73301");
        WebElement submit = driver.findElement(By.name("button3"));
        submit.click();

        String expected = driver.findElement(By.name("answer3")).getText();
        String actual = driver.findElement(By.name("answer3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        try {
            Thread.sleep(2000);
        } catch(Exception e) {
            System.out.println("Exception is handled");
        }
        driver.close();

    }
}
