package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class HomeworkBasicCssSelectors {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TODO: navigate to http://automationpractice.com/
        driver.get("http://automationpractice.com/");

        //TODO print out every product name and price under Popular section
        List<WebElement> allName = driver.findElements(By.cssSelector("#homefeatured a.product-name"));
        List<WebElement> allPrice = driver.findElements(By.cssSelector("#homefeatured .right-block span.price"));
        for (int i = 0; i < allPrice.size() ; i++) {
            System.out.println(allName.get(i).getText() + " | " + allPrice.get(i).getText());
        }
        System.out.println("------------------");
        //Output matches the required criteria

        //TODO click on any item option of the Popular items category
        driver.findElement(By.cssSelector("a[class='product-name'][href='http://automationpractice.com/index.php?id_product=1&controller=product']")).click();
        Thread.sleep(2000);

        //TODO: input quantity of "5"
        WebElement inputBox = driver.findElement(By.cssSelector("input[class='text']"));
        inputBox.clear();
        inputBox.sendKeys("5");

        //TODO: press "Add to cart button"
        driver.findElement(By.cssSelector("button[name='Submit']")).click();
        Thread.sleep(2000);
        //Important to keep this Thread.sleep(2000), because icon on the screen showed loading; otherwise prices won't print on lines 42-48

        //TODO: print and capture - product price, shipping price and total price
        String expectedProductPrice = driver.findElement(By.cssSelector("span.ajax_block_products_total")).getText();
        String expectedShippingPrice = driver.findElement(By.cssSelector("span[class='ajax_cart_shipping_cost']")).getText();
        String expectedTotalPrice = driver.findElement(By.cssSelector("span[class='ajax_block_cart_total']")).getText();
        System.out.println("Product price is: " + expectedProductPrice);
        System.out.println("Shipping price is: " + expectedShippingPrice);
        System.out.println("Total price is: " + expectedTotalPrice);
        System.out.println("----------------------");
        //Output matches the requirement criteria. Test passed

        //TODO: then press "Proceed to checkout" button
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']")).click();

        //TODO: print out product description
        System.out.println(driver.findElement(By.cssSelector("td[class='cart_description']")).getText());
        System.out.println("----------------------");

        //TODO: Capture: total products price, total shipping price, total price. Compare to previous capture results
        String actualProductPrice = driver.findElement(By.cssSelector("td[id='total_product']")).getText();
        String actualShippingPrice = driver.findElement(By.cssSelector("td[id='total_shipping']")).getText();
        String actualTotalPrice = driver.findElement(By.cssSelector("td[id='total_price_without_tax']")).getText();
        System.out.println("Current product price: " + actualProductPrice + " | " + "Previous product price: " + expectedProductPrice);
        System.out.println("Current shipping price: " + actualShippingPrice + " | " + "Previous shipping price: " + expectedShippingPrice);
        System.out.println("Current total price: " + actualTotalPrice + " | " + "Previous total price: " + expectedTotalPrice);
        //Expected and actual results meet the requirement criteria. Test passed

        driver.close();
    }
}
