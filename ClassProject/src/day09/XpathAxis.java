package day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathAxis {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/selectors");

        //TODO =====xpath axis (parent-child-parent access)=====
           //tag[@attr='value']/tagOfChild
           //tag[@attr='value']/child::tagOfChild
               //div[@id='parents2']/child::div
               //div[@id='parents2']/div

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='porsche']/div/div/child::div"));  //or //div[@id='porsche']/div/div/div
        list.forEach(el -> System.out.println(el.getText()));
        System.out.println("-------------------------------");

        //TODO using a "following::" keyword - finds all elements that match the criteria in the DOM, but only if they come after the main element
            //tag[@attr='value']/following::tag
        List<WebElement> list2 = driver.findElements(By.xpath("//u[text()='SUV']/following::div"));
        list2.forEach(el -> System.out.println(el.getText()));
        System.out.println("-----------------------------------");

        List<WebElement> list3 = driver.findElements(By.xpath("(//u[text()='SUV'])[2]/following::div"));  //(//....)[2] when index doesn't get recognized
        list3.forEach(el -> System.out.println(el.getText()));
        System.out.println("----------------------------");

        //TODO using a "preceding::" keyword - finds all elements that match the criteria in the DOM, but only if they come before the main element
           //tag[@attr='value']/preceding::tag

        //TODO using a "following-sibling::" keyword - finds all elements that match the criteria in the DOM, but only if they come after the main element
        //  and are a sibling to it (all elements found during this command will be in the same hierarchy, it won't go lower)
        //tag[@attr='value']/following-sibling::tag

        //TODO using a "preceding-sibling::" keyword - finds all elements that match the criteria in the DOM, but only if they come before the main element
        //  and are a sibling to it
        //tag[@attr='value']/preceding-sibling::tag

        //TODO using a "parent::tag" - to locate parent element from a child
        //tag[@attr='value']/parent::tag

        //TODO using a "ancestor::tag" - to locate ancestor element from a child
        //tag[@attr='value']/ancestor::tag

       List<WebElement> list4 = driver.findElements(By.xpath("//div[@name='gle-class']/preceding-sibling::div[@name]"));
       list4.forEach(el -> System.out.println(el.getText()));






        driver.close();
    }
}
