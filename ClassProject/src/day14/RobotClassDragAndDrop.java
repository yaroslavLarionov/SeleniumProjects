package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotClassDragAndDrop {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/actionclass");
        //Actions class drag and drop method doesn't work - that's why we'll use robot class method for this purpose

        WebElement source = driver.findElement(By.id("todo2"));
        WebElement target = driver.findElement(By.id("div1"));

        //locating coordinates of the elements
        System.out.println(source.getLocation());  //(1424, 568)
        System.out.println(target.getLocation());  //(1848, 516)

        //moving the cursor of the mouse to element's location
        Robot robot = new Robot();
        robot.mouseMove(1550, 650);
        Thread.sleep(2000);

        //click and hold the element
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        //moving mouse to target element
        robot.mouseMove(2000, 660);
        Thread.sleep(2000);

        //release the mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(2000);
        driver.close();
    }
}
