package com.licyun.meituan.food.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidateUtil {


    public boolean isMobileNO(String mobiles) {
        try {
            Pattern p = Pattern
                    .compile("(13[0-9]|14[57]|15[012356789]|18[02356789])\\d{8}");
            Matcher m = p.matcher(mobiles);
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkEmail(String email) {
        try {
            String check = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkUserName(String userName){
        boolean flag = false;
        if( userName.length() >=5 & userName.length() <=12){
            flag = true;
        }
        return flag;
    }

    public boolean checkUserPass(String userPass){
        boolean flag = false;
        if( userPass.length() >=6 & userPass.length() <=12){
            flag = true;
        }
        return flag;
    }
}
