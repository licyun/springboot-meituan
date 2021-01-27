package com.licyun.meituan.food.utils;

import com.licyun.meituan.food.domain.ShopResult;
import com.licyun.meituan.food.domain.ShopResult;

public class ShopResultUtil {

    /**
     * 数据验证成功后的操作方法
     * @param object 验证成功时传入的对象
     * @return
     */
    public static ShopResult success(Object object, Integer count){
        ShopResult ShopResult = new ShopResult();
        ShopResult.setCode(0);
        ShopResult.setMessage("success");
        ShopResult.setData(object);
        ShopResult.setCount(count);
        return ShopResult;
    }

    /**
     * 数据验证失败后的操作方法
     * @param code 自定义错误代码
     * @param message 默认的错误提示信息
     * @return
     */
    public static ShopResult error(Integer code, String message){
        ShopResult shopResult = new ShopResult();
        shopResult.setCode(code);
        shopResult.setMessage(message);
        return shopResult;

    }

}
