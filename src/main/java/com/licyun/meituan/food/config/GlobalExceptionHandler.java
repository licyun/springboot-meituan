package com.licyun.meituan.food.config;


import com.licyun.meituan.food.domain.ResultData;
import com.licyun.meituan.food.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultData<?> paramException(ConstraintViolationException e){
        log.info("paramException");
        return ResultUtil.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultData<?> entityException(MethodArgumentNotValidException e){
        log.info("entityException");
        StringBuilder errors = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage);
            errors.append(" ");
        });
        return ResultUtil.error(errors.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultData<?> otherException(Exception e){
        log.info("otherException");
        return ResultUtil.error(e.getMessage());
    }
}
