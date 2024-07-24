package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long Id){
        Author author;
        author=authorRepository.findById(Id).orElseThrow(RuntimeException::new);
        return  author;
    }

    public  void createAuthor(Author author)
    {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author)
    {
        authorRepository.save(author);
    }
    public void deleteAuthor(Long Id)
    {
        authorRepository.deleteById(Id);

    }
}
