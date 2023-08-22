package com.example.librarymanagement.Services;

import com.example.librarymanagement.Models.Author;
import com.example.librarymanagement.Repositories.AuthorRepository;
import com.example.librarymanagement.RequestDto.UpdateNameAndPenNameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(Author author) throws Exception {

        //Validation Checks
//        if(author.getAuthorId()!=null){
//            throw new Exception("Author Id should not be sent as a parameter");
//        }

        authorRepository.save(author);

        return "Author has been added successfully...";
    }

    public String updateNameAndPenName(UpdateNameAndPenNameRequest request) throws Exception {

        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());

        if(!optionalAuthor.isPresent()) {
            throw new Exception("Invalid Author Id...");
        }

        Author author = optionalAuthor.get();

        author.setName(request.getNewName());

        author.setPenName(request.getNewPenName());

        authorRepository.save(author);

        return "PenName and Author Name has been updated successfully ...";
    }

    public Author getAuthorById(Integer authorId){

        Author author = authorRepository.findById(authorId).get();
        return author;

    }

}
