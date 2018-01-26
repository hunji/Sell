package com.youhualife.exception;

import com.youhualife.enums.ResultEnum;

/**
 * created by guo19
 * created on 2018/1/25
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}