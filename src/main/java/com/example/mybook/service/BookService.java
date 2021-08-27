package com.example.mybook.service;


import com.example.mybook.persistence.entity.*;
import net.sf.json.JSONObject;

import java.util.List;

public interface BookService {
    Book getBook(int id);

    BookDetail getBookDetail(int id);

    Comment[] getBookComment(int book_id);

    Category getBookCategory(int category_id);

    Category[] getAllCategory();

    List<Book> getCategoryBooksByPage(int catId, int pageNum, int pageSize);

    List<Book> getBooksByWord(String wd, int pageNum, int pageSize);

    User getLoginUser(User user);

    int registerUser(User user);

    List<Book> getHotBook();

    List<Book> getNewBook();

    List<Book> getCategoryBook(int id);
}
