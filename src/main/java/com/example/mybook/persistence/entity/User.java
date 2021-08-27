package com.example.mybook.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String mobile;

    public User(int registerUser, String username, String password, String mobile) {
        this.id= registerUser;
        this.username=username;
        this.password=password;
        this.mobile=mobile;
    }
    public String toString(){
        return id.toString();
    }
}
