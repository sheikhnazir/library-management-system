package com.example.librarymanagement.Models;

import com.example.librarymanagement.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    public Book(String title, Boolean isAvailable, Genre genre, Date publicationDate, Integer price) {
        this.title = title;
        this.isAvailable = isAvailable;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    @Column(unique = true)
    private String title;

    private Boolean isAvailable;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Date publicationDate;

    private Integer price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();

}
