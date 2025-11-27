package TestingProject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Course> courses;

    public Student(String id, String name) {
        if (id == null || id.isEmpty()) {
            this.id = "0000";
        } else {
            this.id = id;
        }

        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double calculateGPA() {
        if (courses.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Course c : courses) {
            totalPoints += c.getGradePoint() * c.getCreditHours();
            totalCredits += c.getCreditHours();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        double gpa = totalPoints / totalCredits;

        // Cap GPA to 4.0 max for safety
        if (gpa > 4.0) {
            gpa = 4.0;
        }
        return gpa;
    }

    }
