package com.patika.bootcamp.patikabootcamp.effectivejava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Book {

    private String name;
    private String author;
    private String isbn;
    private Integer pageCount;
    private String language;

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.pageCount = 178;
        b1.language = "TR";

        Book b2 = new Book();
        b2.pageCount = 260;
        b1.language = "EN";

        Book b3 = new Book();
        b3.pageCount = 350;
        b1.language = "TR";

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        ////
        List<Book> processedBooks = bookList.stream()
                .filter(book -> book.pageCount > 300)
                .filter(Book::isLanguageTr)
                .collect(Collectors.toList());

        Predicate<Integer> checkPageCount = b1::isPageCountBiggerThan;
        System.out.println(checkPageCount.test(289));
        System.out.println(b1.isPageCountBiggerThan(289));
    }

    public boolean isPageCountBiggerThan(int limitPageCount) {
        return pageCount > limitPageCount;
    }

    public boolean isLanguageTr() {
        return language.equals("TR");
    }
}
