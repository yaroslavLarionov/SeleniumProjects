import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasicMathTest {

    @Test
    public void testAdd() {
        BasicMath math = new BasicMath();
        int testData1 = 4;
        int testData2 = 34;
        int expectedData = testData1 + testData2;
        int actualData = math.add(testData1, testData2);

        Assert.assertEquals(actualData, expectedData);
    }

    @Test
    public void testSubtract() {
        BasicMath math = new BasicMath();
        int testData1 = 4;
        int testData2 = 34;
        int expectedData = testData1 - testData2;
        int actualData = math.subtract(testData1, testData2);

        Assert.assertEquals(actualData, expectedData);
    }

    @Test
    public void testDivide() {
        BasicMath math = new BasicMath();
        double testData1 = 20.4;
        double testData2 = 2.2;
        double expectedData = testData1 / testData2;
        double actualData = math.divide(testData1, testData2);

        Assert.assertEquals(actualData, expectedData);
    }

    @Test
    public void testMultiply() {
        BasicMath math = new BasicMath();
        int testData1 = 4;
        int testData2 = 34;
        int expectedData = testData1 * testData2;
        int actualData = math.multiply(testData1, testData2);

        Assert.assertEquals(actualData, expectedData);
    }
}
