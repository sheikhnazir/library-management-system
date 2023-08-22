package com.example.librarymanagement.Controllers;

import com.example.librarymanagement.Models.LibraryCard;
import com.example.librarymanagement.Models.Student;
import com.example.librarymanagement.Repositories.CardRepository;
import com.example.librarymanagement.Repositories.StudentRepository;
import com.example.librarymanagement.Services.LibraryCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/card")
@Slf4j
public class LibraryCardController {

    @Autowired
    LibraryCardService cardService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardRepository cardRepository;

    public String addCard(@RequestBody LibraryCard libraryCard) {

        return cardService.addCard(libraryCard);
    }

    @PutMapping("/issueToStudent")
    public ResponseEntity issueToStudent(@RequestParam("cardId")Integer cardId, @RequestParam("rollNo")Integer rollNo){

        try{

            String result =  cardService.associateToStudent(cardId,rollNo);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in associating card to student",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }
}
