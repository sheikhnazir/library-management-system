package com.example.librarymanagement.RequestDto;

import com.example.librarymanagement.Enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequestDto {

    private String title;
    private Boolean isAvailable;
    private Genre genre;
    private Date publicationDate;
    private Integer price;
    private Integer authorId;

}
