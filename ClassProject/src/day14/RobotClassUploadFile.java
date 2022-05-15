package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClassUploadFile {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/files");

        //File upload
        String filePath = "C:\\Users\\yaril\\Desktop\\Codingbat.txt";
        WebElement chooseFile = driver.findElement(By.id("exampleFormControlFile1"));

        //TODO Option #1
        //chooseFile.sendKeys(filePath);

        //TODO Option #2: using Actions class
        //(won't work because we have to chose file in the window outside the browser, which action class doesn't support)
        Actions actions = new Actions(driver);
        //actions.moveToElement(chooseFile).sendKeys(filePath).perform();

        //TODO Option #3: using Robot class
        Robot robot = new Robot();
        //copying path to clipboard
        StringSelection path = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
        //opening file upload window
        actions.moveToElement(chooseFile).click().perform();
        Thread.sleep(2000);
        //using Robot class to perform Paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



        Thread.sleep(3000);
        driver.close();

    }
}
