package com.it.controller;

import com.it.domain.User;
import com.it.service.UserService;
import com.it.utils.Code;
import com.it.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession httpSession, HttpServletResponse response){
        User loginUser=userService.findUserByUserName(user.getUsername());
        Integer code=0;
        String msg="";
        if(loginUser==null || !loginUser.getPassword().equals(user.getPassword())){
            code= Code.GET_ERR;
            msg="账号或密码错误！请重试!";
            return new Result(new User(),code,msg);
        }else {
            code = Code.GET_OK;
            msg = "登录成功！";
        }
        httpSession.setAttribute("username",loginUser);
        return new Result(loginUser,code,msg);
    }

    @PostMapping("/logout")
    public Result login(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        Integer code=0;
        String msg="";
        code= Code.GET_ERR;
        msg="退出登录！";
        return new Result(msg,code,msg);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpSession httpSession, HttpServletResponse response){
        int i=0;
        Integer code=0;
        String msg="";
        if(userService.findUserByUserName(user.getUsername())==null) {
            i = userService.addUser(user);
        }
        if(i==0){
            code= Code.GET_ERR;
            msg="注册失败！请重试!";
            return new Result(i,code,msg);
        }else {
            code = Code.GET_OK;
            msg = "注册成功！";
        }
        return new Result(i,code,msg);
    }

    @GetMapping("/find")
    public Result findAllUser(){
        List<User> list=userService.findAllUser();
        Integer code=list!=null?Code.GET_OK:Code.GET_ERR;
        String msg=list!=null?"查询用户成功！":"数据查询失败，请重试！";
        return new Result(list,code,msg);
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody User user){
        int i = userService.addUser(user);
        Integer code=i!=0?Code.SAVE_OK:Code.SAVE_ERR;
        String msg=i!=0?"添加成功！":"数据添加失败，请重试！";
        return new Result(i,code,msg);
    }

    @DeleteMapping("/delete/{id}")
    public Result delUser(@PathVariable("id") Integer id){
        int i=userService.delUser(id);
        Integer code=i!=0?Code.DELETE_OK:Code.DELETE_ERR;
        String msg=i!=0?"用户删除成功！":"数据删除失败，请重试！";
        return new Result(i,code,msg);
    }
}
