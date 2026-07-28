package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.repository.BookRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class BookService {

    private BookRepository repository;
    private NotificationService notificationService;

    @Value("${library.name}")
    private String libraryName;

    @Value("${library.totalBooks}")
    private int totalBooks;

    @Autowired
    public BookService(BookRepository repository,
            @Qualifier("emailNotification") NotificationService notificationService) {

        this.repository = repository;
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void init() {

        System.out.println("Loading Library...");
        System.out.println("Library Name : " + libraryName);
        System.out.println("Total Books : " + totalBooks);
        System.out.println();
    }

    public void addBook() {

        repository.saveBook();
        notificationService.sendNotification();

        System.out.println("Book Added Successfully");
        System.out.println();
    }

    public void issueBook() {

        System.out.println("Book Issued Successfully");
        System.out.println();
    }

    public void returnBook() {

        System.out.println("Book Returned Successfully");
        System.out.println();
    }

    public void searchBook() {

        System.out.println("Searching Book...");
        System.out.println();
    }

    @PreDestroy
    public void destroy() {

        System.out.println("Closing Library...");
    }

}