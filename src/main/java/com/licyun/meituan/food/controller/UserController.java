package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.ResultDataEnum;
import com.licyun.meituan.food.domain.ResultData;
import com.licyun.meituan.food.domain.User;
import com.licyun.meituan.food.repository.UserRepository;
import com.licyun.meituan.food.utils.ValidateUtil;
import com.licyun.meituan.food.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidateUtil validateUtil;

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String userRegister(){
        return "/register";
    }
    @ResponseBody
    @PostMapping("/register")
    public ResultData<?> userRegister(@Validated @RequestBody User user){
//        ResultData registerResultData = new ResultData();
//        //校验前端发来的数据
//        if(bindingResult.hasErrors()){
//            registerResultData = ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
//        }else{
//            user.setUserRole(1);
//            System.out.println("user:" + user.toString());
//            userRepository.save(user);
//            registerResultData = ResultUtil.success(ResultDataEnum.ERROR.getCode(), ResultDataEnum.ERROR.getMsg(), user);
//        }
        userRepository.save(user);
        ResultData<?> ResultData = ResultUtil.success();
        return ResultData;
    }

    /**
     * 登陆
     * @return
     */
    @GetMapping(value = {"/login", "/"})
    public String userLogin(){
        return "/login";
    }
    @ResponseBody
    @PostMapping({"/login", "/"})
    public ResultData<?> userLogin(@RequestBody User user,
                                HttpSession session){
        System.out.println("userEmail:" + user.toString());
        ResultData loginResultData = new ResultData();
        //校验登陆数据
        if( validateUtil.checkEmail(user.getUserEmail()) && validateUtil.checkUserPass(user.getUserPass()) ){
            User loginUser = userRepository.findByUserEmail( user.getUserEmail() );
            if( loginUser != null && user.getUserPass().equals(loginUser.getUserPass()) ){
                System.out.println(loginUser.toString());
                session.setAttribute("user",loginUser);
                loginResultData = ResultUtil.success(ResultDataEnum.SUCCESS.getCode(), ResultDataEnum.ERROR.getMsg(), loginUser);
            }
        }else{
            loginResultData = ResultUtil.error(ResultDataEnum.ERROR_LOGIN.getCode(), ResultDataEnum.ERROR_LOGIN.getMsg());
        }
        return loginResultData;
    }


}
