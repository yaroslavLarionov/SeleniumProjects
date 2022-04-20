package day05;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CssSelector {
    public static void main(String[] args) {
        //CSS Selector combines an element selector and a selector value that can identify particular elements on a web page
        //CSS selector can be used to locate web elements without ID, class, or Name
        //There are 5 types of CSS Selectors in Selenium tests:
        /*1) ID
          2) Class
          3) Attribute
          4) Sub-String
          5) Inner String
         */

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automation.techleadacademy.io/#/");

        //using css selector with tag + id to find the element
        System.out.println(driver.findElement(By.cssSelector("h1#title")).getText());      //Automation with Selenium

        //using css selector with tag + .class
        List<WebElement> list = driver.findElements(By.cssSelector("div.text"));
        System.out.println(list.get(1).getText());

        //using css selector with any attribute
        //<HTML tag><[attribute=Value of attribute]>
        //tag[href=value]
        //input#twotabsearchtextbox => input[id=twotabsearchtextbox]
        //span.nav-line-2 => span[class=nav-line-2]
        //always put value of the attributes in single quotes('') not double, otherwise css selector might not pick it up
        System.out.println(driver.findElement(By.cssSelector("div[class='row']")).getText());

        //chaining the attributes. Locating using multiple attributes
        //<HTML tag><[attribute1=Value of attribute1]><[attribute2=Value of attribute2]>



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
