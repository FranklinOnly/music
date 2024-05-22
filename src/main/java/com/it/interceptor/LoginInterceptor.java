package com.it.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.utils.Result;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {


    private ObjectMapper mapper = new ObjectMapper();
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器");
//        HttpSession session = request.getSession();
//        Object username = session.getAttribute("username");
//        if (username==null)
//        {
//            //TODO 没有登录，需要前端自己跳转到登录页面
//            Result result = new Result(null, 2000, "没有登录");
//            String json = mapper.writeValueAsString(result);
//            response.setContentType("test/html;charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.write(json);
//            writer.flush();
//            return false;
//        }
        return true;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
