import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Validate title of Google page
    @Test(testName = "E205-34", description = "This story is testing title of the page", timeOut = 5000)
    public void testGoogle(Method method) {
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(), "Google");

        Test test = method.getAnnotation(Test.class);
        Reporter.log(test.testName(), true);
        Reporter.log(test.description(), true);
        Reporter.log(method.getName(), true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // test is disabled
    @Test (testName = "Amazon Test", enabled = false)
    public void testAmazon() {
        driver.get("https://amazon.com");
        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
    }

    @Test(testName = "TLA Test", priority = -1, invocationCount = 4, skipFailedInvocations = true)
    public void testTLA() {
        driver.get("http://automation.techleadacademy.io");
        driver.findElement(By.linkText("Alert")).click();

        String expectedUrl = "http://automation.techleadacademy.io/#/alerts";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(testName = "Orbitz Test")
    public void testOrbitz() {
        driver.get("https://orbitz.com");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Sign in']")).isEnabled());
    }

    @Test(testName = "TLA Test Nav Buttons", dataProvider = "buttonNames", dataProviderClass = DataProviders.class)
    public void testTLA2(String button) {
        driver.get("http://automation.techleadacademy.io");
        Assert.assertTrue(driver.findElement(By.linkText(button)).isEnabled());
    }
//    @Test(testName = "TLA Test Nav Buttons")
//    public void testTLA3(){
//        driver.get("http://automation.techleadacademy.io");
//
//        Assert.assertTrue(driver.findElement(By.linkText("Inputss")).isEnabled());
//    }
//    @Test(testName = "TLA Test Nav Buttons")
//    public void testTLA4(){
//        driver.get("http://automation.techleadacademy.io");
//        Assert.assertTrue(driver.findElement(By.linkText("Notes")).isEnabled());
//    }

    @Test(dataProvider = "userInfo", dataProviderClass = DataProviders.class)
    public void testSauceDemo(String userName, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}