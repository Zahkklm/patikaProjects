package com.patika;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Basit bir tarih formatı tanımlıyoruz
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 10 tane kitap nesnesi oluşturuyoruz
        List<Book> books = Arrays.asList(
                new Book("Java Programming", 350, "John Doe", parseDate("2020-01-15")),
                new Book("Advanced Java", 200, "Jane Doe", parseDate("2019-03-22")),
                new Book("Data Structures", 120, "Jim Beam", parseDate("2018-07-10")),
                new Book("Algorithms", 90, "Alice Smith", parseDate("2021-02-20")),
                new Book("Introduction to Databases", 250, "Bob Brown", parseDate("2020-11-05")),
                new Book("Web Development", 300, "Carol Jones", parseDate("2017-09-13")),
                new Book("Machine Learning", 400, "David Wilson", parseDate("2021-05-18")),
                new Book("Operating Systems", 150, "Emily Davis", parseDate("2016-12-12")),
                new Book("Computer Networks", 80, "Frank Harris", parseDate("2022-01-30")),
                new Book("Software Engineering", 220, "Grace Lee", parseDate("2018-08-23"))
        );

        // Kitap ismini anahtar, yazar ismini değer olarak içeren bir Map oluşturuyoruz.
        Map<String, String> bookAuthorMap = books.stream()
                .collect(Collectors.toMap(
                        Book::getTitle,
                        Book::getAuthor
                ));

        // Sayfa sayısı 100'den fazla olan kitapları filtreliyoruz.
        List<Book> booksWithMoreThan100Pages = books.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        // Sonuçları yazdırıyoruz
        System.out.println("Book and Author Map:");
        bookAuthorMap.forEach((title, author) -> System.out.println("Title: " + title + ", Author: " + author));

        System.out.println("\nBooks with more than 100 pages:");
        booksWithMoreThan100Pages.forEach(System.out::println);
    }

    // Tarih formatında bir String'i Date nesnesine çeviriyoruz.
    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
