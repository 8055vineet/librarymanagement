package com.example.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name",length = 50,nullable = false,unique = true)
        private  String name;
}
