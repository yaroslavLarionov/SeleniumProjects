package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ParentChildSelectors {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automation.techleadacademy.io/#/selectors");

        //locating the element using ArrayList and accessing last element using index of that element
        List<WebElement> list = driver.findElements(By.cssSelector("div#parent2 div.sub-child"));
        System.out.println(list.get(list.size() - 1).getText());

        //we can locate element without using ArrayList by using parent-child selector and specifying the first,second or last element
        // for the N-th element the syntax is:
        // div#parent2 div.sub-child:nth-child(2)
        System.out.println(driver.findElement(By.cssSelector("div#parent2 div.sub-child:last-child")).getText());
        System.out.println(driver.findElement(By.cssSelector("div#parent2 div.sub-child:nth-child(1)")).getText());
        /*
       //TODO    tag#idValue > input → for direct childs only

        driver.findElement(By.cssSelector("div#idValue > input.classValue")

       //TODO    tag#idValue input → to find any descendant element (used space instead of > sign). Ex: I'm a span

        driver.findElement(By.cssSelector("div#idValue input.classValue")

        river.findElement(By.cssSelector("div#idValue p")

       //TODO   :first-child - tag#id :first-child → This will locate the first element under the tag

        driver.findElement(By.cssSelector("div#parent1 > div:first-child")

        //TODO  :last-child - tag.class :last-child → This will locate the last element under tag

        driver.findElement(By.cssSelector("ul#parent1 > li:last-child")

       //TODO    :nth-child - tag#id :nth-child(2) → This will locate the second child element under that tag

        driver.findElement(By.cssSelector("div#parent2 > div:nth-child(2)")
         */
        driver.close();
    }
}
