package com.licyun.meituan.food.utils;

import com.licyun.meituan.food.domain.ResultDataEnum;
import com.licyun.meituan.food.domain.ResultData;

public class ResultUtil {

    /**
     * main 注释2
     * @return
     */
    public static ResultData<?> success(){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(ResultDataEnum.SUCCESS.getCode());
        resultData.setMsg(ResultDataEnum.SUCCESS.getMsg());
        resultData.setData(null);
        return resultData;

    }

    public static ResultData<?> success(String message){
        ResultData<?> resultData = new ResultData<>();
        resultData.setCode(ResultDataEnum.SUCCESS.getCode());
        resultData.setMsg(message);
        resultData.setData(null);
        return resultData;
    }

    public static ResultData<?> success(Integer count, Object data){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(ResultDataEnum.SUCCESS.getCode());
        resultData.setMsg(ResultDataEnum.SUCCESS.getMsg());
        resultData.setData(data);
        resultData.setCount(count);
        return resultData;
    }


    public static ResultData<?> success(Integer code, String message, Object object){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        resultData.setData(object);
        return resultData;
    }

    public static ResultData<?> success(Integer code, String msg, Integer count, Object data){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setCount(count);
        resultData.setData(data);
        return resultData;
    }

    public static ResultData<?> error(){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(ResultDataEnum.ERROR.getCode());
        resultData.setMsg(ResultDataEnum.ERROR.getMsg());
        resultData.setData(null);
        return resultData;
    }


    public static ResultData<?> error(String message){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(ResultDataEnum.ERROR.getCode());
        resultData.setMsg(message);
        resultData.setData(null);
        return resultData;
    }

    public static ResultData<?> error(Integer code, String message){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        resultData.setData(null);
        return resultData;
    }

    public static ResultData<?> error(Integer code, String message, Object object){
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(message);
        resultData.setData(object);
        return resultData;
    }
    
}
