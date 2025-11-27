package TestingProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course course;

    @BeforeEach
    public void setUp() {
        course = new Course("Mathematics", 3, "A");
    }

    // Constructor tests with valid inputs
    @Test
    public void testConstructorWithValidInputs() {
        Course c = new Course("Physics", 4, "B");
        assertEquals("Physics", c.getCourseName());
        assertEquals(4, c.getCreditHours());
        assertEquals("B", c.getLetterGrade());
    }

    @Test
    public void testConstructorWithAllValidGrades() {
        Course cA = new Course("Course1", 3, "A");
        Course cB = new Course("Course2", 3, "B");
        Course cC = new Course("Course3", 3, "C");
        Course cD = new Course("Course4", 3, "D");
        Course cF = new Course("Course5", 3, "F");

        assertEquals("A", cA.getLetterGrade());
        assertEquals("B", cB.getLetterGrade());
        assertEquals("C", cC.getLetterGrade());
        assertEquals("D", cD.getLetterGrade());
        assertEquals("F", cF.getLetterGrade());
    }

    // Constructor tests with null/empty course name
    @Test
    public void testConstructorWithNullCourseName() {
        Course c = new Course(null, 3, "A");
        assertEquals("Unknown", c.getCourseName());
        assertEquals(3, c.getCreditHours());
        assertEquals("A", c.getLetterGrade());
    }

    @Test
    public void testConstructorWithEmptyCourseName() {
        Course c = new Course("", 3, "B");
        assertEquals("Unknown", c.getCourseName());
        assertEquals(3, c.getCreditHours());
        assertEquals("B", c.getLetterGrade());
    }

    // Constructor tests with invalid credit hours
    @Test
    public void testConstructorWithCreditHoursZero() {
        Course c = new Course("History", 0, "A");
        assertEquals(3, c.getCreditHours()); // defaults to 3
    }

    @Test
    public void testConstructorWithNegativeCreditHours() {
        Course c = new Course("History", -1, "A");
        assertEquals(3, c.getCreditHours()); // defaults to 3
    }

    @Test
    public void testConstructorWithCreditHoursSeven() {
        Course c = new Course("History", 7, "A");
        assertEquals(3, c.getCreditHours()); // defaults to 3
    }

    @Test
    public void testConstructorWithCreditHoursAboveMax() {
        Course c = new Course("History", 100, "A");
        assertEquals(3, c.getCreditHours()); // defaults to 3
    }

    @Test
    public void testConstructorWithMinValidCreditHours() {
        Course c = new Course("Lab", 1, "A");
        assertEquals(1, c.getCreditHours());
    }

    @Test
    public void testConstructorWithMaxValidCreditHours() {
        Course c = new Course("Thesis", 6, "A");
        assertEquals(6, c.getCreditHours());
    }

    @Test
    public void testConstructorWithCreditHoursInRange() {
        for (int i = 1; i <= 6; i++) {
            Course c = new Course("Course" + i, i, "A");
            assertEquals(i, c.getCreditHours());
        }
    }

    // Constructor tests with invalid letter grades
    @Test
    public void testConstructorWithNullGrade() {
        Course c = new Course("English", 3, null);
        assertEquals("F", c.getLetterGrade()); // defaults to F
    }

    @Test
    public void testConstructorWithInvalidGradeString() {
        Course c = new Course("English", 3, "X");
        assertEquals("F", c.getLetterGrade()); // defaults to F
    }

    @Test
    public void testConstructorWithLowercaseGrade() {
        Course c = new Course("English", 3, "a");
        assertEquals("F", c.getLetterGrade()); // defaults to F (case-sensitive)
    }

    @Test
    public void testConstructorWithPlusMinusGrade() {
        Course c = new Course("English", 3, "A+");
        assertEquals("F", c.getLetterGrade()); // defaults to F
    }

    @Test
    public void testConstructorWithEmptyGrade() {
        Course c = new Course("English", 3, "");
        assertEquals("F", c.getLetterGrade()); // defaults to F
    }

    @Test
    public void testConstructorWithNumericGrade() {
        Course c = new Course("English", 3, "90");
        assertEquals("F", c.getLetterGrade()); // defaults to F
    }

    // getCourseName tests
    @Test
    public void testGetCourseName() {
        assertEquals("Mathematics", course.getCourseName());
    }

    @Test
    public void testGetCourseNameAfterDefaultSet() {
        Course c = new Course(null, 3, "A");
        assertEquals("Unknown", c.getCourseName());
    }

    // getCreditHours tests
    @Test
    public void testGetCreditHours() {
        assertEquals(3, course.getCreditHours());
    }

    @Test
    public void testGetCreditHoursAfterDefaultSet() {
        Course c = new Course("Test", 0, "A");
        assertEquals(3, c.getCreditHours());
    }

    // getLetterGrade tests
    @Test
    public void testGetLetterGrade() {
        assertEquals("A", course.getLetterGrade());
    }

    @Test
    public void testGetLetterGradeAfterDefaultSet() {
        Course c = new Course("Test", 3, null);
        assertEquals("F", c.getLetterGrade());
    }

    // getGradePoint tests
    @Test
    public void testGetGradePointForA() {
        Course c = new Course("Course", 3, "A");
        assertEquals(4.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testGetGradePointForB() {
        Course c = new Course("Course", 3, "B");
        assertEquals(3.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testGetGradePointForC() {
        Course c = new Course("Course", 3, "C");
        assertEquals(2.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testGetGradePointForD() {
        Course c = new Course("Course", 3, "D");
        assertEquals(1.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testGetGradePointForF() {
        Course c = new Course("Course", 3, "F");
        assertEquals(0.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testGetGradePointForDefaultGrade() {
        Course c = new Course("Course", 3, "Invalid");
        assertEquals(0.0, c.getGradePoint(), 0.001);
    }

    // Comprehensive integration tests
    @Test
    public void testCourseWithAllDefaults() {
        Course c = new Course(null, 0, null);
        assertEquals("Unknown", c.getCourseName());
        assertEquals(3, c.getCreditHours());
        assertEquals("F", c.getLetterGrade());
        assertEquals(0.0, c.getGradePoint(), 0.001);
    }

    @Test
    public void testCourseWithMixedValidAndInvalidInputs() {
        Course c = new Course("Valid Name", -5, "InvalidGrade");
        assertEquals("Valid Name", c.getCourseName());
        assertEquals(3, c.getCreditHours()); // defaulted
        assertEquals("F", c.getLetterGrade()); // defaulted
    }
}
