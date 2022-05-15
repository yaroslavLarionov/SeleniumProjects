package day03;

import com.sun.xml.internal.ws.policy.PolicyAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03Task {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximizing window size for convenience and finding elements

        //opening the website
        driver.get("http://automation.techleadacademy.io/#/inputs");

        //input "Selenium" keyword in the search field
        WebElement searchBar = driver.findElement(By.id("message"));
        String expected = "Selenium";
        searchBar.sendKeys(expected);

        //Click "Show message" button
        WebElement button = driver.findElement(By.name("button1"));
        button.click();

        //Verify message displayed is as expected
        String actual = driver.findElement(By.name("message1")).getText();
        if(actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("----------------------------------------------------------------");
        WebElement searchBar1 = driver.findElement(By.id("a"));
        WebElement searchBar2 = driver.findElement(By.id("b"));
        String num1 = "10";
        String num2 = "5";
        searchBar1.sendKeys(num1);
        searchBar2.sendKeys(num2);
        WebElement getTotal = driver.findElement(By.name("button2"));
        getTotal.click();
        String result = driver.findElement(By.name("answer2")).getText();
        if (Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(result)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


        Thread.sleep(1000);
        driver.close();
    }
}
