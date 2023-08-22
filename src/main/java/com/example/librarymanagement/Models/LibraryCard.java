package com.example.librarymanagement.Models;

import com.example.librarymanagement.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private Integer noOfBooksIssued;

    @OneToOne
    @JoinColumn
    private Student student; //you need to set the student object here.


    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();
}
