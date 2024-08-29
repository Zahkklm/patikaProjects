package com.patika;

import java.util.Comparator;

public class PageCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getPageCount(), b2.getPageCount()); // Sayfa sayısına göre sıralama
    }
}
