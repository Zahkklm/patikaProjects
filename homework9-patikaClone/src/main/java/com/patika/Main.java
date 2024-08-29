package com.patika;

public class Main {
    public static void main(String[] args) {
        // Create instances of LoginManager, Administrator, and other users
        LoginManager loginManager = new LoginManager();
        Administrator admin = new Administrator();

        // Register and login users
        loginManager.registerStudent("student1", "password", "student1@example.com");
        loginManager.addInstructor("instructor1", "password", "instructor1@example.com");
        User student = loginManager.login("student1", "password");
        User instructor = loginManager.login("instructor1", "password");

        // Cast to specific user type and perform actions
        if (student instanceof Student) {
            Student s = (Student) student;
            System.out.println("Student logged in: " + s.getUsername());
        }

        if (instructor instanceof Instructor) {
            Instructor i = (Instructor) instructor;
            System.out.println("Instructor logged in: " + i.getUsername());

            // Example of adding content
            Course course = new Course();
            Content content = new Content();
            content.setTitle("Java Basics");
            content.setDescription("Introduction to Java");
            i.addContent(content);

            // List contents
            i.listContents();
        }
    }
}
