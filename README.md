# Student Grade Management System

A lightweight Java-based application for managing student grades, courses, and GPA calculations. This system provides a simple yet robust solution for tracking academic performance with built-in validation and error handling.

## Features

- **Student Management**: Track student information with unique IDs and names
- **Course Enrollment**: Add multiple courses with credit hours and letter grades
- **GPA Calculation**: Automatic weighted GPA computation based on credit hours
- **Grade Conversion**: Convert numeric scores (0-100) to letter grades
- **Input Validation**: Built-in defensive programming with sensible defaults
- **Zero Dependencies**: Pure Java implementation with no external libraries

## Project Structure

```
TestingProject/
├── Student.java           # Core student entity with GPA calculation
├── Course.java           # Course representation with grade validation
└── GradeCalculator.java  # Utility for numeric-to-letter grade conversion
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation

**Compile all classes:**
```bash
javac -d . Student.java Course.java GradeCalculator.java
```

**Compile a single file:**
```bash
javac Student.java
```

### Running

To use the system, create a main class or use an interactive Java shell:

```java
import TestingProject.*;

public class Main {
    public static void main(String[] args) {
        // Create a student
        Student student = new Student("1001", "John Doe");

        // Add courses
        student.addCourse(new Course("CS101", "Intro to Programming", 3, "A"));
        student.addCourse(new Course("MATH201", "Calculus I", 4, "B"));
        student.addCourse(new Course("ENG101", "English Composition", 3, "A"));

        // Calculate and display GPA
        System.out.println("Student: " + student.getName());
        System.out.println("GPA: " + student.calculateGPA());
    }
}
```

## Usage

### Creating Students

```java
Student student = new Student("1234", "Jane Smith");
```

### Adding Courses

```java
Course course = new Course("CS101", "Computer Science", 3, "A");
student.addCourse(course);
```

### Calculating GPA

```java
double gpa = student.calculateGPA();  // Returns weighted GPA (max 4.0)
```

### Converting Numeric Grades

```java
String letterGrade = GradeCalculator.getLetterGrade(85);  // Returns "B"
```

## Grading Scale

| Letter Grade | Grade Points | Numeric Range |
|--------------|--------------|---------------|
| A            | 4.0          | 90-100        |
| B            | 3.0          | 80-89         |
| C            | 2.0          | 70-79         |
| D            | 1.0          | 60-69         |
| F            | 0.0          | 0-59          |

## Validation Rules

- **Student ID**: Defaults to "0000" if null or empty
- **Student Name**: Defaults to "Unknown" if null or empty
- **Credit Hours**: Valid range 1-6, defaults to 3
- **Letter Grades**: Only A, B, C, D, F accepted, defaults to F
- **GPA**: Automatically capped at 4.0 maximum

## Design Principles

- **Defensive Programming**: All inputs validated with sensible defaults
- **No Exceptions**: Invalid inputs use default values instead of throwing errors
- **Encapsulation**: Grade calculations encapsulated within appropriate classes
- **In-Memory**: No database or file persistence required

