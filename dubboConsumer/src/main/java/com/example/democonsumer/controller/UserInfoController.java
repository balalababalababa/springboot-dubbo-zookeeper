package com.example.democonsumer.controller;

import com.example.dubboAPI.UserInfoISV;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    @Reference(version = "1.0.0")
    private UserInfoISV userInfoISV;

    @GetMapping("/hello")
    public void sayHello (){
        System.out.println("******democonsumer被访问******");
        System.out.println(userInfoISV.sayHello());
    }
}
