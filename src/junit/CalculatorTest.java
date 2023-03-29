package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

public class CalculatorTest {

    private Calculator calculator;
    
    @BeforeAll
    public void load() {
    	calculator = new Calculator();
    }
    
    @AfterAll
    public void close() {
    	System.out.println("All test completed!");
    }
    
    @BeforeEach
    public void logInitOfTest() {
    	System.out.println("Test started!");
    }
    
    @AfterEach
    public void logEndOfTest() {
    	System.out.println("Test finished!");
    }
    
    @Test
    public void testAdd() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(0, calculator.subtract(2, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(4, 2));
        try {
            calculator.divide(4, 0);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }

    @Test
    public void testIsEven() {
        assertTrue(calculator.isEven(2));
        assertFalse(calculator.isEven(3));
    }
}
