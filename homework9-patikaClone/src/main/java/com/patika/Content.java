package com.patika;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
public class Content {
    private String title;
    private String description;
    private String youtubeLink;
    private List<Question> quizQuestions = new ArrayList<>();
    private Course course;
    private List<String> comments = new ArrayList<>();

    public void setRating(Student student, int rating){
        student.setRating(rating);
    }

    // Getters and setters

    public void addQuizQuestion(Question question) {
        quizQuestions.add(question);
    }

    public void removeQuizQuestion(Question question) {
        quizQuestions.remove(question);
    }

    public void addComment(Student student, String comment) {
        comments.add(comment);
    }

    // toString method for displaying
}

