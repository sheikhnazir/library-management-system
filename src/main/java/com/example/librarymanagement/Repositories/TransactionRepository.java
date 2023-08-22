package com.example.librarymanagement.Repositories;

import com.example.librarymanagement.Enums.TransactionStatus;
import com.example.librarymanagement.Enums.TransactionType;
import com.example.librarymanagement.Models.Book;
import com.example.librarymanagement.Models.LibraryCard;
import com.example.librarymanagement.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


    List<Transaction> findTransactionsByBookAndLibraryCardAndTransactionStatusAndTransactionType(Book book, LibraryCard card, TransactionStatus transactionStatus, TransactionType transactionType);
}