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
@Table(name = "authors")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn",length = 30,nullable = false,unique = true)
    private  int isbn;

    @Column(name = "name",length = 100,nullable = false)
    private  String name;

    @Column(name = "description",length = 300,nullable = false)
    private  String description;
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


}
