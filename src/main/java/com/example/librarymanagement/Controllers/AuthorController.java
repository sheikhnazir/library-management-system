package com.example.librarymanagement.Controllers;

import com.example.librarymanagement.Models.Author;
import com.example.librarymanagement.Repositories.AuthorRepository;
import com.example.librarymanagement.RequestDto.UpdateNameAndPenNameRequest;
import com.example.librarymanagement.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author) {

        try{
            String result = authorService.addAuthor(author);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateNameAndPenName")
    public String updateAuthorNameAndPenName(@RequestBody UpdateNameAndPenNameRequest updateNameAndPenNameRequest) {

        try{
            String result = authorService.updateNameAndPenName(updateNameAndPenNameRequest);
            return result;

        }catch (Exception e){
            return "Author Id is invalid"+e.getMessage();
        }
    }

    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("authorId")Integer authorId){

        return authorService.getAuthorById(authorId);

    }
}
