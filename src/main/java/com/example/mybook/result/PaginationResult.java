package com.example.mybook.result;

import com.example.mybook.persistence.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResult<T> extends DataResult<T>{
    private Long total;
}
