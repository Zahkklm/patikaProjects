package com.patika;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private List<Content> managedContents = new ArrayList<>();

    // Method to add content
    public void addContent(Content content) {
        managedContents.add(content);
    }

    // Method to edit content
    public void editContent(Content content, String title, String description, String youtubeLink) {
        if (managedContents.contains(content)) {
            content.setTitle(title);
            content.setDescription(description);
            content.setYoutubeLink(youtubeLink);
        } else {
            System.out.println("You do not have permission to edit this content.");
        }
    }

    // Method to delete content
    public void deleteContent(Content content) {
        if (managedContents.contains(content)) {
            managedContents.remove(content);
        } else {
            System.out.println("You do not have permission to delete this content.");
        }
    }

    // Method to list contents
    public void listContents() {
        managedContents.forEach(System.out::println);
    }
}

