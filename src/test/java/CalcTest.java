import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {

    @Test
    public void additionalTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.additional(2, 3), 5, "Additional action is failed");
    }

    @Test
    public void subtractionTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtraction(5, 3), 2, "Subtraction action is failed");
    }

    @Test
    public void multiplicationTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiplication(2, 3), 6, "multiplication action is failed");
    }

    @Test
    public void divisionTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.division(6, 3), 2, "Division action is failed");
    }
}
