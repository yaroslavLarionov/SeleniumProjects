package day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPart2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/");

        //accessing element with index form list of many elements
        // tag[attr='value'][index]
        System.out.println(driver.findElement(By.xpath("//a[@class='navbar-brand ml-3'][2]")).getText());    //Notes
        System.out.println(driver.findElement(By.xpath("//nav[@class='navbar nav1'][2]//a[@class='navbar-brand ml-3'][2]")).getText());  //iFrames
        System.out.println(driver.findElement(By.xpath("//a[@class='link'][4]")).getText()); //E-commerce

        //We can also get the last element index when size changes dynamically (by using[last()]
        System.out.println(driver.findElement(By.xpath("//a[@class='link'][last()]")).getText());  //Shopping Cart

        //working with text:
              //using text() method
                  //tag[text()='value']
                  //a[text()='value']
                  //*[text()='value']
        System.out.println(driver.findElement(By.xpath("//a[text()='Inputs']")).getText());  //Inputs

        //sub-strings methods for attribute values
          //starts-with
              //tag[starts-with(@attr, 'value']
              //div[starts-with(text(), 'Mercedes']
          //contains
              //tag[contains(@attr, 'value']
          //ends-with
              //xpath 1.0 doesn't support ends with

        System.out.println(driver.findElement(By.xpath("//div[starts-with(@name, 'g')][2]")));  //Mercedes GLA-Class


        driver.close();
    }
}
