package com.example.mybook.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class    Book {
    private Integer id;
    private String title;
    private String author;
    private Float price;
    private Float discount;
    private String bookConcern;
    private String imgUrl;
    private String bigImgUrl;
    private LocalDate publishDate;
    private String brief;
    private Integer inventory;
}
