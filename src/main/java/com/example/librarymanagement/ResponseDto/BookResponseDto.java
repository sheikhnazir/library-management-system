package com.example.librarymanagement.ResponseDto;

import com.example.librarymanagement.Enums.Genre;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private String title;

    private Boolean isAvailable;

    private Genre genre;

    private Date publicationDate;

    private Integer price;

    private String authorName;


}
