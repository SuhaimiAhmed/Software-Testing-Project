package TestingProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("12345", "John Doe");
    }

    // Constructor tests
    @Test
    public void testConstructorWithValidInputs() {
        Student s = new Student("12345", "John Doe");
        assertEquals("12345", s.getId());
        assertEquals("John Doe", s.getName());
        assertNotNull(s.getCourses());
        assertTrue(s.getCourses().isEmpty());
    }

    @Test
    public void testConstructorWithNullId() {
        Student s = new Student(null, "Jane Doe");
        assertEquals("0000", s.getId());
        assertEquals("Jane Doe", s.getName());
    }

    @Test
    public void testConstructorWithEmptyId() {
        Student s = new Student("", "Jane Doe");
        assertEquals("0000", s.getId());
        assertEquals("Jane Doe", s.getName());
    }

    @Test
    public void testConstructorWithNullName() {
        Student s = new Student("54321", null);
        assertEquals("54321", s.getId());
        assertEquals("Unknown", s.getName());
    }

    @Test
    public void testConstructorWithEmptyName() {
        Student s = new Student("54321", "");
        assertEquals("54321", s.getId());
        assertEquals("Unknown", s.getName());
    }

    @Test
    public void testConstructorWithNullIdAndName() {
        Student s = new Student(null, null);
        assertEquals("0000", s.getId());
        assertEquals("Unknown", s.getName());
    }

    // enrollCourse tests
    @Test
    public void testEnrollCourseWithValidCourse() {
        Course course = new Course("Math", 3, "A");
        student.enrollCourse(course);
        assertEquals(1, student.getCourses().size());
        assertTrue(student.getCourses().contains(course));
    }

    @Test
    public void testEnrollCourseWithNullCourse() {
        student.enrollCourse(null);
        assertEquals(0, student.getCourses().size());
    }

    @Test
    public void testEnrollMultipleCourses() {
        Course course1 = new Course("Math", 3, "A");
        Course course2 = new Course("English", 3, "B");
        Course course3 = new Course("Science", 4, "A");

        student.enrollCourse(course1);
        student.enrollCourse(course2);
        student.enrollCourse(course3);

        assertEquals(3, student.getCourses().size());
    }

    // getId tests
    @Test
    public void testGetId() {
        assertEquals("12345", student.getId());
    }

    // getName tests
    @Test
    public void testGetName() {
        assertEquals("John Doe", student.getName());
    }

    // getCourses tests
    @Test
    public void testGetCoursesInitiallyEmpty() {
        Student s = new Student("123", "Test");
        assertNotNull(s.getCourses());
        assertEquals(0, s.getCourses().size());
    }

    @Test
    public void testGetCoursesAfterEnrollment() {
        Course course = new Course("History", 3, "B");
        student.enrollCourse(course);
        assertEquals(1, student.getCourses().size());
        assertEquals(course, student.getCourses().get(0));
    }

    // calculateGPA tests
    @Test
    public void testCalculateGPAWithNoCourses() {
        assertEquals(0.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithSingleCourseGradeA() {
        student.enrollCourse(new Course("Math", 3, "A"));
        assertEquals(4.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithSingleCourseGradeB() {
        student.enrollCourse(new Course("English", 3, "B"));
        assertEquals(3.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithSingleCourseGradeC() {
        student.enrollCourse(new Course("Science", 3, "C"));
        assertEquals(2.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithSingleCourseGradeD() {
        student.enrollCourse(new Course("PE", 2, "D"));
        assertEquals(1.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithSingleCourseGradeF() {
        student.enrollCourse(new Course("Art", 3, "F"));
        assertEquals(0.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithMultipleCoursesSameGrade() {
        student.enrollCourse(new Course("Math", 3, "A"));
        student.enrollCourse(new Course("English", 3, "A"));
        assertEquals(4.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithMultipleCoursesDifferentGrades() {
        student.enrollCourse(new Course("Math", 3, "A"));      // 4.0 * 3 = 12.0
        student.enrollCourse(new Course("English", 3, "B"));   // 3.0 * 3 = 9.0
        // Total: 21.0 / 6 = 3.5
        assertEquals(3.5, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithDifferentCreditHours() {
        student.enrollCourse(new Course("Math", 4, "A"));      // 4.0 * 4 = 16.0
        student.enrollCourse(new Course("English", 3, "B"));   // 3.0 * 3 = 9.0
        student.enrollCourse(new Course("PE", 1, "C"));        // 2.0 * 1 = 2.0
        // Total: 27.0 / 8 = 3.375
        assertEquals(3.375, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPAWithAllGrades() {
        student.enrollCourse(new Course("Math", 3, "A"));      // 4.0 * 3 = 12.0
        student.enrollCourse(new Course("English", 3, "B"));   // 3.0 * 3 = 9.0
        student.enrollCourse(new Course("Science", 3, "C"));   // 2.0 * 3 = 6.0
        student.enrollCourse(new Course("History", 3, "D"));   // 1.0 * 3 = 3.0
        student.enrollCourse(new Course("Art", 3, "F"));       // 0.0 * 3 = 0.0
        // Total: 30.0 / 15 = 2.0
        assertEquals(2.0, student.calculateGPA(), 0.001);
    }

    @Test
    public void testCalculateGPACappedAt4Point0() {
        // Even if calculation would exceed 4.0, it should be capped
        // This tests the safety cap in the code
        student.enrollCourse(new Course("Math", 3, "A"));
        double gpa = student.calculateGPA();
        assertTrue(gpa <= 4.0);
        assertEquals(4.0, gpa, 0.001);
    }
}
