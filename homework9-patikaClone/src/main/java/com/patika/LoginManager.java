package com.patika;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private Map<String, User> userDatabase = new HashMap<>();

    // Method to register a new student
    public void registerStudent(String username, String password, String email) {
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setEmail(email);
        userDatabase.put(username, student);
    }

    // Method to login
    public User login(String username, String password) {
        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setLastLogin(new Date());
            return user;
        }
        return null;
    }

    // Method to add instructor (only by admin)
    public void addInstructor(String username, String password, String email) {
        Administrator admin = (Administrator) userDatabase.get("admin"); // Assuming admin is always available
        if (admin != null) {
            Instructor instructor = new Instructor();
            instructor.setUsername(username);
            instructor.setPassword(password);
            instructor.setEmail(email);
            userDatabase.put(username, instructor);
        }
    }
}

