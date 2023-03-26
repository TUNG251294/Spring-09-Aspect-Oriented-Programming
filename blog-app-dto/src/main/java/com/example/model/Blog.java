package com.example.model;

import javax.persistence.*;
@Entity
@Table(name = "blogs")

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "`name`");

    private String name;
    private String author;

    private String access;
//    @Column(name = "created_date")
//    private LocalDate createdDate;


    public Blog() {
    }

    public Blog(Long id, String name, String author, String access) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.access = access;
    }
    public Blog(String name, String author, String access) {
        super();
        this.name = name;
        this.author = author;
        this.access = access;
    }

//    public Blog(Long id, String name, String author, String access, LocalDate createdDate) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.access = access;
//        this.createdDate = createdDate;
//    }

//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }


}
