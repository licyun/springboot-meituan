package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.ShopResult;
import com.licyun.meituan.food.domain.UserResult;
import com.licyun.meituan.food.domain.User;
import com.licyun.meituan.food.repository.UserRepository;
import com.licyun.meituan.food.utils.ValidateUtil;
import com.licyun.meituan.food.utils.UserResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
        return "/register.html";
    }
    @ResponseBody
    @PostMapping("/register")
    public UserResult userRegister(@Valid @RequestBody User user, BindingResult bindingResult){
        UserResult registerUserResult = new UserResult();
        //校验前端发来的数据
        if(bindingResult.hasErrors()){
            registerUserResult = UserResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }else{
            user.setUserRole(1);
            System.out.println("user:" + user.toString());
            userRepository.save(user);
            registerUserResult = UserResultUtil.success(user);
        }
        return registerUserResult;
    }

    /**
     * 登陆
     * @return
     */
    @GetMapping("/")
    public String userIndex(){
        return "/login.html";
    }
    @GetMapping("/login")
    public String userLogin(){
        return "/login.html";
    }
    @ResponseBody
    @PostMapping("/login")
    public UserResult userLogin(@RequestBody User user,
                                HttpSession session){
        System.out.println("userEmail:" + user.toString());
        UserResult loginUserResult = new UserResult();
        //校验登陆数据
        if( validateUtil.checkEmail(user.getUserEmail()) && validateUtil.checkUserPass(user.getUserPass()) ){
            User loginUser = userRepository.findByUserEmail( user.getUserEmail() );
            if( loginUser != null && user.getUserPass().equals(loginUser.getUserPass()) ){
                System.out.println(loginUser.toString());
                session.setAttribute("user",loginUser);
                loginUserResult = UserResultUtil.success(loginUser);
            }
        }else{
            loginUserResult = UserResultUtil.error(0, "邮箱或密码不正确");
        }
        return loginUserResult;
    }

    @ResponseBody
    @GetMapping(value = "/admin/get-menu")
    public UserResult getMenu(){
        UserResult userResult = UserResultUtil.error(0, "没有权限");
        return userResult;
    }
}
