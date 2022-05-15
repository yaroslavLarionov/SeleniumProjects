package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;

public class AMChomework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        //next two lines allow us to force incognito mode and then we need to pass in the "options" in the Webdriver driver object (line 19)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        //TODO open the link
        driver.get("https://www.amctheatres.com/");

        //TODO Print out main text of Welcome! pop-up window
        System.out.println(driver.findElement(By.className("onboarding-tour-modal__body")).getText());

        //TODO  Click "Let's Go!" option of pop-up window
        driver.findElement(By.xpath("//div/button[@class='Btn Btn--Primary']")).click();
        Thread.sleep(1000);

        //TODO  Print out text of pop-up window "Get More with AMC Stubs"
        System.out.println(driver.findElement(By.className("tourtip__content")).getText());

        //TODO Close the pop-up
        driver.findElement(By.className("icon_close")).click();

        //TODO Click all following buttons to open new pages: Facebook, Twitter, Youtube, Instagram, Pinterest
        List<WebElement> socialLinks = driver.findElements(By.xpath("//div[@class='SiteFooter-social']/ul//a"));
        socialLinks.forEach(WebElement::click);

        //TODO Print out specific section of each following websites: Pinterest -> 8.2k followers | 1.8k following
        switchToWindow(driver, "Pinterest");
        String pinterestFollowers = driver.findElement(By.xpath("//div[@data-test-id='profile-followers-link']/div/div")).getText();
        String pinterestFollowing = driver.findElement(By.xpath("//div[@data-test-id='follower-count']/div/div")).getText();
        System.out.println("Pinterest -> " + pinterestFollowers + " | " + pinterestFollowing);

        //TODO Print out specific section of each following websites: Instagram -> 12.864 posts | 577k followers | 2,300 following
        switchToWindow(driver, "Instagram");
        List<WebElement> instaStats = driver.findElements(By.xpath("//div[@class='_7UhW9    vy6Bb     MMzan   KV-D4           uL8Hv        T0kll ']"));
        System.out.println("Instagram -> " + instaStats.get(0).getText() + " | " + instaStats.get(1).getText());

        //TODO Print out specific section of each following websites: Youtube -> 440k subscribers
        switchToWindow(driver, "YouTube");
        String youtubeSubs = driver.findElement(By.xpath("//yt-formatted-string[@id='subscriber-count']")).getText();
        System.out.println("YouTube -> " + youtubeSubs);

        //TODO Print out specific section of each following websites: Twitter -> 37.6K Following | 542.3K Followers
        switchToWindow(driver, "Twitter");
        List<WebElement> twitterStats = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-1w6e6rj']/div"));
        System.out.println("Twitter -> " + twitterStats.get(0).getText() + " | " + twitterStats.get(1).getText());

        //TODO Print out specific section of each following websites: Facebook -> 6,252,610 people like this | 6,125,637 people follow this
        switchToWindow(driver, "Facebook");
        List<WebElement> facebookStats = driver.findElements(By.xpath("//div[@class='taijpn5t cbu4d94t j83agx80']//span/span"));
        System.out.println("Facebook -> " + facebookStats.get(0).getText() + " " + facebookStats.get(1).getText() + " | " + facebookStats.get(2).getText());

        //TODO  In main AMC page: Click "Showtimes"
        switchToWindow(driver, "tickets");
        driver.findElement(By.className("Showtimes-label")).click();
        Thread.sleep(2000);

        //TODO enter your zip code and click Search button
        driver.findElement(By.xpath("//input[@placeholder='Search by City, Zip or Theatre']")).sendKeys("43016");
        driver.findElement(By.xpath("//i[@alt='Submit Search']")).click();
        Thread.sleep(1000);

        //TODO print out names of all theater in search result
        List<WebElement> listOfPlaces = driver.findElements(By.className("theatre-result__headline"));
        listOfPlaces.forEach(each -> System.out.println(each.getText()));

        //TODO Click X button to close
        driver.findElement(By.xpath("//button/i")).click();
        Thread.sleep(1000);

        //TODO Click X button to close again
        driver.findElement(By.xpath("//a[@aria-label='Close']")).click();
        Thread.sleep(1000);

        //TODO print out text of pop-up window
        System.out.println(driver.findElement(By.xpath("//div/p")).getText());

        //TODO Click in Yes option
        driver.findElement(By.className("Btn--Secondary")).click();

        driver.quit();
    }
    private static void switchToWindow(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String each : allWindows) {
           if (driver.switchTo().window(each).getTitle().contains(title)) {
               break;
           }
        }
    }
}
