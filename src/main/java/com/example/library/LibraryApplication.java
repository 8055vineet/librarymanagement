package com.example.library;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import com.example.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}
@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return args -> {
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test namel","Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher", "description1");
			book1.addAuthor (author1);
			book1. addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My first book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher","description 2");
			book2.addAuthor (author2);
			book2. addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);
		};}

}
