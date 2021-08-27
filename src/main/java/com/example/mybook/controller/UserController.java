package com.example.mybook.controller;

import com.example.mybook.persistence.entity.User;
import com.example.mybook.result.BaseResult;
import com.example.mybook.result.DataResult;
import com.example.mybook.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;
    @PostMapping("/login")
    BaseResult login(@RequestBody User user){

        DataResult result = new DataResult();
        result.setData(bookService.getLoginUser(user));
        result.setCode(200);
        result.setMsg("成功");
        return result;

    }
    @PostMapping("/register")
    BaseResult register(@RequestBody User user){
        DataResult result = new DataResult();
        user.setId(bookService.registerUser(user));
        result.setData(user);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
}
