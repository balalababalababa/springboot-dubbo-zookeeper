package com.example.democonsumer.controller;

import com.example.dubboAPI.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    @Reference(version = "1.0.0")
    private UserService userService;


    @RequestMapping(value="index",method = {RequestMethod.GET})
    public String index(){//跳转注册页面
        return "index";
    }
    @RequestMapping(value="login",method = {RequestMethod.GET})
    public String login(){//跳转登录界面
        return "login";
    }
    @RequestMapping(value="register",method = {RequestMethod.GET})
    public String register(){//跳转注册页面
        return "register";
    }

    @GetMapping("hello1/{id}")
    public String sayHello (@PathVariable int id){
        System.out.println("******democonsumer被访问******");
       User user= userService.findUser(id);
       return user.toString();
    }
    @RequestMapping("dologin")
    @ResponseBody //@responsebody表示该方法的返回结果直接写入HTTP response body中
//一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
// 加上@responsebody后返回结果不会被解析为跳转路 径，而是直接写入HTTP response body中。
    public String getUser(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord) {//登录验证
        User user= userService.selectUser(userName,passWord);
        System.out.println(user);
        if(user==null){
            return "用户名或密码错误" ;
        }else {
            return "success";
        }
    }
    @RequestMapping("finduser")
    @ResponseBody
    public Map<String, Object> findUser(@RequestParam("userName") String userName){
        Map<String,Object> map = new HashMap<String,Object>();
        if(userService.getUser(userName)!=null){
            map.put("userExsit",true);
            map.put("msg","用户已存在");
        }else{
            map.put("userExsit",false);
            map.put("msg","该用户名可用");
        }
        return map;
    }
    @RequestMapping("doregist")
    public String doRegist(HttpServletRequest request){//处理注册
        userService.addUser(request.getParameter("userName"),request.getParameter("passWord"));
        return "index";
    }
}
