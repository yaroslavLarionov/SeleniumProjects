import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class LinksTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @DataProvider(name = "testLinksData")
    public Object[][] testData1(){
        Object[][] data = new Object[3][2];
        data[0][0] = "Launch TLA";
        data[0][1] = "Coding Boot-camp | Tech Lead Academy";

        data[1][0] = "Launch Google";
        data[1][1] = "Google";

        data[2][0] = "Launch Facebook";
        data[2][1] = "Facebook - log in or sign up";

        return data;
    }

    @Test(dataProvider = "testLinksData")
    public void testAllLinks(String linkText, String expectedTitle){
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");
        //clicking the link
        driver.findElement(By.linkText(linkText)).click();
        //switch window
        SeleniumUtils.switchWindow(driver);
        //verify title
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void testTLALink(){
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");
        //clicking the link
        driver.findElement(By.linkText("Launch TLA")).click();
        //switch window
        SeleniumUtils.switchWindow(driver);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Coding Boot-camp | Tech Lead Academy");
    }

    @Test
    public void testGoogleLink(){
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");
        //clicking the link
        driver.findElement(By.linkText("Launch Google")).click();
        //switch window
        SeleniumUtils.switchWindow(driver);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void testFacebookLink(){
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");
        //clicking the link
        driver.findElement(By.linkText("Launch Facebook")).click();
        //switch window
        SeleniumUtils.switchWindow(driver);
        //verify title
        Assert.assertEquals(driver.getTitle(), "Facebook - log in or sign up");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
