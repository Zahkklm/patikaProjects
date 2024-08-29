package com.patika;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
public class Course {
    private String name;
    private List<Content> contents = new ArrayList<>();

    // Getters and setters

    public void addContent(Content content) {
        contents.add(content);
    }

    public void removeContent(Content content) {
        contents.remove(content);
    }

    // toString method for displaying
}
