package com.patika;

import java.util.*;

public class BookSorterMain {
    public static void main(String[] args) {
        Set<Book> booksByTitle = new TreeSet<>();
        booksByTitle.add(new Book("Java Programming", 300, "John Doe", "2022-01-01"));
        booksByTitle.add(new Book("Effective Java", 250, "Joshua Bloch", "2018-03-01"));
        booksByTitle.add(new Book("Clean Code", 400, "Robert C. Martin", "2008-08-01"));
        booksByTitle.add(new Book("Design Patterns", 500, "Erich Gamma", "1994-10-01"));
        booksByTitle.add(new Book("Introduction to Algorithms", 800, "Thomas H. Cormen", "2009-07-01"));

        System.out.println("Books sorted by title:");
        for (Book book : booksByTitle) {
            System.out.println(book);
        }

        Set<Book> booksByPageCount = new TreeSet<>(new PageCountComparator());
        booksByPageCount.addAll(booksByTitle);

        System.out.println("\nBooks sorted by page count:");
        for (Book book : booksByPageCount) {
            System.out.println(book);
        }
    }
}
