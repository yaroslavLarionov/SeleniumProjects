import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringManipulationMethodsTest {

    @Test
    public void returnInitialsInCaps() {
        StringManipulationMethods obj = new StringManipulationMethods();
        String str = "hello world";
        String expectedStr = "Hello World";
        String actualStr = obj.returnInitialsInCaps(str);

        Assert.assertEquals(actualStr, expectedStr);
    }
    //I need a functionality that takes company or person names and return only initials in capital letter
//Ex: Tech Lead Academy => TLA, John Doe => JD

    @Test
    public void testReturnInitials(){
        StringManipulationMethods manipulation = new StringManipulationMethods();

        String testData = "Tech Lead Academy";
        String expectedResult = "TLA";
        String actualResult = manipulation.returnInitials(testData);

        Assert.assertEquals(actualResult, expectedResult);
    }
}