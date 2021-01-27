package com.licyun.meituan.food.handle;

import com.licyun.meituan.food.domain.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class LoginInterceptor implements HandlerInterceptor {
//    private Logger logger = (Logger) LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        User user = (User)request.getSession().getAttribute("user");
        if( user == null || user.equals("")){
            response.sendRedirect("/login");
//            logger.info("请先登陆");
            return false;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler) throws Exception{
//        logger.info("postHandle");
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler) throws Exception{
//        logger.info("afterCompletion");
    }

}
