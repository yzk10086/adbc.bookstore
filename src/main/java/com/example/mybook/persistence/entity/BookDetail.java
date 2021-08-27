package com.example.mybook.persistence.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BookDetail extends Book {
  private String detail;
  private Boolean newness;
  private Boolean hot;
  private Boolean specialOffer;
  private String slogan;
  private Category category;
}
