package day16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductStoreScenario3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");
        String expectedHomePage = driver.getTitle();

        //TODO Click on the first item's name
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("h4 > a[class='hrefch']")).click();
        Thread.sleep(2000);

        //TODO Save name and price and click on the 'Add to cart' button
        String expectedFirstItemName = driver.findElement(By.cssSelector("div > h2[class='name']")).getText();
        String expectedFirstItemPrice = driver.findElement(By.cssSelector("h3[class='price-container']")).getText().split(" ")[0].replace("$", "");
        driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();
        Thread.sleep(2000);

        //TODO Verify and accept the confirmation pop up with the 'Product added' text
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);

        //TODO Navigate to the home page by clicking the Home link. Select the last item in the items list.
        driver.findElement(By.cssSelector("a.nav-link:first-child")).click();
        Thread.sleep(2000);
        List<WebElement> itemList = driver.findElements(By.cssSelector("div[class='col-lg-9'] > div > div"));
        itemList.get(itemList.size() - 1).click();
        Thread.sleep(2000);

        //TODO Save name and price and click on the 'Add to cart' button
        String expectedLastItemName = driver.findElement(By.cssSelector("div > h2[class='name']")).getText();
        String expectedLastItemPrice = driver.findElement(By.cssSelector("h3[class='price-container']")).getText().split(" ")[0].replace("$", "");
        driver.findElement(By.cssSelector("a[onclick='addToCart(9)']")).click();
        Thread.sleep(2000);

        //TODO Verify and accept the confirmation pop up with the 'Product added' text
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);

        //TODO Navigate to the 'Cart' page
        driver.findElement(By.cssSelector("li > a[id='cartur']")).click();
        Thread.sleep(2000);

        //TODO Verify that previously added items on the card with the correct name and price.
        String actualLastItemAdded = driver.findElement(By.cssSelector("tbody > tr[class='success']:nth-child(2) > td:nth-child(2)")).getText();
        String actualLastItemPrice = driver.findElement(By.cssSelector("tbody > tr[class='success']:nth-child(2) > td:nth-child(3)")).getText();
        String actualFirstItemAdded = driver.findElement(By.cssSelector("tbody > tr[class='success']:nth-child(1) > td:nth-child(2)")).getText();
        String actualFirstItemPrice = driver.findElement(By.cssSelector("tbody > tr[class='success']:nth-child(1) > td:nth-child(3)")).getText();
        System.out.println("Expected first item: " + expectedFirstItemName + " | " + expectedFirstItemPrice);
        System.out.println("Expected last item: " + expectedLastItemName + " | " + expectedLastItemPrice);
        System.out.println("Actual first item: " + actualFirstItemAdded + " | " + actualFirstItemPrice);
        System.out.println("Actual last item added: " + actualLastItemAdded + " | " + actualLastItemPrice);
        boolean equalName = (actualFirstItemAdded.equals(expectedFirstItemName) && actualLastItemAdded.equals(expectedLastItemName));
        boolean equalPrice = (actualFirstItemPrice.equals(expectedFirstItemPrice) && actualLastItemPrice.equals(expectedLastItemPrice));
        if (equalName && equalPrice) {
            System.out.println("names and prices tests passed");
        } else {
            System.out.println("names and prices tests failed");
        }

        //TODO Verify the total price.
        int expectedTotalPrice = Integer.parseInt(actualFirstItemPrice) + Integer.parseInt(actualLastItemPrice);
        int actualTotalPrice = Integer.parseInt(driver.findElement(By.cssSelector("h3[id='totalp']")).getText());
        String totalPriceResult = (expectedTotalPrice == actualTotalPrice) ? "totalPriceResult passed" : "totalPriceResult failed";
        System.out.println(totalPriceResult);
        System.out.println("-------------------------");

        //TODO  Click on the 'Place Order' button
        driver.findElement(By.cssSelector("button[data-target='#orderModal']")).click();
        Thread.sleep(2000);

        //TODO Fill up information in the Place order form and click 'Purchase'
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys("John Smith");
        driver.findElement(By.cssSelector("input[id='country']")).sendKeys("USA");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Austin");
        driver.findElement(By.cssSelector("input[id='card']")).sendKeys("1234567812345678");
        driver.findElement(By.cssSelector("input[id='month']")).sendKeys("May");
        driver.findElement(By.cssSelector("input[id='year']")).sendKeys("2022");
        driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']")).click();
        Thread.sleep(2000);

        //TODO Validate confirmation pop up -  Amount should be equal to the total amount.
        String popup = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        int confirmationAmount = Integer.parseInt(popup.substring(popup.indexOf("Amount:"), popup.indexOf("USD") + 1).split(" ")[1]);
        String amountValidation = (confirmationAmount == actualTotalPrice) ? "amountValidation passed" : "amountValidation failed";
        System.out.println(amountValidation);

        //TODO Validate confirmation pop up -  Card number should be equal to the entered card number.
        String expectedCustomerCardNumber = "1234567812345678";
        String actualCustomerCardNumber = popup.substring(popup.indexOf("Number:"), popup.indexOf("Number:") + 25).trim().split(" ")[1];
        String cardValidation = (actualCustomerCardNumber.equals(expectedCustomerCardNumber)) ? "cardValidation passed" : "cardValidation failed";
        System.out.println(cardValidation);

        //TODO Validate confirmation pop up -   Name should be equal to the entered name.
        String expectedCustomerName = "John Smith";
        String firstName = popup.substring(popup.indexOf("Name:"), popup.indexOf("Date:")).split(" ")[1].trim();
        String lastName = popup.substring(popup.indexOf("Name:"), popup.indexOf("Date:")).split(" ")[2].trim();
        String actualCustomerName = firstName + " " + lastName;
        System.out.println(actualCustomerName);
        String nameTestResult = (actualCustomerName.equals(expectedCustomerName)) ? "nameTestResult passed" : "nameTestResult failed";
        System.out.println(nameTestResult);

        //TODO Validate confirmation pop up - Date should be equal to today's date
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/yyyy");
        String expectedDate = f.format(now);
        String actualDate = popup.substring(popup.indexOf("Date:"), popup.indexOf("Date:") + 14).split(" ")[1];
        System.out.println("Actual date: " + actualDate + " | Expected date: " + expectedDate);
        String dateTestResult = (actualDate.equals(expectedDate)) ? "dateTestResult passed" : "dateTestResult failed";
        System.out.println(dateTestResult);

        //TODO click OK
        driver.findElement(By.cssSelector("button[class='confirm btn btn-lg btn-primary']")).click();
        Thread.sleep(2000);

        //TODO Verify you are on the home page.
        String actualHomePage = driver.getTitle();
        String homePageTestResult = (actualHomePage.equals(expectedHomePage)) ? "homePageTestResult passed" : "homePageTestResult failed";
        System.out.println(homePageTestResult);





        driver.close();
    }
}
