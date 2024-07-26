package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.CategoryService;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/add")
    public String showCreateForm(Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String createBook(@ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/books/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "update-book";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }



/*
    @Autowired
    private  BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
     CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;
   @GetMapping("/books")
    public String findAllBooks(Model model) {
        final List<Book> books = bookService.findAllBooks();

        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/book/{id}")
    public String findBookById(@PathVariable("id") Long id, Model model) {
        final Book book = bookService.findBookById(id);

        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/books/remove-book/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBook(id);

        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/books/update/{id}")
    public String UpdateBook(@PathVariable("id") Long id, Model model) {
         Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());

        return "update-book";
    }
*/


}
