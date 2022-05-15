package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathSelectors {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");
        /*
        XPATH
        tag + attribute
            css:
               tag.id - div#ABC - div[id='ABC']
               tag.class - div.xyz - div[class=xyz]
            xpath:
               //div[id='ABC']
         */
        System.out.println(driver.findElement(By.xpath("//h1[@class='header-text']")).getText());

        //  "/" vs "//"
        // "/"(absolute path) - looks for specific item at specific location (Example: /html/body/div/div/div/h1
        // "//"(relative path) - looks for the element in the whole DOM

        /*
        Get direct children
	        div[id='ancestor'] > div
	        //div[@id='ancestor']/div
        Get all children
	        div[id='ancestor'] div
	        //div[@id='ancestor']//div

	   Chaining attribute:
	       //div[@id='ancestor'][@name='abc']

       Using "and" and "or" keywords
	       div.abc - contains
	       div[class=abc] - exact match

	      //div[@id='ancestor' and @name='abc']
	      //div[@id='ancestor' or @name='abc']

       using tags
	     div.abc - looks for a tag with abc class value
	     .abc - looks for all tags with abc class value

	     //div[@class='abc'] - looks for a tag with abc class value
	     //*[@class='abc'] - looks for all tags with abc class value
         */
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='link'] "));
        list.forEach(el -> System.out.println(el.getText()));
        //"/html/body/div/div/div/div/a[@class='link']"

        driver.close();
    }
}
