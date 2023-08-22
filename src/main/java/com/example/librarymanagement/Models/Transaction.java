package com.example.librarymanagement.Models;

import com.example.librarymanagement.Enums.TransactionStatus;
import com.example.librarymanagement.Enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;


    private Integer fineAmount;

    public Transaction(TransactionStatus transactionStatus, TransactionType transactionType, Integer fineAmount) {
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.fineAmount = fineAmount;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private LibraryCard libraryCard;


}
