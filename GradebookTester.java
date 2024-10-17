package lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradebookTester {

    private GradeBook g1;
    private GradeBook g2;

    @BeforeEach
    public void setUp() throws Exception {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add random scores as per instruction
        g1.addScore(50.0);
        g1.addScore(75.0);

        g2.addScore(60.0);
        g2.addScore(90.0);
    }

    @AfterEach
    public void tearDown() throws Exception {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        // Using toString() to compare the scores array vs. expected output
        assertTrue(g1.toString().equals("50.0 75.0"));
        assertTrue(g2.toString().equals("60.0 90.0"));

        // Comparing scoreSize with the expected number of scores
        assertEquals(2, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        // Testing the sum of the scores
        assertEquals(125.0, g1.sum(), 0.001);
        assertEquals(150.0, g2.sum(), 0.001);
    }

    @Test
    public void testMinimum() {
        // Testing the minimum score
        assertEquals(50.0, g1.minimum(), 0.001);
        assertEquals(60.0, g2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore() {
        // Testing the final score with the lowest score dropped
        assertEquals(75.0, g1.finalScore(), 0.001);
        assertEquals(90.0, g2.finalScore(), 0.001);
    }
}
