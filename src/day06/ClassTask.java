package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ClassTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO: Navigate to youtube
        driver.get("https://youtube.com");

        //TODO: Print out text of search labels
        System.out.println(driver.findElement(By.cssSelector("input#search")).getAttribute("placeholder"));

        //TODO: Input Tech Lead Academy in search bar and click search
        driver.findElement(By.cssSelector("input#search")).sendKeys("Tech Lead Academy");
        driver.findElement(By.cssSelector("button#search-icon-legacy")).click();
        Thread.sleep(2000);

        //TODO: Click on “Tech Lead Academy” channel name
        List<WebElement> list = driver.findElements(By.cssSelector(".style-scope ytd-channel-name"));
        for (WebElement webElement : list) {
            if (webElement.getText().contains("Tech Lead Academy")) {
                webElement.click();
            }
        }
        //TODO: Print out src value of the video
        System.out.println(driver.findElement(By.cssSelector("img[id='img'][class='style-scope yt-img-shadow'][width='246']")).getAttribute("src"));

        driver.close();
    }
}
