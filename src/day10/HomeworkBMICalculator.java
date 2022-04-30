package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkBMICalculator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO open the link
        driver.get("http://automation.techleadacademy.io/#/popup");

        //TODO Click on BMI Calculator button
        driver.findElement(By.id("bmi_btn")).click();
        Thread.sleep(2000);

        //TODO Input height and weight
        driver.findElement(By.name("feet")).sendKeys("6");
        driver.findElement(By.name("inch")).sendKeys("4");
        driver.findElement(By.name("weight")).sendKeys("220");

        //TODO Click on Calculate button
        driver.findElement(By.id("calculate_btn")).click();
        Thread.sleep(2000);

        //TODO In "Your BMI" field capture the result
        System.out.println(driver.findElement(By.id("result_progress")).getText());

        //TODO Print out what category the result belongs to. Example: Result: 24 | Category: Normal Weight
        double result = Double.parseDouble(driver.findElement(By.id("result_progress")).getText());
        if (result < 18.5) {
            System.out.println("Result: " + result + " | " + "Category: Underweight");
        } else if (result >= 18.5 && result < 25) {
            System.out.println("Result: " + result + " | " + "Category: Normal weight");
        } else if (result >= 25 && result < 30) {
            System.out.println("Result: " + result + " | " + "Category: Overweight");
        } else if (result >= 30) {
            System.out.println("Result: " + result + " | " + "Category: Obese");
        }

        driver.close();

    }
}
