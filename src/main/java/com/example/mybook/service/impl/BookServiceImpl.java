package com.example.mybook.service.impl;

import com.example.mybook.persistence.dao.IBookDao;
import com.example.mybook.persistence.entity.*;
import com.example.mybook.service.BookService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private IBookDao bookDao;

    @Override
    public Book getBook(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public BookDetail getBookDetail(int id) {
        return bookDao.getBookDetailById(id);
    }

    @Override
    public Comment[] getBookComment(int book_id) {
        return bookDao.getBookComment(book_id);
    }

    @Override
    public Category getBookCategory(int category_id) {
        return bookDao.getBookCategory(category_id);
    }

    @Override
    public Category[] getAllCategory() {
        return bookDao.getAllCategory();
    }

    @Override
    public List<Book> getCategoryBooksByPage(int catId, int pageNum, int pageSize) {
        return bookDao.getCategoryBooksByPage(catId, pageNum, pageSize);
    }

    @Override
    public List<Book> getBooksByWord(String wd, int pageNum, int pageSize) {
        return bookDao.getBooksByWord(wd, pageNum, pageSize);
    }

    @Override
    public User getLoginUser(User user) {
        return bookDao.getLoginUser(user);
    }

    @Override
    public int registerUser(User user) {
        bookDao.registerUser(user);
        if(user.getId()==null)return -1;
        return user.getId();
    }

    @Value("${server.servlet.context-path}")
    private String contextPath;


    @Override
    public List<Book> getHotBook() {
        List<Book> books = bookDao.getBookByHot();
        for (Book book: books){
            book.setImgUrl(contextPath + "/img/" +  book.getImgUrl());
            book.setBigImgUrl(contextPath + "/img/" +  book.getBigImgUrl());
        }
        return books;
    }

    @Override
    public List<Book> getNewBook() {
        return bookDao.getBookByNew();
    }

    @Override
    public List<Book> getCategoryBook(int id) {
        return bookDao.getBookByCategory(id);
    }

}
