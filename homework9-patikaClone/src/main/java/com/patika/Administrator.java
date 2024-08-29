package com.patika;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    private List<Course> courses = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    // Method to add course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to remove course
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Method to add instructor
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    // Method to remove instructor
    public void removeInstructor(Instructor instructor) {
        instructors.remove(instructor);
    }

    // Method to add student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove student
    public void removeStudent(Student student) {
        students.remove(student);
    }
}

