package com.licyun.meituan.food.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultDataEnum {

    SUCCESS(200, "成功"),
    SUCCESS_SHOP(0, "成功"),
    ERROR( 400, "错误"),
    ERROR_MULTI( 420, "多种错误"),
    ERROR_LOGIN(421, "邮箱或密码不正确"),
    ERROR_REGISTER(422, "邮箱已存在"),
    ERROR_UPDATE_EMAIL(423, "邮箱已存在"),
    ERROR_UPDATE(424, "用户名和密码格式不正确")
    ;


    private Integer code;
    private String msg;

}
