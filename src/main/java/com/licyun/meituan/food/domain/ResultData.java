package com.licyun.meituan.food.domain;

import lombok.Data;

@Data
public class ResultData<T> {

    private Integer code;   //返回代码
    private String msg;     //提示信息
    private Integer count;     //返回数量
    private T data;  //返回对象

}
