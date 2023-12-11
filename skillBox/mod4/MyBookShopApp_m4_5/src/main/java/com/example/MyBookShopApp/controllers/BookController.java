package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService booksList;
    @Autowired
    public BookController(BookService booksList) {
        this.booksList = booksList;
    }
    @ModelAttribute("booksList")
    public List<Book> booksList(){
        return booksList.getBooksData();
    }
    @GetMapping("/recent")
    public String recentBookPage(){
        return "/books/recent";
    }
    @GetMapping("/popular")
    public String popularBookPage(){
        return "/books/popular";
    }

}
