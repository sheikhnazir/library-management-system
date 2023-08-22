package com.example.librarymanagement.Repositories;

import com.example.librarymanagement.Enums.Genre;
import com.example.librarymanagement.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findBooksByGenre(Genre genre);

    List<Book> findBooksByIsAvailableFalse();
}