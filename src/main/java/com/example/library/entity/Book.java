package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn",length = 30,nullable = false,unique = true)
    private  String isbn;

    @Column(name = "name",length = 100,nullable = false)
    private  String name;

    @Column(name = "description",length = 300,nullable = false)
    private  String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "book_author",
        inverseJoinColumns = {@JoinColumn(name="author_id")},
        joinColumns ={@JoinColumn(name="book_id")} )


private Set<Author> authors=new HashSet<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category",
            inverseJoinColumns = {@JoinColumn(name="category_id")},
            joinColumns ={@JoinColumn(name="book_id")} )


    private Set<Category> categories=new HashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher",
            inverseJoinColumns = {@JoinColumn(name="publisher_id")},
            joinColumns ={@JoinColumn(name="book_id")} )


    private Set<Publisher> publishers=new HashSet<Publisher>();

    public  void removePublisher(Publisher publisher)
    {
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }
    public  void addPublisher(Publisher publisher)
    {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }
    public  void removeAuthor(Author author)
    {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }
    public  void addAuthor(Author author)
    {
        this.authors.add(author);
        author.getBooks().add(this);
    }
    public  void removeCategory(Category category)
    {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }
    public  void addCategory(Category category)
    {
        this.categories.add(category);
        category.getBooks().add(this);
    }


}
