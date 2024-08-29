package com.patika;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
public class Student extends User {
    private int rating;
    private List<Course> enrolledCourses = new ArrayList<>();

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Method to view course content
    public void viewCourseContent(Course course) {
        if (enrolledCourses.contains(course)) {
            course.getContents().forEach(System.out::println);
        } else {
            System.out.println("Not enrolled in this course.");
        }
    }

    // Method to rate content
    public void rateContent(Content content, int rating) {
        content.setRating(this, rating);
    }

    // Method to comment on content
    public void commentOnContent(Content content, String comment) {
        content.addComment(this, comment);
    }
}
