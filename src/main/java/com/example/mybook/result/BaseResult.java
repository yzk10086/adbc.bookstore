package com.example.mybook.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResult implements Serializable {
    private Integer code;
    private String msg;
}
