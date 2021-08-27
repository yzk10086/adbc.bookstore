package com.example.mybook.controller;
import com.example.mybook.persistence.entity.Book;
import com.example.mybook.result.*;
import com.example.mybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.Page;
import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;

    //——1——获取所有热点图书

    @GetMapping("/hot")
    List<Book> getHotBook() {
        return bookService.getHotBook();
    }

    //——2——获取所有新上市图书

    @GetMapping("/new")
    List<Book> getNewBook() {
        return bookService.getNewBook();
    }

    //——3——获取某个分类下的所有图书

    @GetMapping("/category/{id}")
    List<Book> getCategoryBook(@PathVariable int id) {
        return bookService.getCategoryBook(id);
    }

    //——4——根据图书ID获取单本图书信息
    @GetMapping("/{id}")
    BaseResult getBookDetail(@PathVariable int id) {
        DataResult result = new DataResult();
        result.setData(bookService.getBookDetail(id));
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    //——5——根据图书ID获取某本图书的所有评论信息
    @GetMapping("/{id}/comment")
    BaseResult getBookComment(@PathVariable int id) {
        DataResult result = new DataResult();
        result.setData(bookService.getBookComment(id));
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    //——6——获取某个分类下按分页显示的图书
    @GetMapping("/page")
    public ResponseEntity<BaseResult> getCategoryBooksByPage(
            @RequestParam("category") int id, @RequestParam int pageNum, @RequestParam int pageSize){
        List<Book> books = bookService.getCategoryBooksByPage(id, pageNum, pageSize);
        long total = ((Page)books).getTotal();
        PaginationResult<List<Book>> result = new PaginationResult<List<Book>>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(books);
        result.setTotal(total);
        return ResponseEntity.ok(result);
    }

}
