package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        final List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/addAuthor")
    public String showCreateForm(Author author) {
        return "add-author";
    }

    @PostMapping("/add-author")
    public String createAuthor(Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-author";
        }

        authorService.createAuthor(author);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable("id") Long id, Model model) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @GetMapping("/update-author/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable("id") Long id, Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "update-author";
        }
        authorService.updateAuthor(author);
        return "redirect:/authors";
    }



}
