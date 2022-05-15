package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComputerDatabaseScenario2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://computer-database.gatling.io/");
        //First step to start with writing automation scripts
        //We do it manually


        //TODO Save the number of computers found value and click on the 'Add new computer' button in the right top corner.
        String computersFoundTxt = driver.findElement(By.xpath("//section[@id='main']/h1")).getText().split(" ")[0];
        int computersFound = Integer.parseInt(computersFoundTxt);
        //click on "Add a new computer"
        driver.findElement(By.xpath("//a[@class='btn success']")).click();

        //TODO Fill up the form with any valid data and click on the 'Create this computer' button
        String computerName = "MacBook Pro M1";
        driver.findElement(By.id("name")).sendKeys("MacBook Pro M1");
        driver.findElement(By.id("introduced")).sendKeys("2022-05-07");
        driver.findElement(By.id("discontinued")).sendKeys("2025-04-30");
        Select select = new Select(driver.findElement(By.id("company")));
        select.selectByVisibleText("Apple Inc.");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Create this computer']")).click();
        Thread.sleep(2000);

        //TODO Verify confirmation alert message with the correct computer name is displayed.
        WebElement alertConfirmMsgEl = driver.findElement(By.xpath("//div[@class='alert-message warning']"));
        String actualConfirmMsg = alertConfirmMsgEl.getText();
        System.out.println(actualConfirmMsg);
        String expectedConfirmMsg = "Done ! Computer" + computerName + " has been created";
        if (expectedConfirmMsg.equals(actualConfirmMsg)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        //TODO Verify the number of computers found increased by one.
        int expectedComputersFound = computersFound + 1;
        String actualComputersFoundStr = driver.findElement(By.xpath("//section[@id='main']")).getText().split(" ")[0];
        int actualComputersFound = Integer.parseInt(actualComputersFoundStr);
        if (expectedComputersFound == actualComputersFound) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }




        Thread.sleep(2000);
        driver.close();
    }
}
