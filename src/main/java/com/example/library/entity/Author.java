package com.example.library.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "name",length = 100,nullable = false,unique = true)
private  String name;

@Column(name = "description",length = 300,nullable = false)
private  String description;

@ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
private Set<Book> books=new HashSet<Book>();


}
