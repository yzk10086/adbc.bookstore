package com.example.mybook.controller;

import com.example.mybook.persistence.entity.Book;
import com.example.mybook.result.BaseResult;
import com.example.mybook.result.PaginationResult;
import com.example.mybook.service.BookService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private BookService bookService;
    @GetMapping("")
    public ResponseEntity<BaseResult> getBooksByWord(
            @RequestParam("wd") String wd, @RequestParam int pageNum, @RequestParam int pageSize){
        List<Book> books = bookService.getBooksByWord(wd, pageNum, pageSize);
        //translateBookImgUrl(books);
        long total = ((Page)books).getTotal();
        PaginationResult<List<Book>> result = new PaginationResult<List<Book>>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(books);
        result.setTotal(total);
        return ResponseEntity.ok(result);
    }
}