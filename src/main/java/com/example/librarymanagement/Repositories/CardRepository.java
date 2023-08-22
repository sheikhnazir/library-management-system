package com.example.librarymanagement.Repositories;

import com.example.librarymanagement.Enums.Genre;
import com.example.librarymanagement.Models.Book;
import com.example.librarymanagement.Models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}