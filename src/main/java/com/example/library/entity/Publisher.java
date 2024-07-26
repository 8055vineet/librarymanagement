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
@Table(name = "publishers")
public class Publisher {
    public Publisher( String name, String description) {

        this.name = name;
        this.description = description;
    }
    public Publisher(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 50,nullable = false,unique = true)
    private  String name;

    @Column(name = "description",length = 300,nullable = false)
    private  String description;

    @ManyToMany(mappedBy = "publishers",cascade = CascadeType.ALL)
    private Set<Book> books=new HashSet<Book>();


}