package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        //locating search input field
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        //typing in "Selenium" and pressing the search button
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Thread.sleep(1000); //we need this because when searching the dropdown menu shows up and the button shifts, so we wait and then press the button
        searchButton.click();
        //getting the "Selenium" definition from the wiki link
        WebElement wikiLinkEl = driver.findElement(By.className("ruhjFe"));
        String wikiURL = wikiLinkEl.getAttribute("href");
        System.out.println(wikiURL);

        //Testing first result item contains a word selenium
        String expected = "Selenium";
        String actual = driver.findElement(By.className("VwiC3b")).getText();
        System.out.println(actual);

        if (actual.contains(expected)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed. Search word was not found in the result text");
        }




        Thread.sleep(1000);
        driver.close();

    }
}
