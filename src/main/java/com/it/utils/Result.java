package com.it.utils;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public Result() {
    }

    public Result(Object data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public Result(Object data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
