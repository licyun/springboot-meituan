package com.licyun.meituan.food.domain;

public class ShopResult<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 数量 */
    private Integer count;

    /** 具体内容 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
