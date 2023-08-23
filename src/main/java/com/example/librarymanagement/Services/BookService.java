package com.example.librarymanagement.Services;

import com.example.librarymanagement.Enums.Genre;
import com.example.librarymanagement.Models.Author;
import com.example.librarymanagement.Models.Book;
import com.example.librarymanagement.Repositories.AuthorRepository;
import com.example.librarymanagement.Repositories.BookRepository;
import com.example.librarymanagement.RequestDto.AddBookRequestDto;
import com.example.librarymanagement.RequestDto.UpdateNameAndPenNameRequest;
import com.example.librarymanagement.ResponseDto.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(AddBookRequestDto request) throws Exception {

        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());

        if(!optionalAuthor.isPresent()) {

            throw new Exception("Invalid Author Id provided...");
        }

        Author author = optionalAuthor.get();

        Book book = new Book(request.getTitle(),request.getIsAvailable(),request.getGenre(),request.getPublicationDate(),request.getPrice());

        //Entities will go inside the database and entities will only come out from Db

        //Got the book Object

        //Set the FK variables

        //Since it's a bidirectional : need to set both in child and parent class

        //Set the parent entity in child class

        bookRepository.save(book);

        List<Book> bookList= author.getBookList();

        author.setBookList(bookList);

        authorRepository.save(author);

        return "Book has been added successfully...";
    }

    public List<BookResponseDto> getBookListByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBooksByGenre(genre);
        List<BookResponseDto> responseList = new ArrayList<>();

        for(Book book : bookList){

            BookResponseDto bookResponseDto = new BookResponseDto(book.getTitle(),
                    book.getIsAvailable(),book.getGenre(),
                    book.getPublicationDate(),book.getPrice(),book.getAuthor().getName());

            responseList.add(bookResponseDto);
        }
        return responseList;
    }

    public Book getBookDetails(Integer bookId) throws Exception {

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(!optionalBook.isPresent()) {
            throw new Exception("Invalid book-Id provided");
        }

        Book book = optionalBook.get();

        return book;
    }
}
