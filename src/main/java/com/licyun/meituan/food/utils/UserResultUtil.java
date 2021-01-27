package com.licyun.meituan.food.utils;

import com.licyun.meituan.food.domain.UserResult;

public class UserResultUtil {

    /**
     * 数据验证成功后的操作方法
     * @param object 验证成功时传入的对象
     * @return
     */
    public static UserResult success(Object object){
        UserResult userResult = new UserResult();
        userResult.setCode(1);
        userResult.setMessage("success");
        userResult.setData(object);
        return userResult;
    }

    /**
     * 数据验证失败后的操作方法
     * @param code 自定义错误代码
     * @param message 默认的错误提示信息
     * @return
     */
    public static UserResult error(Integer code, String message){
        UserResult userResult = new UserResult();
        userResult.setCode(code);
        userResult.setMessage(message);
        return userResult;

    }
}
