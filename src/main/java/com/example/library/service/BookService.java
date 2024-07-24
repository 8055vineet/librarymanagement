package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
   private BookRepository bookRepository;
    public List<Book> findAllBooks(){
       return bookRepository.findAll();
    }

    public Book findBookById(Long Id){
       Book book;
        book=bookRepository.findById(Id).orElseThrow(RuntimeException::new);
        return  book;
    }

    public  void createBook(Book book)
    {
        bookRepository.save(book);
    }
    public  void updateBook(Book book)
    {
        bookRepository.save(book);
    }
    public void deleteBook(Long Id)
    {
        bookRepository.deleteById(Id);

    }

}
