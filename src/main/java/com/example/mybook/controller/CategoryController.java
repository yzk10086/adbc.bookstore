package com.example.mybook.controller;
import com.example.mybook.result.BaseResult;
import com.example.mybook.result.DataResult;
import com.example.mybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private BookService bookService;
    //2--1获取所有顶层分类信息，同时子分类与后代分类信息也同时获取
    @GetMapping("")
    BaseResult getAllCategory() {
        DataResult result = new DataResult();
        result.setData(bookService.getAllCategory());
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
}