package com.example.librarymanagement.Controllers;

import com.example.librarymanagement.Enums.Genre;
import com.example.librarymanagement.RequestDto.AddBookRequestDto;
import com.example.librarymanagement.ResponseDto.BookResponseDto;
import com.example.librarymanagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody AddBookRequestDto addBookRequestDto){

        try{

            String result = bookService.addBook(addBookRequestDto);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByGenre")
    public ResponseEntity getBookListByGenre(@RequestParam("genre")Genre genre){
        List<BookResponseDto> responseDtoList = bookService.getBookListByGenre(genre);
        return new ResponseEntity(responseDtoList,HttpStatus.OK);
    }

}
