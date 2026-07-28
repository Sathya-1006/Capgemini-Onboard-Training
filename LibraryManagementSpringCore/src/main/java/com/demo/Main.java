package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.AppConfig;
import com.demo.model.Book;
import com.demo.service.BookService;
import com.demo.util.LibraryInfo;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // BookService Bean
        BookService service = context.getBean(BookService.class);

        service.addBook();
        service.issueBook();
        service.returnBook();
        service.searchBook();

        // LibraryInfo Bean
        LibraryInfo info = context.getBean(LibraryInfo.class);
        info.displayInfo();

        System.out.println();

        // Prototype Scope Verification
        Book b1 = context.getBean(Book.class);
        Book b2 = context.getBean(Book.class);

        if (b1 != b2) {
            System.out.println("Prototype Scope Verified");
        }

        // Singleton Scope Verification
        BookService s1 = context.getBean(BookService.class);
        BookService s2 = context.getBean(BookService.class);

        if (s1 == s2) {
            System.out.println("Singleton Scope Verified");
        }

        context.close();

    }

}