package com.example.librarymanagement.Controllers;

import com.example.librarymanagement.Enums.Department;
import com.example.librarymanagement.Models.Student;
import com.example.librarymanagement.Services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Slf4j   //@Slf4j stands for "Simple Logging Facade for Java," and it's used to automatically generate log fields in your classes
        // without manually creating a logger instance. It's a part of the Lombok library
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){

        try{
            String result = studentService.addStudent(student);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Student not added successfully {}",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/findDeptById")
    public ResponseEntity findDeptById(@RequestParam("Id")Integer Id){

        try{
            Department department = studentService.getDepartmentById(Id);
            return new ResponseEntity(department,HttpStatus.OK);
        }catch (Exception e){
            log.error("Department not found/Invalid Request {}",e.getMessage());
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        }
    }
}