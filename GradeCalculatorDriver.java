package TestingProject;

/**
 * Driver class to demonstrate black-box testing techniques for GradeCalculator.
 * This driver tests the calculateLetterGrade method using:
 * 1. Equivalence Partitioning
 * 2. Boundary Value Analysis
 */
public class GradeCalculatorDriver {

    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();

        System.out.println("========================================================");
        System.out.println("BLACK-BOX TESTING: GradeCalculator.calculateLetterGrade");
        System.out.println("========================================================\n");

        // EQUIVALENCE PARTITIONING
        System.out.println("1. EQUIVALENCE PARTITIONING");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Testing one representative value from each equivalence class:\n");

        // Equivalence Class 1: Invalid (score < 0)
        System.out.println("Equivalence Class 1: Invalid (score < 0)");
        testScore(calculator, -50, "Invalid");

        // Equivalence Class 2: F (0 <= score <= 59)
        System.out.println("\nEquivalence Class 2: F (0 <= score <= 59)");
        testScore(calculator, 45, "F");

        // Equivalence Class 3: D (60 <= score <= 69)
        System.out.println("\nEquivalence Class 3: D (60 <= score <= 69)");
        testScore(calculator, 65, "D");

        // Equivalence Class 4: C (70 <= score <= 79)
        System.out.println("\nEquivalence Class 4: C (70 <= score <= 79)");
        testScore(calculator, 75, "C");

        // Equivalence Class 5: B (80 <= score <= 89)
        System.out.println("\nEquivalence Class 5: B (80 <= score <= 89)");
        testScore(calculator, 85, "B");

        // Equivalence Class 6: A (90 <= score <= 100)
        System.out.println("\nEquivalence Class 6: A (90 <= score <= 100)");
        testScore(calculator, 95, "A");

        // Equivalence Class 7: Invalid (score > 100)
        System.out.println("\nEquivalence Class 7: Invalid (score > 100)");
        testScore(calculator, 150, "Invalid");

        // BOUNDARY VALUE ANALYSIS
        System.out.println("\n\n2. BOUNDARY VALUE ANALYSIS");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Testing boundary values at each transition point:\n");

        // Lower boundary (around 0)
        System.out.println("Lower Boundary (Invalid / F transition at 0):");
        testScore(calculator, -1, "Invalid");
        testScore(calculator, 0, "F");
        testScore(calculator, 1, "F");

        // F/D boundary (around 60)
        System.out.println("\nF/D Boundary (transition at 60):");
        testScore(calculator, 59, "F");
        testScore(calculator, 60, "D");
        testScore(calculator, 61, "D");

        // D/C boundary (around 70)
        System.out.println("\nD/C Boundary (transition at 70):");
        testScore(calculator, 69, "D");
        testScore(calculator, 70, "C");
        testScore(calculator, 71, "C");

        // C/B boundary (around 80)
        System.out.println("\nC/B Boundary (transition at 80):");
        testScore(calculator, 79, "C");
        testScore(calculator, 80, "B");
        testScore(calculator, 81, "B");

        // B/A boundary (around 90)
        System.out.println("\nB/A Boundary (transition at 90):");
        testScore(calculator, 89, "B");
        testScore(calculator, 90, "A");
        testScore(calculator, 91, "A");

        // Upper boundary (around 100)
        System.out.println("\nUpper Boundary (A / Invalid transition at 100):");
        testScore(calculator, 99, "A");
        testScore(calculator, 100, "A");
        testScore(calculator, 101, "Invalid");

        // SUMMARY
        System.out.println("\n========================================================");
        System.out.println("TESTING COMPLETE");
        System.out.println("========================================================");
        System.out.println("Total test cases executed: 20");
        System.out.println("  - Equivalence Partitioning: 7 test cases");
        System.out.println("  - Boundary Value Analysis: 13 test cases");
        System.out.println("========================================================");
    }

    /**
     * Helper method to test a score and display the result.
     *
     * @param calculator The GradeCalculator instance
     * @param score The score to test
     * @param expected The expected letter grade
     */
    private static void testScore(GradeCalculator calculator, int score, String expected) {
        String result = calculator.calculateLetterGrade(score);
        boolean passed = result.equals(expected);
        String status = passed ? "[PASS]" : "[FAIL]";

        System.out.printf("  %-8s Score: %-4d => Grade: %-8s (Expected: %s)%n",
                         status, score, result, expected);

        if (!passed) {
            System.out.println("    ERROR: Expected '" + expected + "' but got '" + result + "'");
        }
    }
}
