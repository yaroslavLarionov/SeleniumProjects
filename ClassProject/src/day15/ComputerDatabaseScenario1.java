package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerDatabaseScenario1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://computer-database.gatling.io/");

        // What's the difference between getText and getAttribute(name)?
        // <div id="first-txt" class="title">Hello, World</div>
        // div - tag name
        // id="first-txt", class="title" - attributes
        // Hello, World - text
        // <a href="google.com">Go to Google</a>
        // String link = numberOfItemsElement.getAttribute("href");
        //TODO Verify the number of items within the 500 and 700 range(in the computers found text)
        String numberOfItemsTxt = driver.findElement(By.xpath("//section[@id='main']/h1")).getText();
        // extract numeric part of the string
        numberOfItemsTxt = numberOfItemsTxt.substring(0, numberOfItemsTxt.indexOf(" ")); // or numberOfItemsTxt = numberOfItemsTxt.split(" ")[0];
        //convert to numeric data type (int)
        int numberOfItems = Integer.parseInt(numberOfItemsTxt);
        //check if the sum is between 500 and 700
        if (numberOfItems >= 500 && numberOfItems <= 700) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }
        // What's the difference between findElement vs findElements?
        // - findElement will get single element and findElements will get list of element
        // - if element not inside the DOM (Document Object Model - UI), the findElement throws
        //   NoSuchElement exception and findElements will return 0 size List.

        // Find out if element exist in the DOM
        if (driver.findElements(By.id("dashboard-link")).size() != 0) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }
        System.out.println("---------");

        //TODO Print all items from the table. In this format (start with printing just the names): <Computer name> | <Introduced> | <Discontinued> | <Company>
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : rows) {
            // <tr>
            // <td> <a href="/computers/381">ACE</a></td>
            // <td></td>
            // <td></td>
            // <td></td>
            // </tr>
            List<WebElement> clms = row.findElements(By.xpath("td"));
            System.out.println("Computer name " + clms.get(0).getText());
            System.out.println("Introduced: " + clms.get(1).getText());
            System.out.println("Discontinued: " + clms.get(2).getText());
            System.out.println("Company: " + clms.get(3).getText());
            //System.out.println(clms.get(0).getText() + " | " + clms.get(1).getText() + " | " + clms.get(2).getText() + " | " + clms.get(3).getText());
        }
        System.out.println("----------------------------");

        //TODO Verify that 10 items are displayed. if 10 items are not displayed then print failed otherwise pass.
        System.out.println("Number of rows displayed: " + rows.size());
        if (rows.size() == 10) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        //TODO Verify that the computer names are displayed in alphabetical order
        List<WebElement> firstColumnItems = driver.findElements(By.xpath("//table/tbody/tr/td[1]/a"));
        // first approach
        List<String> firstColumnTxt = firstColumnItems.stream().map(itemElement -> itemElement.getText()).collect(Collectors.toList());
        //below is the same code as line 81
//        List<String> firstColumnTxt = new ArrayList<>();
//        for (WebElement element : firstColumnItems) {
//            firstColumnTxt.add(element.getText());
//        }

        //1. Take a copy of original list
        List <String> copyofFirstColumnTxt = new ArrayList<>(firstColumnTxt);
        //2. sort that copy
        Collections.sort(copyofFirstColumnTxt);
        //3. compare original list with sorted list, if they are equal, then original was sorted, otherwise it wasn't
        if (firstColumnTxt.equals(copyofFirstColumnTxt)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        //second approach (this approach is better because we are not using sorting)
        boolean isSorted = true;
        List<WebElement> firstColumnItems2 = driver.findElements(By.xpath("//table/tbody/tr/td[1]/a"));
        for (int i = 0; i < firstColumnItems2.size() - 1; i++) {
            String itemOne = firstColumnItems2.get(i).getText();
            String itemTwo = firstColumnItems2.get(i + 1).getText();
            //The result is a negative integer if this String object lexicographically precedes the argument string
            //The result is a positive integer if this String object lexicographically follows the argument string
            if (itemOne.compareTo(itemTwo) > 0) {
                isSorted = false;
                break;
            }
        }
        if  (isSorted) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }




        driver.close();
    }
}
