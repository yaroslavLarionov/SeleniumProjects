package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OrbitzHomework {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //TODO open the link
        driver.get("https://www.orbitz.com/");

        //TODO By default "Hotel" is already selected. Input following text in fields: Going to - "Las Vegas, Nevada"
        WebElement goingTo = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        goingTo.sendKeys("Las Vegas, Nevada");
        driver.findElement(By.xpath("//div[@class='uitk-typeahead-button-label truncate']/span")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //TODO Check-in - Selects today's date and Check-out - 2 weeks later
        driver.findElement(By.id("d1-btn")).click();
        //identifying today's date in special format and the date 2 weeks from now dynamically
        LocalDate date = LocalDate.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM d, yyyy");
        String startDate = f.format(date);
        String endDate = f.format(date.plusWeeks(2));
        List<WebElement> listOfStartDates = driver.findElements(By.xpath("//td/button"));
        for (WebElement each : listOfStartDates) {
            //Selects today's date
            if (each.getAttribute("aria-label").contains(startDate)) {
                each.click();
            }
            // Check-out - 2 weeks later
            if (each.getAttribute("aria-label").contains(endDate)) {
                each.click();
            }
        }
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

        //TODO Travelers section: Room 1 (Adults - 2, Children - 2, Child 1 - 2, Child 2 - 4)
        driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']")).click();
        WebElement addChildren = driver.findElement(By.cssSelector("svg[aria-label='Increase children in room 1']"));
        addChildren.click();
        addChildren.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='child-age-input-0-0']")));
        select.selectByVisibleText("2");
        select = new Select(driver.findElement(By.xpath("//select[@id='child-age-input-0-1']")));
        select.selectByVisibleText("4");

        //TODO Add another Room 2 (Adults - 2)
        driver.findElement(By.xpath("//button[@data-testid='add-room-button']")).click();          //click add room
        driver.findElement(By.cssSelector("svg[aria-label='Increase adults in room 2']")).click(); //click add an adult
        driver.findElement(By.cssSelector("button[data-testid='guests-done-button']")).click();  //click on done

        //TODO Click on Search
        driver.findElement(By.cssSelector("button[data-testid='submit-button']")).click();

        //TODO Print out names only of all hotels displayed
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //typing the captcha puzzle before proceeding to the next step
        SeleniumUtils.scrollIntoView(driver, driver.findElement(By.xpath("//button[@data-stid='show-more-results']")));
        List<WebElement> listOfHotelNames = driver.findElements(By.xpath("//li/h3[@class='uitk-heading-5 is-visually-hidden']"));
        listOfHotelNames.forEach(each -> System.out.println(each.getText()));
        System.out.println("--------------------------------------------------------");

        //TODO Store all these Hotels in a map with the following criteria: Rating is >= 4 stars (Example: Hotel name + stars)
        List<WebElement> listOfHotels = driver.findElements(By.xpath("//li[@data-stid='property-listing']"));
        List<WebElement> listOfRatings = driver.findElements(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-block-size-full-size uitk-layout-flex-flex-direction-column']//span[@data-stid='content-hotel-reviews-rating']"));
        Map<String, String> ratingHotelsMap = new HashMap<>();
        for (int i = 0; i < listOfHotels.size(); i++) {
            if (listOfHotels.get(i).getText().contains("4.")) {
                ratingHotelsMap.put(listOfHotelNames.get(i).getText(), listOfRatings.get(i).getText().split(" ")[0]);
            }
        }
        System.out.println(ratingHotelsMap);

        //TODO Store all these Hotels in a map with the following criteria: Has discount 10% or more (Example: Hotel name + discount)
        List<WebElement> listOfDiscounts = driver.findElements(By.xpath("//span[@class='uitk-badge-text' and contains (text(),'%')]"));
        List <String> myList = new ArrayList<>();
        Map<String, String> discountHotelsMap = new HashMap<>();
        for (WebElement listOfHotel : listOfHotels) {
            if (listOfHotel.getText().contains("% off")) {
                myList.add(listOfHotel.getText().split("\n")[0]);
            }
        }
        for (int i = 0; i < listOfDiscounts.size(); i++) {
            String each = listOfDiscounts.get(i).getText();
            int discount = extractDiscount(each);
            if (discount >= 10) {
                discountHotelsMap.put(myList.get(i), extractDiscount(each) + "% off");
            }
        }
        System.out.println(discountHotelsMap);

        //TODO Store all these Hotels in a map with the following criteria: Price is over $200  (Example: Hotel name + price)
        List<WebElement> listOfPrices = driver.findElements(By.xpath("//div[contains (text(),'The price is')]"));
        Map <String, String> priceHotelsMap = new HashMap<>();
        System.out.println(priceHotelsMap);

        //TODO Print out all 3 maps

        //TODO Print out only hotels with watching with all the following criteria: has 4.5 or more stars, price is above $300, has more than 20% discount


        Thread.sleep(2000);
        driver.close();
    }
    public static int extractDiscount(String text) {
        String discountText = null;
        String[] str = text.split(" ");
        for (String each : str) {
            if (each.contains("%")) {
                discountText = each;
            }
        }
        discountText = discountText.split("%")[0];
        int discount = Integer.parseInt(discountText);
        return discount;
    }
}

