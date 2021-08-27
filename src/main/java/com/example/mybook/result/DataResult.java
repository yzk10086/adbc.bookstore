package com.example.mybook.result;

import lombok.Data;

@Data
public class DataResult<T> extends BaseResult{
    private T data;
}
