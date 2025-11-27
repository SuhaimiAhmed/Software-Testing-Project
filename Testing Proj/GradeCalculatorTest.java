package TestingProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    // Tests for grade A (90-100)
    @Test
    public void testCalculateLetterGradeForScore90() {
        assertEquals("A", calculator.calculateLetterGrade(90));
    }

    @Test
    public void testCalculateLetterGradeForScore95() {
        assertEquals("A", calculator.calculateLetterGrade(95));
    }

    @Test
    public void testCalculateLetterGradeForScore100() {
        assertEquals("A", calculator.calculateLetterGrade(100));
    }

    // Tests for grade B (80-89)
    @Test
    public void testCalculateLetterGradeForScore80() {
        assertEquals("B", calculator.calculateLetterGrade(80));
    }

    @Test
    public void testCalculateLetterGradeForScore85() {
        assertEquals("B", calculator.calculateLetterGrade(85));
    }

    @Test
    public void testCalculateLetterGradeForScore89() {
        assertEquals("B", calculator.calculateLetterGrade(89));
    }

    // Tests for grade C (70-79)
    @Test
    public void testCalculateLetterGradeForScore70() {
        assertEquals("C", calculator.calculateLetterGrade(70));
    }

    @Test
    public void testCalculateLetterGradeForScore75() {
        assertEquals("C", calculator.calculateLetterGrade(75));
    }

    @Test
    public void testCalculateLetterGradeForScore79() {
        assertEquals("C", calculator.calculateLetterGrade(79));
    }

    // Tests for grade D (60-69)
    @Test
    public void testCalculateLetterGradeForScore60() {
        assertEquals("D", calculator.calculateLetterGrade(60));
    }

    @Test
    public void testCalculateLetterGradeForScore65() {
        assertEquals("D", calculator.calculateLetterGrade(65));
    }

    @Test
    public void testCalculateLetterGradeForScore69() {
        assertEquals("D", calculator.calculateLetterGrade(69));
    }

    // Tests for grade F (0-59)
    @Test
    public void testCalculateLetterGradeForScore0() {
        assertEquals("F", calculator.calculateLetterGrade(0));
    }

    @Test
    public void testCalculateLetterGradeForScore30() {
        assertEquals("F", calculator.calculateLetterGrade(30));
    }

    @Test
    public void testCalculateLetterGradeForScore59() {
        assertEquals("F", calculator.calculateLetterGrade(59));
    }

    // Boundary value tests
    @Test
    public void testCalculateLetterGradeBoundary59To60() {
        assertEquals("F", calculator.calculateLetterGrade(59));
        assertEquals("D", calculator.calculateLetterGrade(60));
    }

    @Test
    public void testCalculateLetterGradeBoundary69To70() {
        assertEquals("D", calculator.calculateLetterGrade(69));
        assertEquals("C", calculator.calculateLetterGrade(70));
    }

    @Test
    public void testCalculateLetterGradeBoundary79To80() {
        assertEquals("C", calculator.calculateLetterGrade(79));
        assertEquals("B", calculator.calculateLetterGrade(80));
    }

    @Test
    public void testCalculateLetterGradeBoundary89To90() {
        assertEquals("B", calculator.calculateLetterGrade(89));
        assertEquals("A", calculator.calculateLetterGrade(90));
    }

    // Invalid input tests (out of range)
    @Test
    public void testCalculateLetterGradeForNegativeScore() {
        assertEquals("Invalid", calculator.calculateLetterGrade(-1));
    }

    @Test
    public void testCalculateLetterGradeForScoreNegative100() {
        assertEquals("Invalid", calculator.calculateLetterGrade(-100));
    }

    @Test
    public void testCalculateLetterGradeForScore101() {
        assertEquals("Invalid", calculator.calculateLetterGrade(101));
    }

    @Test
    public void testCalculateLetterGradeForScore200() {
        assertEquals("Invalid", calculator.calculateLetterGrade(200));
    }

    @Test
    public void testCalculateLetterGradeForMinInteger() {
        assertEquals("Invalid", calculator.calculateLetterGrade(Integer.MIN_VALUE));
    }

    @Test
    public void testCalculateLetterGradeForMaxInteger() {
        assertEquals("Invalid", calculator.calculateLetterGrade(Integer.MAX_VALUE));
    }

    // Equivalence partitioning tests - one from each partition
    @Test
    public void testEquivalencePartitionInvalid_Below0() {
        assertEquals("Invalid", calculator.calculateLetterGrade(-50));
    }

    @Test
    public void testEquivalencePartitionF_0To59() {
        assertEquals("F", calculator.calculateLetterGrade(45));
    }

    @Test
    public void testEquivalencePartitionD_60To69() {
        assertEquals("D", calculator.calculateLetterGrade(64));
    }

    @Test
    public void testEquivalencePartitionC_70To79() {
        assertEquals("C", calculator.calculateLetterGrade(73));
    }

    @Test
    public void testEquivalencePartitionB_80To89() {
        assertEquals("B", calculator.calculateLetterGrade(84));
    }

    @Test
    public void testEquivalencePartitionA_90To100() {
        assertEquals("A", calculator.calculateLetterGrade(97));
    }

    @Test
    public void testEquivalencePartitionInvalid_Above100() {
        assertEquals("Invalid", calculator.calculateLetterGrade(150));
    }

    // Additional edge cases
    @Test
    public void testCalculateLetterGradeForScore1() {
        assertEquals("F", calculator.calculateLetterGrade(1));
    }

    @Test
    public void testCalculateLetterGradeForScore99() {
        assertEquals("A", calculator.calculateLetterGrade(99));
    }

    @Test
    public void testCalculateLetterGradeForScore50() {
        assertEquals("F", calculator.calculateLetterGrade(50));
    }
}
