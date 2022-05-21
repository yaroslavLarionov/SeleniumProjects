package day18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OrbitzHomeworkKuba {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait explicitWait = new WebDriverWait(driver, 20);
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //TODO open the link
        driver.get("https://www.orbitz.com/");

        //input into search field
        driver.findElement(By.xpath("//button[@aria-label='Going to']")).sendKeys("Las Vegas, Nevada");
        actions.sendKeys(Keys.ENTER).perform();

        //click calendar to expand monthly view
        driver.findElement(By.id("d1-btn")).click();

        //Check in with today's date
        //current date -> //button[@class='uitk-date-picker-day']
        driver.findElement(By.xpath("//button[@class='uitk-date-picker-day']")).click();

        //check-out
        //14 days later -> (//button[@class='uitk-date-picker-day'])[13]
        driver.findElement(By.xpath("(//button[@class='uitk-date-picker-day'])[13]")).click();

        //click Done button
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

        //click Rooms button
        driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']")).click();

        //add 2 children
        driver.findElement(By.xpath("//div[contains(@class, 'childStepInput')]//button[2]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'childStepInput')]//button[2]")).click();

        //choose children ages
        Select selectAge1 = new Select(driver.findElement(By.id("child-age-input-0-0")));
        selectAge1.selectByVisibleText("2");

        Select selectAge2 = new Select(driver.findElement(By.id("child-age-input-0-1")));
        selectAge2.selectByVisibleText("4");

        //Add Room 2
        driver.findElement(By.xpath("//button[@data-testid='add-room-button']")).click();

        //Set adult number to 2
        driver.findElement(By.xpath("//input[@id='adult-input-1']/following-sibling::button")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        //click on Search button
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        //handle security pop-up window
        explicitWait.until(ExpectedConditions.titleContains("Las Vegas"));

        //expand view to capture all hotels (more than 20)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        WebElement web = driver.findElement(By.xpath("//button[text()='Show More']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", web);
        Thread.sleep(3000);

        //Print all names of hotels
        List<WebElement> hotelNames = driver.findElements(By.xpath("//li[@data-stid='property-listing']/h3"));
        hotelNames.forEach(each -> System.out.println(each.getText()));

        //Store in 3 maps
        //Capture all hotel info
        List<WebElement> hotels = driver.findElements(By.xpath("//ol[@class='results-list no-bullet']/li[@data-stid='property-listing']"));

        Map<String, Double> starsMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        Map<String, Integer> priceMap = new HashMap<>();

        for(WebElement each: hotels){
            String hotelName = each.findElement(By.xpath("./h3")).getText();
            String stars = each.findElement(By.xpath(".//span[@data-stid='content-hotel-reviews-rating']")).getText();
            String price = each.findElement(By.xpath(".//div[@data-test-id='price-summary-message-line']/div/span")).getText();
            String discount;
            try{
                //setting implicitly wait shorter to finish loop fater
                driver.manage().timeouts().implicitlyWait(100, TimeUnit.MICROSECONDS);
                discount = each.findElement(By.xpath(".//span[@class='uitk-badge-text' and contains(text(), '%')]")).getText();
            }catch (NoSuchElementException e){
                discount = "0%";
            }

            //storing stars
            double totalStars = Double.parseDouble(stars.substring(0, stars.indexOf("/")));
            if(totalStars >= 4.0)
                starsMap.put(hotelName, totalStars);

            //storing discounts
            int totalDiscount;
            if(discount.length() > 7){
                System.out.println(discount);
                totalDiscount = Integer.parseInt(discount.substring(discount.indexOf("%")-2, discount.indexOf("%")));
            }else {
                System.out.println(discount);
                totalDiscount = Integer.parseInt(discount.substring(0, discount.indexOf("%")));
            }
            if(totalDiscount >= 10)
                discountMap.put(hotelName, totalDiscount);

            //storing price
            int totalPrice = Integer.parseInt(price.replace(",","").substring(1));
            if (totalPrice > 200)
                priceMap.put(hotelName, totalPrice);
        }

        //setting implicitly wait back to 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(starsMap);
        System.out.println(discountMap);
        System.out.println(priceMap);

        //TODO Print out only hotels with watching with all the following criteria: has 4.5 or more stars, price is above $300, has more than 20% discount
        for(WebElement each : hotelNames) {
            String hotelName = each.getText();
            if (starsMap.get(hotelName) != null && starsMap.get(hotelName) >= 4.1 &&
                priceMap.get(hotelName) != null && priceMap.get(hotelName) > 100 &&
                discountMap.get(hotelName) != null && discountMap.get(hotelName) > 5) {
                System.out.println(hotelName);
            }

        }


        driver.close();
    }
}
